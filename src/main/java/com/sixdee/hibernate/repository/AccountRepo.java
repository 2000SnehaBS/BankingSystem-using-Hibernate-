package com.sixdee.hibernate.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sixdee.hibernate.entity.BankSystem;

public interface AccountRepo extends PagingAndSortingRepository<BankSystem, Integer>{


}
