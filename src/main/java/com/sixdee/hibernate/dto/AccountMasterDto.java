package com.sixdee.hibernate.dto;

import com.sixdee.hibernate.entity.BankSystem;

public class AccountMasterDto {
	
	private Integer accountMasterId;
	private String accountId;
	private String accountType;
    private long customerId;
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
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public AccountMasterDto(Integer accountMasterId, String accountId, String accountType, long customerId) {
		this.accountMasterId = accountMasterId;
		this.accountId = accountId;
		this.accountType = accountType;
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "AccountMasterDto [accountMasterId=" + accountMasterId + ", accountId=" + accountId + ", accountType="
				+ accountType + ", customerId=" + customerId + "]";
	}
	
    

}
