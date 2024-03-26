package service;

import java.util.List;
import model.Customer;

public interface CustomerService {
	Customer addCustomer(Customer user);
	Boolean removeCustomer(Long customerId);
	Customer updateCustomer(Long customerId, Customer user);
	List<Customer> getAllCustomer();
	Customer getCustomer(Long customerId);
}