package com.bank.fin.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyConversionRate implements Serializable {

	private static final long serialVersionUID = 7562552997325245805L;

	@Id
	@Column(name="CURRENCY_CODE")
	private String currencyCode;
	
	@Column(name="CONVERSION_INDICATOR")
	private String conversionIndicator;
	
	@Column(name="RATE")
	private BigDecimal rate;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getConversionIndicator() {
		return conversionIndicator;
	}

	public void setConversionIndicator(String conversionIndicator) {
		this.conversionIndicator = conversionIndicator;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conversionIndicator == null) ? 0 : conversionIndicator.hashCode());
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
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
		CurrencyConversionRate other = (CurrencyConversionRate) obj;
		if (conversionIndicator == null) {
			if (other.conversionIndicator != null)
				return false;
		} else if (!conversionIndicator.equals(other.conversionIndicator))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode)) {
			return false;
		} else if (!rate.equals(other.rate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CurrencyConversionRate [currencyCode=" + currencyCode + ", conversionIndicator=" + conversionIndicator
				+ ", rate=" + rate + "]";
	}
	
	
}
