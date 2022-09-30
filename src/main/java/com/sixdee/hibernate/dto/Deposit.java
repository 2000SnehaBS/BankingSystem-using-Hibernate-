package com.sixdee.hibernate.dto;

public class Deposit {
	private long customerId;
	private int depositamount;
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public int getDepositamount() {
		return depositamount;
	}
	public void setDepositamount(int depositamount) {
		this.depositamount = depositamount;
	}

}
