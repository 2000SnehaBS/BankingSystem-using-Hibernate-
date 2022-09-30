package com.sixdee.hibernate.controller;

import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sixdee.hibernate.dto.BankSystemDto;
import com.sixdee.hibernate.dto.Deposit;
import com.sixdee.hibernate.dto.Withdraw;
import com.sixdee.hibernate.entity.BankSystem;
import com.sixdee.hibernate.repository.AccountRepo;
import com.sixdee.hibernate.service.BankSystemService;

@RestController
public class BankSystemController {
    @Autowired
    private BankSystemService banksystem;
    @Autowired
    private AccountRepo repo;
    @PostMapping("/createcustomerdetails")
	public BankSystem customerdetails(@RequestBody BankSystemDto bs) {
    System.out.println(bs.getAm().size());
    System.out.println(bs.toString());
	BankSystem bk = banksystem.customerdetails(bs);
	return bk;
	}
    
    @PutMapping("/depositemoney")
	public BankSystem depositmoney(@RequestBody Deposit bs) {
		BankSystem bk = banksystem.deposit(bs);
		return bk;
	}
    
    @PutMapping("/withdrawmoney")
   	public BankSystem withdraw(@RequestBody Withdraw bs) {
   		BankSystem bk = banksystem.withdraw(bs);
   		return bk;
   	}
    
    @DeleteMapping("/closeaccount/{customerId}")
   	public String  closeaccount(@PathVariable long customerId ) {
    	
   	return banksystem.closeaccount(customerId);
   		
   	}
    @GetMapping("/getcustomerdetails/{customerId}")
    public BankSystem getcustomerbyid(@PathVariable long customerId) {
    	return banksystem.getcustomerbyid(customerId);
		
    	
    }
    @GetMapping(value="/getallcustomerdetalis",produces = MediaType.APPLICATION_JSON_VALUE)
    
    public @ResponseBody List<BankSystem>  getallcustomerdetails() {
    	return  banksystem.getallcustomerdetails();
	
    	
    }
    @GetMapping(value = "/pagination")
    Page pagination(Pageable pageable) {
    	return repo.findAll(pageable);
	  }
    
    
}
