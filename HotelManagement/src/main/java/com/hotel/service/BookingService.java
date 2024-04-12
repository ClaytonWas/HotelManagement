package com.hotel.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Booking;
import com.hotel.model.Customer;
import com.hotel.model.ProvidedService;
import com.hotel.model.Room;
import com.hotel.repository.BookingRepository;
import com.hotel.repository.CustomerRepository;
import com.hotel.repository.ProvidedServiceRepository;
import com.hotel.repository.RoomRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	RoomRepository roomRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	ProvidedServiceRepository serviceRepo;
	
	public BookingService() {}
	
	public Boolean deleteBooking(Long bookId) {
		if ((bookingRepo.deleteByBookingId(bookId)) >=1) return true;		
		return false;
	}
	
	public Booking getBooking(Long bookingId) {
		return bookingRepo.findByBookingId(bookingId);
	}
	
	public List<Booking> getAllBookings(){
		return bookingRepo.findAll();
	}
	
	public void saveBooking(String name, String type, String service, LocalDate startDate, LocalDate endDate) {
		List<Room> rooms = roomRepo.searchByType(type);
		Customer customer = customerRepo.findByName(name);
		if (customer == null) {
			System.out.println("Customer name not found!");
			return;
		}
		if (bookingRepo.existsByCustomerAndStartDateAndEndDate(customer, startDate, endDate)) {
			System.out.println("You already have a booking for that time!");
			return;
		}
		while (rooms.size() != 0) {
			if (!bookingRepo.existsByStartDateAndEndDateAndRoom(startDate, endDate, rooms.get(0))) {
				Booking booking = new Booking(customer, rooms.get(0), startDate, endDate);
				
				ProvidedService service2 = serviceRepo.findByName(service);
				if (service2 == null) System.out.println("Couldn't find the requested service, proceeding without it.");
				else booking.addService(service2);
				
				bookingRepo.save(booking);
				System.out.println(booking);
				return;
			} else rooms.remove(0);
		}
		System.out.println("No available rooms for that type and date.");
	}
}