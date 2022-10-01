package com.sixdee.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sixdee.hibernate.entity.BankSystem;

public interface BankSystemDAO extends JpaRepository<BankSystem, Long>{

	/*BankSystem createcustomerdetails(BankSystem bk);

	BankSystem getcustomerdetails(long customerId);

	BankSystem updatecustomerbalance(BankSystem customerdetails);
	BankSystem withdrawmoney(BankSystem customerdetails);

	void closeAccount(BankSystem customerdetails);

	List<BankSystem> getallcustomerdetails();*/

}
