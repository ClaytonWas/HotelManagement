package com.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	boolean existsByNameAndPhoneNumber(String name, String phoneNumber);
	
	@Query("select c from Customer c WHERE c.customerId = ?1")
	Customer findByCustomerId(Long customerId);
	
	int deleteByCustomerId(Long customerId);
	
	List<Customer> findAll();
	
	
}