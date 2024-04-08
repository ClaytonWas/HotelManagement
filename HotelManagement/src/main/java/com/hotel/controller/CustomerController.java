package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.hotel.model.Customer;
import com.hotel.service.CustomerService;

@Controller
public class CustomerController {
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/customers")
	public String addController(Model model) {
		model.addAttribute("customer", new Customer());
		return "customers";
	}
	
	@PostMapping("/processAddCustomer")
	public String processAddCustomer(Customer customer, Model model) {
		customerService.addCustomer(customer);
		return "redirect:/customers";
	}
}