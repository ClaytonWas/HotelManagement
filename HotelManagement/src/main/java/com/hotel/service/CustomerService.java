package service;

import java.util.List;
import model.Customer;

public interface CustomerService {
	Customer addCustomer(Customer customer);
	Boolean removeCustomer(Long customerId);
	Customer updateCustomer(Long customerId, Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomer(Long customerId);
}