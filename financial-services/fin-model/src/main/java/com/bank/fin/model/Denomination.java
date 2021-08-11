package com.bank.fin.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Entity
public class Denomination implements Serializable {

	private static final long serialVersionUID = -2086272526441401594L;

	@Id
	@Column(name="DENOMINATION_ID")
	private Integer denominationId;
	
	@Column(name="VALUE")
	private BigDecimal value;

	@OneToOne
	@JoinColumn(name="DENOMINATION_TYPE_CODE", referencedColumnName="DENOMINATION_TYPE_CODE")
	private DenominationType denominationType;

	public Integer getDenominationId() {
		return denominationId;
	}

	public void setDenominationId(Integer denominationId) {
		this.denominationId = denominationId;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public DenominationType getDenominationType() {
		return denominationType;
	}

	public void setDenominationType(DenominationType denominationType) {
		this.denominationType = denominationType;
	}
}
