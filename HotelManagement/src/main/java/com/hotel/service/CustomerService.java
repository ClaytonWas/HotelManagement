package com.hotel.service;

import java.util.List;

import com.hotel.model.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);
	Boolean removeCustomer(Long customerId);
	void updateCustomer(Long customerId, Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomer(Long customerId);
}