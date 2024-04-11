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
}