package com.sixdee.hibernate.controller;



import java.util.Date;
import org.springframework.data.domain.Sort;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sixdee.hibernate.dto.BankSystemDto;
import com.sixdee.hibernate.dto.Deposit;
import com.sixdee.hibernate.dto.Withdraw;
import com.sixdee.hibernate.entity.BankSystem;
import com.sixdee.hibernate.entity.PagedResponse;
import com.sixdee.hibernate.service.BankSystemService;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@RestController
public class BankSystemController {
    @Autowired
    private BankSystemService banksystem;
    
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
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PagedResponse<BankSystem> getBankSystem(
            @RequestParam(value = "customerId", required =false) Integer customerId,
            @RequestParam(value = "customerName", required = false) String customerName,
            @RequestParam(value = "date", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "size", defaultValue = "0", required = false) int size,
            @RequestParam(value = "sort", defaultValue = "createdDate", required = false) String sort,
            @RequestParam(value = "order", defaultValue = "desc", required = false) String order,
            @And({ 
                @Spec(path = "customerId", params = "customerId", spec = Equal.class),
                @Spec(path = "customerName", params = "customerName", spec = Equal.class),
                @Spec(path = "dateOfBirth", params = "dateOfBirth", spec = Equal.class)}) 
            Specification<BankSystem> spec) {

        Pageable pageable = (size != 0
                ? PageRequest.of(page - 1, size,order.trim().equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,sort)
                : Pageable.unpaged());
        return service.findAllHolidays(pageable, spec);
    
    
}
}