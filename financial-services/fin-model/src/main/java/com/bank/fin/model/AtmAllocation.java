package com.bank.fin.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class AtmAllocation implements Serializable{

	private static final long serialVersionUID = -8659891933390862299L;

	@Id
	@Column(name="ATM_ALLOCATION_ID")
	private Integer atmAllocation;

	@Column(name="ATM_ID")
	private Integer atmId;
	
	@OneToOne
	@JoinColumn(name="DENOMINATION_ID", referencedColumnName="DENOMINATION_ID")
	private Denomination denomination;
	
	@Column(name="COUNT")
	private Integer count;

	public Integer getAtmAllocation() {
		return atmAllocation;
	}

	public void setAtmAllocation(Integer atmAllocationId) {
		this.atmAllocation = atmAllocationId;
	}

	public Integer getAtmId() {
		return atmId;
	}

	public void setAtm(Integer atm) {
		this.atmId = atm;
	}

	public Denomination getDenomination() {
		return denomination;
	}

	public void setDenomination(Denomination denominationId) {
		this.denomination = denominationId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atmAllocation != null) ? atmAllocation.hashCode() : 0);
		result = prime * result + ((atmId != null) ? atmId.hashCode() : 0);
		result = prime * result + ((count != null) ? count.hashCode() : 0);
		result = prime * result + ((denomination != null) ? denomination.hashCode() : 0);
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
		AtmAllocation other = (AtmAllocation) obj;
		if (atmAllocation != other.atmAllocation)
			return false;
		if (atmId != other.atmId)
			return false;
		if (count != other.count)
			return false;
		if (denomination != other.denomination)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AtmAllocation [atmAllocationId=" + atmAllocation + ", atmId=" + atmId + ", denominationId="
				+ denomination + ", count=" + count + "]";
	}

}
