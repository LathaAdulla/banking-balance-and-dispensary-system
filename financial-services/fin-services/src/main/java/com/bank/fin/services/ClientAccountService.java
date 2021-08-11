package com.bank.fin.services;

import com.bank.fin.model.ClientAccount;
import com.bank.fin.model.ClientAccountCurrencyConversion;
import com.bank.fin.model.ClientAccountReportModel;

import java.util.List;


public interface ClientAccountService {

		List<ClientAccount> getTransactionalAccountBalances(Integer clientId);
		ClientAccount getTransactionalAccountBalance(Integer clientId, String accountNumber);
		List<ClientAccountCurrencyConversion> getCurrencyAccountBalances(Integer clientId);
		List<ClientAccountReportModel> getClientAccountReportDetails();
}
