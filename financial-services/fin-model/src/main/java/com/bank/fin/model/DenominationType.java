package com.bank.fin.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DenominationType implements Serializable {

	private static final long serialVersionUID = 1736932465461509489L;

	@Id
	@Column(name="DENOMINATION_TYPE_CODE")
	private String denominationTypeCode;
	
	@Column(name="DESCRIPTION")
	private String description;

	public String getDenominationTypeCode() {
		return denominationTypeCode;
	}

	public void setDenominationTypeCode(String denominationTypeCode) {
		this.denominationTypeCode = denominationTypeCode;
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
		result = prime * result + ((denominationTypeCode == null) ? 0 : denominationTypeCode.hashCode());
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
		DenominationType other = (DenominationType) obj;
		if (denominationTypeCode == null) {
			if (other.denominationTypeCode != null)
				return false;
		} else if (!denominationTypeCode.equals(other.denominationTypeCode))
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
		return "DenominationType [denominationTypeCode=" + denominationTypeCode + ", description=" + description + "]";
	}
	
	
}
