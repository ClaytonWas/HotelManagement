package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Booking;

import com.hotel.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepo;
	
	public BookingService(BookingRepository bookingRepo) {
		this.bookingRepo = bookingRepo;
	}

	public void saveBooking(Booking booking) {
		if (!bookingRepo.existsByStartDateAndRoomId(booking.getStartDate(), booking.getRoomId())) {
			bookingRepo.save(booking);
			System.out.println(booking);
		} else System.out.println("Failure to save booking");
	}
	
	public Boolean deleteBooking(Long bookId) {
		if ((bookingRepo.deleteByBookingId(bookId)) >=1) return true;		
		return false;
	}
	
	public Booking getBooking(Long bookingId) {
		return bookingRepo.findByBookingId(bookingId);
	}
	
	public void updateBooking(Long bookingId, Booking booking) {
		if (bookingRepo.existsById(bookingId)) {
			
			Booking bookingTU = getBooking(bookingId);
			
			bookingTU.setCustomerId(booking.getCustomerId());
			bookingTU.setRoomId(booking.getRoomId());
			bookingTU.setStartDate(booking.getStartDate());
			bookingTU.setEndDate(booking.getEndDate());
			
			bookingRepo.save(bookingTU);
			
			System.out.println("Booking successfully updated");
		}
		System.out.println("Failure to update booking");
	}
	
	public List<Booking> getAllBookings(){
		return bookingRepo.findAll();
	}
}