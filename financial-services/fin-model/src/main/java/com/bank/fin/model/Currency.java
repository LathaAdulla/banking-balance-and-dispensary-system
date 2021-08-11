package com.bank.fin.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency implements Serializable {
	
	private static final long serialVersionUID = 6753609922378047195L;

	@Id
	@Column(name="CURRENCY_CODE")
	private String currencyCode;
	
	@Column(name="DECIMAL_PLACES")
	private Integer decimalplaces;
	
	@Column(name="DESCRIPTION")
	private String description;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Integer getDecimalplaces() {
		return decimalplaces;
	}

	public void setDecimalplaces(Integer decimalplaces) {
		this.decimalplaces = decimalplaces;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		long temp;
		temp = Double.doubleToLongBits(decimalplaces);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Currency other = (Currency) obj;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (Double.doubleToLongBits(decimalplaces) != Double.doubleToLongBits(other.decimalplaces))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Currency [currencyCode=" + currencyCode + ", decimalplaces=" + decimalplaces + ", description="
				+ description + "]";
	}
	
}
