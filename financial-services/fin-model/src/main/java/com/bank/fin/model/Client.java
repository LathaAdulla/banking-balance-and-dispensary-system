package com.bank.fin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Client implements Serializable{
	
	private static final long serialVersionUID = -4495955779088172408L;

	@Id
	@Column(name="CLIENT_ID")
	private Integer clientId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="SURNAME")
	private String surname;
	
	@Column(name="DOB")
	private Date DOB;
	
	@OneToOne
	@JoinColumn(name="CLIENT_SUB_TYPE_CODE", referencedColumnName="CLIENT_SUB_TYPE_CODE")
	private ClientSubType clientSubTypeCode;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name ="CLIENT_ID", referencedColumnName="CLIENT_ID")
	private List<ClientAccount> clientAccounts;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public ClientSubType getClientSubTypeCode() {
		return clientSubTypeCode;
	}

	public void setClientSubTypeCode(ClientSubType clientSubTypeCode) {
		this.clientSubTypeCode = clientSubTypeCode;
	}
	

	public List<ClientAccount> getClientAccounts() {
		return clientAccounts;
	}

	public void setClientAccounts(List<ClientAccount> clientAccounts) {
		this.clientAccounts = clientAccounts;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + ((DOB == null) ? 0 : DOB.hashCode());
		result = prime * result +((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((clientSubTypeCode == null) ? 0 : clientSubTypeCode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Client other = (Client) obj;
		if (DOB == null) {
			if (other.DOB != null)
				return false;
		} else if (!DOB.equals(other.DOB))
			return false;
		if (clientId != other.clientId)
			return false;
		if (clientSubTypeCode == null) {
			if (other.clientSubTypeCode != null)
				return false;
		} else if (!clientSubTypeCode.equals(other.clientSubTypeCode))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", title=" + title + ", name=" + name + ", surname=" + surname
				+ ", DOB=" + DOB + ", clientSubTypeCode=" + clientSubTypeCode + "]";
	}
	
}
