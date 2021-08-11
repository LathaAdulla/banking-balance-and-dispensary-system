package com.bank.fin.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientType implements Serializable {

	private static final long serialVersionUID = -7290588845248505855L;

	@Id
	@Column(name="CLIENT_TYPE_CODE")
	private String clientTypeCode;
	
	@Column(name="DESCRIPTION")
	private String description;

	public String getClientTypeCode() {
		return clientTypeCode;
	}

	public void setClientTypeCode(String clientTypeCode) {
		this.clientTypeCode = clientTypeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientTypeCode == null) ? 0 : clientTypeCode.hashCode());
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
		ClientType other = (ClientType) obj;
		if (clientTypeCode == null) {
			if (other.clientTypeCode != null)
				return false;
		} else if (!clientTypeCode.equals(other.clientTypeCode))
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
		return "ClientType [clientTypeCode=" + clientTypeCode + ", description=" + description + "]";
	}

}
