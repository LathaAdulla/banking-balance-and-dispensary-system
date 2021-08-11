package com.bank.fin.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ClientAccountReportModel implements Serializable {

	private static final long serialVersionUID = -8486553472181744586L;
	
	private Integer clientId;
    private String clientAccountNumber;
    private String clientSurname;
    private String accountDescription;
    private BigDecimal displayBalance;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientAccountNumber() {
        return clientAccountNumber;
    }

    public void setClientAccountNumber(String clientAccountNumber) {
        this.clientAccountNumber = clientAccountNumber;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public BigDecimal getDisplayBalance() {
        return displayBalance;
    }

    public void setDisplayBalance(BigDecimal displayBalance) {
        this.displayBalance = displayBalance;
    }

}
