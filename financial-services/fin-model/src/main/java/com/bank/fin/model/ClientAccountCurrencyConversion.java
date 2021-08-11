package com.bank.fin.model;

import java.math.BigDecimal;

public class ClientAccountCurrencyConversion {

    private String clientAccountNumber;
    private String currencyCode;
    private BigDecimal currencyBalance;
    private BigDecimal conversionRate;
    private BigDecimal convertedZARAmount;
    private Integer decimalPlaces;

    public String getClientAccountNumber() {
        return clientAccountNumber;
    }

    public void setClientAccountNumber(String clientAccountNumber) {
        this.clientAccountNumber = clientAccountNumber;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getCurrencyBalance() {
        return currencyBalance;
    }

    public void setCurrencyBalance(BigDecimal currencyBalance) {
        this.currencyBalance = currencyBalance;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public BigDecimal getConvertedZARAmount() {
        return convertedZARAmount;
    }

    public void setConvertedZARAmount(BigDecimal convertedZARAmount) {
        this.convertedZARAmount = convertedZARAmount;
    }

    public Integer getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(Integer decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }
}
