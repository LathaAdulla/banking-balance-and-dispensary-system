package com.bank.fin.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ClientSubType implements Serializable {

	private static final long serialVersionUID = -4929565051507098610L;

	@Id
	@Column(name="CLIENT_SUB_TYPE_CODE")
	private String clientSubTypeCode;
	
	@OneToOne
	@JoinColumn(name="CLIENT_TYPE_CODE", referencedColumnName="CLIENT_TYPE_CODE")
	private ClientType clientTypeCode;
	
	@Column(name="DESCRIPTION")
	private String description;

	public String getClientSubTypeCode() {
		return clientSubTypeCode;
	}

	public void setClientSubTypeCode(String clientSubTypeCode) {
		this.clientSubTypeCode = clientSubTypeCode;
	}

	public ClientType getClientTypeCode() {
		return clientTypeCode;
	}

	public void setClientTypeCode(ClientType clientTypeCode) {
		this.clientTypeCode = clientTypeCode;
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
		result = prime * result + ((clientSubTypeCode == null) ? 0 : clientSubTypeCode.hashCode());
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
		ClientSubType other = (ClientSubType) obj;
		if (clientSubTypeCode == null) {
			if (other.clientSubTypeCode != null)
				return false;
		} else if (!clientSubTypeCode.equals(other.clientSubTypeCode))
			return false;
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
		return "ClientSubType [clientSubTypeCode=" + clientSubTypeCode + ", clientTypeCode=" + clientTypeCode
				+ ", description=" + description + "]";
	}
	
	

}
