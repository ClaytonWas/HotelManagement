package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hotel.model.Booking;
import com.hotel.service.BookingService;

@Controller
public class BookingController {
	private BookingService bookingService;
	
	public BookingController(BookingService bookingService) {
		//super();
		this.bookingService = bookingService;
	}
	
	@GetMapping("/bookings")
	public String addBooking(Model model) {
		model.addAttribute("booking", new Booking());
		return "bookings";	
	}
	
	@PostMapping("/processAddBooking")
	public String processAddBooking(Booking booking, Model model) {
		bookingService.saveBooking(booking);
		return "redirect:/bookings";
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