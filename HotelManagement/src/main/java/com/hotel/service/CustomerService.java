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
		if(!customerRepo.existsByNameAndPhoneNumber(customer.getName(), customer.getPhoneNumber())) {
			customerRepo.save(customer);
			
			System.out.println(customer);
		} else System.out.println("Failure to save customer");
	}
	
	public Boolean removeCustomer(Long customerId){
		if ((customerRepo.deleteByCustomerId(customerId) >= 1)) return true;
		return false;
	}
	
	public Customer getCustomer(Long customerId) {
		return customerRepo.findByCustomerId(customerId);
	}
	
	public void updateCustomer(Long customerId, Customer customer){
		if(customerRepo.existsById(customerId)){
			Customer customerTU = getCustomer(customerId);
			
			customerTU.setName(customer.getName());
			customerTU.setPhoneNumber(customer.getPhoneNumber());
			customerTU.setEmail(customer.getEmail());
			
			customerRepo.save(customerTU);
			
			System.out.println("Customer successfully updated");
		} else System.out.println("Failure to update customer");
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}
}