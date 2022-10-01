package com.sixdee.hibernate.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.sixdee.hibernate.entity.AccountMaster;
import com.sixdee.hibernate.entity.BankSystem;
import com.sixdee.hibernate.util.SessionFactoryUtil;
@Repository

public class BankSystemDAOImpl {
	@Autowired
    private SessionFactory sessionFactory ; 
	
	public BankSystem createcustomerdetails(BankSystem bk) {
		 
		 Session openSession = sessionFactory .openSession();
    	 
    	 Transaction beginTransaction = openSession.beginTransaction();
    	 
    	 openSession.save(bk); 
    	 System.out.println(bk.getCustomerId()+"=customerId");
    	 bk.getAm().get(0).setBanksystem(bk);
    	 beginTransaction.commit();
    	 openSession.close();
    	 return bk;
    	 
	}

	
	public BankSystem getcustomerdetails(long customerId) {
	Session openSession = sessionFactory .openSession();
   	 Transaction beginTransaction = openSession.beginTransaction();
   	 BankSystem bs =(BankSystem) openSession.get(BankSystem.class, customerId);
		return bs;
	}

	
	public BankSystem updatecustomerbalance(BankSystem customerdetails) {
		Session openSession = sessionFactory .openSession();
	   	Transaction beginTransaction = openSession.beginTransaction();
	   	openSession.update(customerdetails);
	   	beginTransaction.commit();
	   	openSession.close();
		
		return customerdetails ;
	}
	
	
	public BankSystem withdrawmoney(BankSystem customerdetails) {
		Session openSession = sessionFactory .openSession();
	   	Transaction beginTransaction = openSession.beginTransaction();
	   	openSession.update(customerdetails);
	   	beginTransaction.commit();
	   	openSession.close();
		
		return customerdetails ;
	}
	
	public  void closeAccount(BankSystem customer) {
		Session openSession = sessionFactory .openSession();
      	 
      	 Transaction beginTransaction = openSession.beginTransaction();
      	 
      	 if(customer != null) {
      		 openSession.delete(customer);
      		 beginTransaction.commit();
      		openSession.close();
      	 }
      	 
      	 else {
      		openSession.close();
      		throw  new RuntimeException("Invalid CustomerId");
      		
      	 }
      	
			
		}

	
	public List<BankSystem> getallcustomerdetails() {
		Session openSession = sessionFactory .openSession();
     	 Transaction beginTransaction = openSession.beginTransaction();
     	 Query createQuery = openSession.createQuery("from BankSystem");
     	 List<BankSystem> list = createQuery.list();
     	 System.out.println("size="+list.size());
     	 return list;
	}

}
