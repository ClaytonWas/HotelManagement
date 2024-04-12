package com.hotel.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Booking;
import com.hotel.model.Room;
import com.hotel.repository.BookingRepository;
import com.hotel.repository.RoomRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	RoomRepository roomRepo;
	
	public BookingService(BookingRepository bookingRepo, RoomRepository roomRepo) {
		this.bookingRepo = bookingRepo;
		this.roomRepo = roomRepo;
	}
	
	public Boolean deleteBooking(Long bookId) {
		if ((bookingRepo.deleteByBookingId(bookId)) >=1) return true;		
		return false;
	}
	
	public Booking getBooking(Long bookingId) {
		return bookingRepo.findByBookingId(bookingId);
	}
	
	/*public void updateBooking(Long bookingId, Booking booking) {
		if (bookingRepo.existsById(bookingId)) {
			
			Booking bookingTU = getBooking(bookingId);
			
			bookingTU.setCustomerId(booking.getCustomer().getCustomerId());
			bookingTU.setRoomId(booking.getRoom().getRoomId());
			bookingTU.setStartDate(booking.getStartDate());
			bookingTU.setEndDate(booking.getEndDate());
			
			bookingRepo.save(bookingTU);
			
			System.out.println("Booking successfully updated");
		}
		System.out.println("Failure to update booking");
	}*/
	
	public List<Booking> getAllBookings(){
		return bookingRepo.findAll();
	}
	
	public void saveBooking(String type, LocalDate startDate, LocalDate endDate) {
		List<Room> rooms = roomRepo.searchByType(type);
		while (rooms.size() != 0) {
			if (!bookingRepo.existsByStartDateAndEndDateAndRoom(startDate, endDate, rooms.get(0))) {
				Booking booking = new Booking(rooms.get(0), startDate, endDate);
				bookingRepo.save(booking);
				System.out.println(booking);
				return;
			} else rooms.remove(0);
		}
		System.out.println("No available rooms for that type and date.");
	}
}