package com.bank.fin.ui;

import com.bank.fin.model.Atm;
import com.bank.fin.model.AtmAllocation;
import com.bank.fin.model.ClientAccount;
import com.bank.fin.model.Denomination;
import com.bank.fin.repositories.AtmRepository;
import com.bank.fin.repositories.ClientRepository;
import com.bank.fin.services.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WithdrawCashController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientAccountService clientAccountService;

    @Autowired
    private AtmRepository atmRepository;

//    @PostMapping(value = {"/withdrawCash"})
//    public String dddd(Model mv, @RequestParam(value = "clientId", required = false) Integer clientId) {
//        List<ClientAccount> clientAccounts = clientAccountService.getTransactionalAccountBalances(clientId);
////        ModelAndView mv = new ModelAndView("");
//        if(clientAccounts.isEmpty()) {
//            mv.addAttribute("clients", clientRepository.findAll());
//            mv.addAttribute("clientId", clientId);
//            mv.addAttribute("errorMessage", "No transaction accounts");
//            return "/withdrawCash";
//        } else {
//            mv.addAttribute("clientAccounts", clientAccounts);
//            mv.addAttribute("clients", clientRepository.findAll());
//            mv.addAttribute("clientId", clientId);
//
//
//            return "/withdrawCash";
//        }
//
//    }

    @PostMapping(value = {"/withdrawCash"})
    public String getClientTransactionAccountBalances(Model mv, @RequestParam(value = "clientId", required = false) Integer clientId,
                                                            @RequestParam(value = "accountId", required = false)String accountId,
                                                            @RequestParam(value = "amount", required = false) BigDecimal amount,
                                                            @RequestParam(value = "atmId", required = false) Integer atmId) {
        List<ClientAccount> clientAccounts = clientAccountService.getTransactionalAccountBalances(clientId);
        if(clientAccounts.isEmpty()) {
            mv.addAttribute("clients", clientRepository.findAll());
            mv.addAttribute("clientId", clientId);
            mv.addAttribute("errorMessage", "No transaction accounts");
            return "withdrawCash";
        } else {
            mv.addAttribute("clientAccounts", clientAccounts);
            mv.addAttribute("clients", clientRepository.findAll());
            mv.addAttribute("clientId", clientId);
            if(accountId != null) {
                mv.addAttribute("accountNumber", accountId);
                if(amount != null) {
                    mv.addAttribute("amount", amount);
                    ClientAccount clientAccount = clientAccountService.getTransactionalAccountBalance(clientId, accountId);
                    if (amount.compareTo(clientAccount.getDisplayBalance()) > 0) {
                        mv.addAttribute("errorMessage", "Insufficient funds");
                    } else {
                        List<Atm> atms = atmRepository.findAll();
                        mv.addAttribute("atm", atms);
                        if (atmId != null) {
                            mv.addAttribute("atmId", atmId);
                            Atm atm = getAtm(atms, atmId);
                            if (atm.getAtmAllocations().isEmpty()) {
                                mv.addAttribute("errorMessage", "ATM not registered or unfunded");
                            } else {
                                BigDecimal bigDecimal = BigDecimal.ZERO;
                                List<WithdrawCashModel> withdrawCashModels = new ArrayList<>();
                                for (AtmAllocation atmAllocation : atm.getAtmAllocations()) {
                                    Denomination denomination = atmAllocation.getDenomination();
                                    int count = 0;
                                    /*Adding amount on each denomination count and verifying is the required amount fulfilled or not
                                     * IF the required amount exceeds  */
                                    for (int i = 0; i < atmAllocation.getCount(); i++) {
                                        bigDecimal = bigDecimal.add(denomination.getValue());
                                        i++;
                                        count += 1;
                                        if (bigDecimal.compareTo(amount) == 0) {
                                            WithdrawCashModel w = getWithdrawCashModel(accountId, amount, atm, denomination, count);
                                            withdrawCashModels.add(w);
                                            mv.addAttribute("withdrawCashModels", withdrawCashModels);
                                            return "viewWithdrawDetails";
                                        } else if (bigDecimal.compareTo(amount) > 0) {
                                            bigDecimal = bigDecimal.subtract(denomination.getValue());
                                            count -= 1;
                                            break;
                                        }
                                    }
                                    WithdrawCashModel w = getWithdrawCashModel(accountId, amount, atm, denomination, count);
                                    withdrawCashModels.add(w);
                                }
                                if (bigDecimal.compareTo(amount) < 0) {
                                    mv.addAttribute("errorMessage", "Amount not available, would you like to draw " + bigDecimal);
                                }

                            }
                        }


                    }
                }

            }
            return "withdrawCash";
        }

    }

    private WithdrawCashModel getWithdrawCashModel(String accountId, BigDecimal amount, Atm atm, Denomination denomination, int count) {
        WithdrawCashModel w = new WithdrawCashModel();
        w.setAccountNumber(accountId);
        w.setAmount(amount);
        w.setAtmLocation(atm.getLocation());
        w.setCount(count);
        w.setDenomination(denomination);
        BigDecimal totalValue = denomination.getValue().multiply(BigDecimal.valueOf(count));
        w.setWithDrawingAmount(totalValue);
        return w;
    }

    private Atm getAtm(List<Atm> atms, Integer atmId) {
        for(Atm atm : atms) {
            if(atmId == atm.getAtmId()) {
                return atm;
            }
        }
        return null;
    }
}
