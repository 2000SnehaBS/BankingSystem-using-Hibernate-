package com.sixdee.hibernate.service;



import java.util.List;

import com.sixdee.hibernate.dto.BankSystemDto;
import com.sixdee.hibernate.dto.Deposit;
import com.sixdee.hibernate.dto.Withdraw;
import com.sixdee.hibernate.entity.BankSystem;

public interface BankSystemService {

	public BankSystem customerdetails(BankSystemDto bs);

	public BankSystem deposit(Deposit bs);
	
	public BankSystem withdraw(Withdraw bs);
	
	public String  closeaccount(long customerId );

	public BankSystem getcustomerbyid(long customerId);

	public List<BankSystem> getallcustomerdetails();

	
	
	

}
