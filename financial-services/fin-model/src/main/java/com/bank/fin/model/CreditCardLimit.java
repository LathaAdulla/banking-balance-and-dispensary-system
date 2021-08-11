package com.bank.fin.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCardLimit implements Serializable{

	private static final long serialVersionUID = 6412329995747203281L;

	@Id
	@Column(name="CLIENT_ACCOUNT_NUMBER")
	private String clientAccountNumber;
	
	@Column(name="ACCOUNT_LIMIT")
	private float accountLimit;

	public String getClientAccountNumber() {
		return clientAccountNumber;
	}

	public void setClientAccountNumber(String clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
	}

	public float getAccountLimit() {
		return accountLimit;
	}

	public void setAccountLimit(float accountLimit) {
		this.accountLimit = accountLimit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(accountLimit);
		result = prime * result + ((clientAccountNumber == null) ? 0 : clientAccountNumber.hashCode());
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
		CreditCardLimit other = (CreditCardLimit) obj;
		if (Float.floatToIntBits(accountLimit) != Float.floatToIntBits(other.accountLimit))
			return false;
		if (clientAccountNumber == null) {
			if (other.clientAccountNumber != null)
				return false;
		} else if (!clientAccountNumber.equals(other.clientAccountNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreditCardLimit [clientAccountNumber=" + clientAccountNumber + ", accountLimit=" + accountLimit + "]";
	}
	
	
	
}
