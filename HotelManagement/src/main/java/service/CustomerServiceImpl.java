package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Customer;
import repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	private CustomerRepository customerRepo;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	public Customer addCustomer(Customer customer) {
		if(!customerRepo.existsByNameAndPhoneNumber(customer.getName(), customer.getPhoneNumber())) {
			customerRepo.save(customer);
		}
		
		return customer;
	}
	
	public Boolean removeCustomer(Long customerId){
		
		if ((customerRepo.deleteByCustomerId(customerId) >= 1)) {
			return true;
		}
		
		return false;
	}
	
	public Customer getCustomer(Long customerId) {
		
		return customerRepo.findByCustomerId(customerId);
		
	}
	
	public Customer updateCustomer(Long customerId, Customer customer){
		
		if(customerRepo.existsById(customerId)){
			Customer customerTU = getCustomer(customerId);
			
			customerTU.setName(customer.getName());
			customerTU.setPhoneNumber(customer.getPhoneNumber());
			customerTU.setEmail(customer.getEmail());
			
			customerRepo.save(customerTU);
			
			return customerTU;
		}
		
		return customer;
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}

}
