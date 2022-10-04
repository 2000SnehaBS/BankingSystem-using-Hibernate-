/*package com.sixdee.hibernate.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.sixdee.hibernate.entity.BankSystem;
import com.sixdee.hibernate.entity.CustomerPage;
import com.sixdee.hibernate.entity.PagedResponse;

@Repository
public class CustomerCriteriaRepo {
	private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public CustomerCriteriaRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }
    
    public PagedResponse<BankSystem> findAllCustomerWithFilter(Pageable pageable, Specification<BankSystem> spec){
    	CriteriaQuery<BankSystem> criteriaQuery = criteriaBuilder.createQuery(BankSystem.class);
    	Root<BankSystem> criteriaRoot = criteriaQuery.from( BankSystem.class);
		return null;
    	
    }
    private Predicate getpredicate(CustomerPage customerpage, Root<BankSystem> customerRoot) {
    	
    	List<Predicate> list = new ArrayList<Predicate>();
    	if(Objects.nonNull(customerpage.getFirstName())){
    		list.add(criteriaBuilder.like(customerRoot.get("firstName"), "%" + customerpage.getFirstName() + "%") );
        }
    	
    	if(Objects.nonNull(customerpage.getUserName())){
    		list.add(
                     criteriaBuilder.like(customerRoot.get("userName"),
                            "%" + customerpage.getUserName() + "%")
            );
        }
    	
    	if(Objects.nonNull(customerpage.getCustomerId())){
    		list.add(
                   criteriaBuilder.like(customerRoot.get("customerId"),
                            "%" + customerpage.getCustomerId() + "%")
            );
        }
        return criteriaBuilder.and(list.toArray(new Predicate[0]));

    	
    }

}
*/
