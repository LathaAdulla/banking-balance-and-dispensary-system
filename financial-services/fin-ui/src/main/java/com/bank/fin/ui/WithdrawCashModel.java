package com.bank.fin.ui;

import com.bank.fin.model.Denomination;

import java.math.BigDecimal;

public class WithdrawCashModel {

    private String accountNumber;
    private Integer count;
    private Denomination denomination;
    private BigDecimal amount;
    private BigDecimal withDrawingAmount;
    private String atmLocation;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public void setDenomination(Denomination denomination) {
        this.denomination = denomination;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getWithDrawingAmount() {
        return withDrawingAmount;
    }

    public void setWithDrawingAmount(BigDecimal withDrawingAmount) {
        this.withDrawingAmount = withDrawingAmount;
    }

    public String getAtmLocation() {
        return atmLocation;
    }

    public void setAtmLocation(String atmLocation) {
        this.atmLocation = atmLocation;
    }
}
