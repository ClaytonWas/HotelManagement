package service;

import java.util.List;

import model.Booking;
import repository.BookingRepository;

public class BookingServiceImpl implements BookingService{
	
	BookingRepository bookingRepo;
	
	public BookingServiceImpl(BookingRepository bookingRepo) {
		super();
		this.bookingRepo = bookingRepo;
	}

	public Booking saveBooking(Booking booking) {
		
		if (!bookingRepo.existsByStartDateAndRoomId(booking.getStartDate(), booking.getRoomId())) {
			bookingRepo.save(booking);
		}
		
		return booking;
	}
	
	public Boolean deleteBooking(Long bookId) {
		
		if ((bookingRepo.deleteByBookingId(bookId)) >=1) {
			return true;
		}
		
		return false;
	}
	
	public Booking getBooking(Long bookingId) {
		
		return bookingRepo.findByBookingId(bookingId);
	}
	
	public Booking updateBooking(Long bookingId, Booking booking) {
		
		if (bookingRepo.existsById(bookingId)) {
			
			Booking bookingTU = getBooking(bookingId);
			
			bookingTU.setCustomerId(booking.getCustomerId());
			bookingTU.setRoomId(booking.getRoomId());
			bookingTU.setStartDate(booking.getStartDate());
			bookingTU.setEndDate(booking.getEndDate());
			
			bookingRepo.save(bookingTU);
			
			return bookingTU;
		}
		
		return booking;
	}
	
	public List<Booking> getAllBookings(){
		
		return bookingRepo.findAll();
	}

}
