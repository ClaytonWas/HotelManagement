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
import com.anudip.Hotelmanagement.entity.Booking;
import com.anudip.Hotelmanagement.service.BookingService;

@RestController
@RequestMapping("/order")
public class BookingController {
	@Autowired
	private BookingService orderService;
	
	@GetMapping("/all-booking")
	public List<Booking> allOrders() {
		return orderService.getAllOrder();
	}

	@PostMapping("/book")
	public ResponseEntity<?> saveOrder(@RequestBody() Booking order) {
		Booking dborder = orderService.saveOrder(order);
		return ResponseEntity.ok().body(dborder);
	}

	@GetMapping("/booking/{id}")
	public Booking getData(@PathVariable("id") Long id) {
		return orderService.getOrder(id);
	}

	@PutMapping("/bookingupdate")
	public Booking updatedata(@PathVariable("id") Long id, @RequestBody() Booking order) {
		return orderService.updateOrder(id, order);
	}

	@DeleteMapping("/deletebooking/{id}")
	public String deletedate(@PathVariable("id") Long id) {
		Booking data = orderService.getOrder(id);
		Boolean test = orderService.deleteOrder(id);
		return (data != null) ? (test) ? "deleted sucess" : "no id found" : "no data found";
	}
}