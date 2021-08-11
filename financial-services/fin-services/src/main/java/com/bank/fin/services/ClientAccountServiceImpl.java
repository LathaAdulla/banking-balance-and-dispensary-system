package com.bank.fin.services;

import com.bank.fin.model.Client;
import com.bank.fin.model.ClientAccount;
import com.bank.fin.model.ClientAccountCurrencyConversion;
import com.bank.fin.model.ClientAccountReportModel;
import com.bank.fin.model.CurrencyConversionRate;
import com.bank.fin.repositories.ClientAccountRepository;
import com.bank.fin.repositories.ClientRepository;
import com.bank.fin.repositories.CurrencyConversionRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientAccountServiceImpl implements ClientAccountService {

    @Autowired
    private ClientAccountRepository clientAccountRepository;
    
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CurrencyConversionRateRepository currencyConversionRateRepository;

    /* This will get the client transactional accounts in descending order  of balances by client */
    @Override
    public List<ClientAccount> getTransactionalAccountBalances(Integer clientId) {
        return clientAccountRepository.findByClientIdAndAccountType_TransactionalTrueOrderByDisplayBalanceDesc(clientId);
    }

    /* This will get the client transactional accounts in descending order  of balances by client */
    @Override
    public ClientAccount getTransactionalAccountBalance(Integer clientId, String accountNumber) {
        return clientAccountRepository.findByClientIdAndClientAccountNumber(clientId, accountNumber);
    }


    /* This will get the client currency accounts in descending order of balances by client */
    @Override
    public List<ClientAccountCurrencyConversion> getCurrencyAccountBalances(Integer clientId) {
        List<ClientAccountCurrencyConversion> currencyConversions = new ArrayList<>();
        List<ClientAccount> clientAccounts = clientAccountRepository.findByClientIdOrderByDisplayBalanceAsc(clientId);
        for (ClientAccount clientAccount : clientAccounts) {
            String currencyCode = clientAccount.getCurrency().getCurrencyCode();
            if (!"ZAR".equals(currencyCode)) {
                ClientAccountCurrencyConversion currencyConversion = new ClientAccountCurrencyConversion();
                currencyConversion.setClientAccountNumber(clientAccount.getClientAccountNumber());
                currencyConversion.setCurrencyCode(currencyCode);
                currencyConversion.setDecimalPlaces(clientAccount.getCurrency().getDecimalplaces());

                BigDecimal displayBalance = clientAccount.getDisplayBalance();
                currencyConversion.setCurrencyBalance(displayBalance);

                CurrencyConversionRate conversionRate = currencyConversionRateRepository.findByCurrencyCode(currencyCode);
                currencyConversion.setConversionRate(conversionRate.getRate());
                BigDecimal convertedZARAmount = BigDecimal.ZERO;
                if ("*".equals(conversionRate.getConversionIndicator())) {
                    convertedZARAmount = displayBalance.multiply(conversionRate.getRate());
                } else if ("/".equals(conversionRate.getConversionIndicator())) {
                    convertedZARAmount = displayBalance.divide(conversionRate.getRate(), 0,
                            BigDecimal.ROUND_DOWN);
                }
                currencyConversion.setConvertedZARAmount(convertedZARAmount);

                currencyConversions.add(currencyConversion);
            }
        }

        return currencyConversions;
    }
    @Override
    public List<ClientAccountReportModel> getClientAccountReportDetails() {
        List<ClientAccountReportModel> clientReportModels = new ArrayList<>();
        List<Client> clients = clientRepository.findAll();
        for (Client client : clients) {
            BigDecimal highestBalance = BigDecimal.ZERO;
            List<ClientAccount> clientAccounts = client.getClientAccounts();
            if(clientAccounts != null && !clientAccounts.isEmpty()) {
                ClientAccount clientAccountH = null;
                for (ClientAccount clientAccount : clientAccounts) {
                    if (clientAccount.getAccountType().isTransactional() &&
                            highestBalance.compareTo(clientAccount.getDisplayBalance()) < 0) {
                        highestBalance = clientAccount.getDisplayBalance();
                        clientAccountH = clientAccount;
                    }
                }
                if (clientAccountH != null) {
                  //Add client id and surname from client object
                    ClientAccountReportModel reportModel = new ClientAccountReportModel();
                    reportModel.setClientId(client.getClientId());
                    reportModel.setClientSurname(client.getSurname());
                    //Add client account number, account type and display balance from client account object
                    reportModel.setClientAccountNumber(clientAccountH.getClientAccountNumber());
                    reportModel.setAccountDescription(clientAccountH.getAccountType().getDescription());
                    reportModel.setDisplayBalance(clientAccountH.getDisplayBalance());
                    clientReportModels.add(reportModel);
                }
            }


        }

        return clientReportModels;
    }
}
