package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Customer;
import com.hotel.repository.CustomerRepository;

@Service
public class CustomerService {
	private CustomerRepository customerRepo;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}

	public void addCustomer(Customer customer) {
		if(customerRepo.findByName(customer.getName()) == null) {
			customerRepo.save(customer);
			
			System.out.println(customer);
		} else System.out.println("Another user already exists with that name.");
	}
	
	public Boolean removeCustomer(Long customerId){
		if ((customerRepo.deleteByCustomerId(customerId) >= 1)) return true;
		return false;
	}
	
	public Customer getCustomer(Long customerId) {
		return customerRepo.findByCustomerId(customerId);
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}
}