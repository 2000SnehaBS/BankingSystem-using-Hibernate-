package com.sixdee.hibernate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sixdee.hibernate.dto.AccountMasterDto;
import com.sixdee.hibernate.dto.BankSystemDto;
import com.sixdee.hibernate.dto.Deposit;
import com.sixdee.hibernate.dto.Withdraw;
import com.sixdee.hibernate.entity.AccountMaster;
import com.sixdee.hibernate.entity.BankSystem;
import com.sixdee.hibernate.entity.PagedResponse;
import com.sixdee.hibernate.repository.BankSystemDAO;
import com.sixdee.hibernate.repository.BankSystemDAOImpl;
@Service
public class BankSystemServiceImpl implements BankSystemService {
    @Autowired
    private BankSystemDAO dao;
	@Override
	public BankSystem customerdetails(BankSystemDto bs) {
	BankSystem bk = new BankSystem();
	AccountMaster master = new AccountMaster();
	List<AccountMaster> list = new ArrayList<>();
	System.out.println("..........."+ bs.toString());
	BeanUtils.copyProperties(bs, bk);
	List<AccountMasterDto> am = bs.getAm();
	for (AccountMasterDto accountMasterDto : am) {
	    	
		BeanUtils.copyProperties(accountMasterDto, master);
		System.out.println(accountMasterDto.getAccountType()+"=AccountType");
		master.setAccountType(accountMasterDto.getAccountType());
		list.add(master);
	}
	bk.setAm(list);
	System.out.println("..........."+ bk.toString());
	return dao.save(bk);
		
	}
	@Override
	public BankSystem deposit(Deposit bs) {
		BankSystem bankSystem=null;
		Optional<BankSystem> customerdetails = dao.findById(bs.getCustomerId());
		if( customerdetails.isPresent()) {
			 bankSystem = customerdetails.get();
   		 int currentbalance =  bankSystem.getBalance();
   		 
   		 currentbalance = currentbalance + bs.getDepositamount();
   		bankSystem.setBalance(currentbalance);
   		 dao.save(bankSystem);
   		  
   	 }
   	 else {
   		 throw  new RuntimeException("Invalid CustomerId");
   	 }
   	 
		return bankSystem;
	}
	
	
	@Override
	public BankSystem withdraw(Withdraw bs) {
		BankSystem bankSystem=null;
		Optional<BankSystem> customerdetails = dao.findById(bs.getCustomerId());
		if( customerdetails.isPresent() ) {
		  bankSystem = customerdetails.get();
   		 int currentbalance =  bankSystem.getBalance();
   		 if(currentbalance>bs.getWithdrawamount()) {
   			 currentbalance = currentbalance - bs.getWithdrawamount();
   			bankSystem.setBalance(currentbalance);
   	   		 dao.save(bankSystem);
   			 
   		 }
   		 else {
   			throw  new RuntimeException("Insufficient balance");
   		 }
   		
   		  
   	 }
   	 else {
   		 throw  new RuntimeException("Invalid CustomerId");
   	 }
   	 
		return bankSystem;
	}
	@Override
	public String closeaccount(long customerId) {
		String msg = "";
		Optional<BankSystem> customerdetails = dao.findById(customerId);
		if(customerdetails.isPresent() ) {
			dao.deleteById(customerdetails.get().getCustomerId());
			msg = "account deleted successfully";
		}
		else {
			msg = "account not found";
		}
		return msg;
		
		
	}
	@Override
	public BankSystem getcustomerbyid(long customerId) {
		Optional<BankSystem> getcustomerdetails = dao.findById(customerId);
		if(getcustomerdetails.isPresent()) {
			return getcustomerdetails.get();
		}
		return null;
		
		
	}
	@Override
	public List<BankSystem> getallcustomerdetails() {
		return dao.findAll();
		
	}
	/*@Override
	public PagedResponse<BankSystem> getallcustomerdetails(Pageable pageable, Specification<BankSystem> spec) {
		
		return null;
	}*/
	@Override
	public PagedResponse<BankSystem> findallcustomerdetails(Pageable pageable, Specification<BankSystem> spec) {
		Page<BankSystem> entity = dao.findAll(spec, pageable);
		return new PagedResponse<>(entity.getContent(), entity.getNumber(), entity.getSize(),
		        entity.getTotalElements(), entity.getTotalPages(), entity.isLast());
	}
	
	
	
	
	
}
