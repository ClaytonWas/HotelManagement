package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotel.model.Booking;
import com.hotel.model.Customer;
import com.hotel.model.ProvidedService;
import com.hotel.model.Room;
import com.hotel.service.BookingService;
import com.hotel.service.CustomerService;
import com.hotel.service.ProvidedServiceService;
import com.hotel.service.RoomService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DetailController {
	CustomerService customerService;
	BookingService bookingService;
	RoomService roomService;
	ProvidedServiceService providedServiceService;
	
	public DetailController(CustomerService customerService, BookingService bookingService, RoomService roomService,
			ProvidedServiceService providedServiceService) {
		super();
		this.customerService = customerService;
		this.bookingService = bookingService;
		this.roomService = roomService;
		this.providedServiceService = providedServiceService;
	}

	@GetMapping("/viewDetails")
	public String viewDetails(HttpSession httpSession)
	{
		long customerId = (long) httpSession.getAttribute("customerId");
		long bookingId = (long) httpSession.getAttribute("bookingId");
		long roomId = (long) httpSession.getAttribute("roomId");
		long serviceId = (long) httpSession.getAttribute("serviceId");
		
		Customer persistCustomer = customerService.getCustomer(customerId);
		Booking persistBooking = bookingService.getBooking(bookingId);
		Room persistRoom = roomService.getRoom(roomId);
		ProvidedService persistService = providedServiceService.getService(serviceId);
		
		System.out.println("Customer from data base is: " + persistCustomer);
		System.out.println("Booking from data base is: " + persistBooking);
		System.out.println("Booking's Customer is " + persistBooking.getBookingId());
		System.out.println("Booking's Room is " + persistRoom.getRoomId());
		System.out.println("Booking's service are" + persistBooking.getProvidedServices());
		System.out.println("Room from data base is: " + persistRoom);
		System.out.println("Service from data base is: " + persistService);
		System.out.println("Service is being provided to rooms " + persistService.getBookings());
		
		return "detailsPage";
		
	}

}
