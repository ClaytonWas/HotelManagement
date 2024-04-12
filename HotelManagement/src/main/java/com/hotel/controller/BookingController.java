 package com.hotel.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hotel.model.Booking;
import com.hotel.model.Room;
import com.hotel.service.BookingService;

@Controller
public class BookingController {
	private BookingService bookingService;
	
	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@GetMapping("/bookings")
	public String addBooking(Model model) {
		model.addAttribute("bookings", bookingService.getAllBookings());
		return "bookings";	
	}
	
	@PostMapping("/processAddBooking")
	public String processAddBooking(Model model, String name, String type, String service, LocalDate startDate, LocalDate endDate) {
		bookingService.saveBooking(name, type, service, startDate, endDate);
		return "redirect:/bookings";
	}
}