package com.sixdee.hibernate;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sixdee.hibernate.util.SessionFactoryUtil;

@SpringBootApplication
@ComponentScan("com.sixdee")
public class BankingSystemHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingSystemHibernateApplication.class, args);
	
	}

}
