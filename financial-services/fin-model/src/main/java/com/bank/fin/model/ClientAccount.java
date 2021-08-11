package com.bank.fin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class ClientAccount implements Serializable{
	
	private static final long serialVersionUID = -8474950342304717100L;

	@Id
	@Column(name="CLIENT_ACCOUNT_NUMBER")
	private String clientAccountNumber;
	
	@Column(name="CLIENT_ID")
	private Integer clientId;
	
	@OneToOne
	@JoinColumn(name="ACCOUNT_TYPE_CODE", referencedColumnName="ACCOUNT_TYPE_CODE")
	private AccountType accountType;

	@OneToOne
	@JoinColumn(name="CURRENCY_CODE", referencedColumnName="CURRENCY_CODE")
	private Currency currency;
	
	@Column(name="DISPLAY_BALANCE")
	private BigDecimal displayBalance;

	public String getClientAccountNumber() {
		return clientAccountNumber;
	}

	public void setClientAccountNumber(String clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public BigDecimal getDisplayBalance() {
		return displayBalance;
	}

	public void setDisplayBalance(BigDecimal displayBalance) {
		this.displayBalance = displayBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((clientAccountNumber == null) ? 0 : clientAccountNumber.hashCode());
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((displayBalance == null) ? 0 : displayBalance.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientAccount other = (ClientAccount) obj;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (clientAccountNumber == null) {
			if (other.clientAccountNumber != null)
				return false;
		} else if (!clientAccountNumber.equals(other.clientAccountNumber))
			return false;
		if (clientId != other.clientId)
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency)) {
			return false;
		} else if (!displayBalance.equals(other.displayBalance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClientAccount [clientAccountNumber=" + clientAccountNumber + ", clientId=" + clientId
				+ ", accountType=" + accountType + ", currency=" + currency + ", displayBalance="
				+ displayBalance + "]";
	}
	
}