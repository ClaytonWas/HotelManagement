package service;

import java.util.List;
import model.Booking;

	public interface BookingService {
		Booking saveBooking(Booking booking);
		Booking updateBooking(Long bookingId, Booking booking);
		Booking getBooking(Long bookingId);
		List<Booking> getAllBookings();
		Boolean deleteBooking(Long bookingId);
	}