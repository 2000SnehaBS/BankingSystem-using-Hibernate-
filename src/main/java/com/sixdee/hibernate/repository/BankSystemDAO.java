package com.sixdee.hibernate.repository;

import java.util.List;

import com.sixdee.hibernate.entity.BankSystem;

public interface BankSystemDAO {

	BankSystem createcustomerdetails(BankSystem bk);

	BankSystem getcustomerdetails(long customerId);

	BankSystem updatecustomerbalance(BankSystem customerdetails);
	BankSystem withdrawmoney(BankSystem customerdetails);

	void closeAccount(BankSystem customerdetails);

	List<BankSystem> getallcustomerdetails();

}
