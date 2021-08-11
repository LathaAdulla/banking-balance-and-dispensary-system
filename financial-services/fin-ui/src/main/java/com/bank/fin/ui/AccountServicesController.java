package com.bank.fin.ui;

import com.bank.fin.model.ClientAccount;
import com.bank.fin.model.ClientAccountCurrencyConversion;
import com.bank.fin.repositories.ClientRepository;
import com.bank.fin.services.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AccountServicesController {

    @Autowired
    private ClientAccountService clientAccountService;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping(value = {"/processService"})
    public ModelAndView processService(String serviceId, Integer clientId) {
        ModelAndView modelAndView = null;
        switch (serviceId) {
            case "TRANSACTIONAL_ACCOUNT_BALANCES":
                modelAndView  = new ModelAndView("transactionalAccounts");
                modelAndView.addObject("clients", clientRepository.findAll());
                return modelAndView;
            case "CURRENCY_ACCOUNT_BALANCES":
                modelAndView  = new ModelAndView("currencyAccounts");
                modelAndView.addObject("clients", clientRepository.findAll());
                return modelAndView;
            case "WITHDRAW_CASH":
                modelAndView  = new ModelAndView("withdrawCash");
                modelAndView.addObject("clients", clientRepository.findAll());
                return modelAndView;
        }
        return null;

    }

    @PostMapping(value = {"/transactionalBalances"})
    public ModelAndView getClientTransactionAccountBalances(Integer clientId) {
        List<ClientAccount> clientAccounts = clientAccountService.getTransactionalAccountBalances(clientId);
        if(clientAccounts.isEmpty()) {
            ModelAndView mv = new ModelAndView("transactionalAccounts");
            mv.addObject("clients", clientRepository.findAll());
            mv.addObject("errorMessage", "No accounts to display");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("viewTransactionalAccounts");
            mv.addObject("clientAccounts", clientAccounts);
            return mv;
        }

    }

    @PostMapping(value = {"/currencyBalances"})
    private ModelAndView getClientCurrencyAccountBalances(Integer clientId) {
        List<ClientAccountCurrencyConversion> currencyConversions = clientAccountService.getCurrencyAccountBalances(clientId);
        if(currencyConversions.isEmpty()) {
            ModelAndView mv = new ModelAndView("currencyAccounts");
            mv.addObject("clients", clientRepository.findAll());
            mv.addObject("errorMessage", "No accounts to display");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("viewCurrencyAccounts");
            mv.addObject("currencyConversions", currencyConversions);
            return mv;
        }
    }

}
