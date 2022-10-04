package com.sixdee.hibernate.service;



import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.sixdee.hibernate.dto.BankSystemDto;
import com.sixdee.hibernate.dto.Deposit;
import com.sixdee.hibernate.dto.Withdraw;
import com.sixdee.hibernate.entity.BankSystem;
import com.sixdee.hibernate.entity.PagedResponse;

public interface BankSystemService {

	public BankSystem customerdetails(BankSystemDto bs);

	public BankSystem deposit(Deposit bs);
	
	public BankSystem withdraw(Withdraw bs);
	
	public String  closeaccount(long customerId );

	public BankSystem getcustomerbyid(long customerId);

	public List<BankSystem> getallcustomerdetails();

	//public PagedResponse<BankSystem> getallcustomerdetails(Pageable pageable, Specification<BankSystem> spec);
	
	public PagedResponse<BankSystem> getallcustomerdetails( Specification<BankSystem> spec,Pageable pageable);

	
	
	

}
