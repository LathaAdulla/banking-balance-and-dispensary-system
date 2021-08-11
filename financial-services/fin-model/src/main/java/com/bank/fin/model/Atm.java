package com.bank.fin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Atm implements Serializable {

	private static final long serialVersionUID = 2444572799695219718L;

	@Id
	@Column(name="ATM_ID")
	private Integer atmId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LOCATION")
	private String location;

	@OneToMany
	@JoinColumn(name ="ATM_ID", referencedColumnName="ATM_ID")
	private List<AtmAllocation> atmAllocations = new ArrayList<>();

	public Integer getAtmId() {
		return atmId;
	}

	public void setAtmId(Integer atmId) {
		this.atmId = atmId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<AtmAllocation> getAtmAllocations() {
		return atmAllocations;
	}

	public void setAtmAllocations(List<AtmAllocation> atmAllocations) {
		this.atmAllocations = atmAllocations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atmId == null) ? 0 : atmId.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Atm other = (Atm) obj;
		if (atmId != other.atmId)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atm [atmId=" + atmId + ", name=" + name + ", location=" + location + "]";
	}
	
	
}
