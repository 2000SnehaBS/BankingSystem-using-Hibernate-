package com.sixdee.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ACCOUNTMASTER")
public class AccountMaster implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_MASTER_ID")
	private Integer accountMasterId;
	
	@Column(name="ACCOUNT_ID")
	private String accountId;
	
	@Column(name="ACCOUNT_TYPE")
     private String accountType;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMERID")
	@JsonBackReference 
	private BankSystem banksystem ;

	public Integer getAccountMasterId() {
		return accountMasterId;
	}

	public void setAccountMasterId(Integer accountMasterId) {
		this.accountMasterId = accountMasterId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	

	

	public BankSystem getBanksystem() {
		return banksystem;
	}

	public void setBanksystem(BankSystem banksystem) {
		this.banksystem = banksystem;
	}

	public AccountMaster(Integer accountMasterId, String accountId, String accountType, BankSystem customerId) {
		super();
		this.accountMasterId = accountMasterId;
		this.accountId = accountId;
		this.accountType = accountType;
		this.banksystem = customerId;
	}

	public AccountMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AccountMaster [accountMasterId=" + accountMasterId + ", accountId=" + accountId + ", accountType="
				+ accountType + ", customerId=" + banksystem + "]";
	}
	
}
