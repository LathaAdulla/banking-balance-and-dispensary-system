package com.bank.fin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class AccountType implements Serializable {

	private static final long serialVersionUID = -7701624788066923408L;

	@Id
    @Column(name = "ACCOUNT_TYPE_CODE")
    private String accountTypeCode;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TRANSACTIONAL")
    private boolean transactional = Boolean.FALSE;

    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public void setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTransactional() {
        return transactional;
    }

    public void setTransactional(boolean transactional) {
        this.transactional = transactional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountType that = (AccountType) o;

        if (transactional != that.transactional) return false;
        if (accountTypeCode != null ? !accountTypeCode.equals(that.accountTypeCode) : that.accountTypeCode != null)
            return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = accountTypeCode != null ? accountTypeCode.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (transactional ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeCode='" + accountTypeCode + '\'' +
                ", description='" + description + '\'' +
                ", transactional=" + transactional +
                '}';
    }
}
