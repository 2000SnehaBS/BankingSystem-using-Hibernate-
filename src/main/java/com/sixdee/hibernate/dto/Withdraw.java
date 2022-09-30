package com.sixdee.hibernate.dto;

public class Withdraw {

		private long customerId;
		private int withdrawamount;
		public long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}
		public int getWithdrawamount() {
			return withdrawamount;
		}
		public void setWithdrawamount(int withdrawamount) {
			this.withdrawamount = withdrawamount;
		}

	}


