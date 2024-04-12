package com.hotel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.Booking;
import com.hotel.model.Customer;
import com.hotel.service.BookingService;

import jakarta.servlet.http.HttpSession;


@Controller
//@RequestMapping("/order")
public class BookingController {
	private BookingService bookingService;
	
	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	
	@GetMapping("/addBooking")
	public String addBooking(Model model) {
		
		model.addAttribute("booking", new Booking());
		
		return "bookings";	
	}
	
	@PostMapping("/processAddBooking")
	public String processAddBooking(Booking booking, HttpSession httpSession) {
		
		Customer sessionCustomer = (Customer) httpSession.getAttribute("customer");
		
		sessionCustomer.getBookings().add(booking);
			
		booking.setcustomerId(sessionCustomer);
		
		bookingService.saveBooking(booking);
		
		httpSession.setAttribute("booking", booking);
		
		//Add a session attribute for the bookingId
		httpSession.setAttribute("bookingId", booking.getBookingId());
		
		System.out.println(sessionCustomer);
		
		System.out.println(booking.getcustomerId());

		return "redirect:/viewRoom";
	}
	
	/*
	@GetMapping("/all-booking")
	public List<Booking> allOrders() {
		return bookingService.getAllBookings();
	}

	@PostMapping("/book")
	public ResponseEntity<?> saveOrder(@RequestBody() Booking order) {
		Booking dborder = bookingService.saveBooking(order);
		return ResponseEntity.ok().body(dborder);
	}

	@GetMapping("/booking/{id}")
	public Booking getData(@PathVariable("id") Long id) {
		return bookingService.getBooking(id);
	}

	@PutMapping("/bookingupdate")
	public Booking updatedata(@PathVariable("id") Long id, @RequestBody() Booking order) {
		return bookingService.updateBooking(id, order);
	}

	@DeleteMapping("/deletebooking/{id}")
	public String deletedate(@PathVariable("id") Long id) {
		Booking data = bookingService.getBooking(id);
		Boolean test = bookingService.deleteBooking(id);
		return (data != null) ? (test) ? "deleted sucess" : "no id found" : "no data found";
	}
	*/
}