package com.sixdee.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sixdee.hibernate.entity.BankSystem;
@Repository
public interface BankSystemImpl extends JpaRepository<BankSystem, Long>{

	

}
