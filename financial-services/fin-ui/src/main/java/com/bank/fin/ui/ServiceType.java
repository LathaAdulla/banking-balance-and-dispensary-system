package com.bank.fin.ui;

public enum ServiceType {
    TRANSACTIONAL_ACCOUNT_BALANCES("Transaction Account Balances"),
    CURRENCY_ACCOUNT_BALANCES("Currency Account Balances"),
    WITHDRAW_CASH("Withdraw Cash");

    private String description;

    ServiceType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
