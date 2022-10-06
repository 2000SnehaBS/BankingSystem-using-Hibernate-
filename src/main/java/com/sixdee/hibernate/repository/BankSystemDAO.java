package com.sixdee.hibernate.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sixdee.hibernate.entity.BankSystem;
import com.sixdee.hibernate.entity.PagedResponse;

public interface BankSystemDAO extends JpaRepository<BankSystem, Long>{

	/*BankSystem createcustomerdetails(BankSystem bk);

	BankSystem getcustomerdetails(long customerId);

	BankSystem updatecustomerbalance(BankSystem customerdetails);
	BankSystem withdrawmoney(BankSystem customerdetails);

	void closeAccount(BankSystem customerdetails);

	List<BankSystem> getallcustomerdetails();*/
	
	
	//public PagedResponse<BankSystem> findAllCustomerdetails( Specification<BankSystem> spec,Pageable pageable);

	public  Page<BankSystem> findAll(Specification<BankSystem> spec, Pageable pageable);

	

	

	

}
