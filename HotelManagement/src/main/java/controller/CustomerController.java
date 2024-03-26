package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anudip.Hotelmanagement.entity.Customer;
import com.anudip.Hotelmanagement.service.CustomerService;

@RestController
@RequestMapping("/user")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/all-users")
	public List<Customer> allCustomers() {
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/{id}")
	public Customer getData(@PathVariable("id") Long id) {
		return customerService.getCustomer(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> saveCustomer(@RequestBody() Customer user) {
		Customer dbcus = customerService.addCustomer(user);
		return ResponseEntity.ok().body(dbcus);
	}
	
	@PutMapping("/userupdate/{id}")
	public Customer updateCustomer(@PathVariable("id") Long id, @RequestBody() Customer user) {
		return customerService.updateCustomer(id, user);
	}

	@DeleteMapping("/deleteuser/{id}")
	public String deletedate(@PathVariable("id") Long id) {
		Customer data = customerService.getCustomer(id);
		Boolean test = customerService.removeCustomer(id);
		return (data != null) ? (test) ? "deleted successfully" : "no id found" : "no data found";
	}
}