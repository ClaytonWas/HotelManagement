package com.hotel.service;

import java.util.List;

import com.hotel.model.Booking;

	public interface BookingService {
		void saveBooking(Booking booking);
		void updateBooking(Long bookingId, Booking booking);
		Booking getBooking(Long bookingId);
		List<Booking> getAllBookings();
		Boolean deleteBooking(Long bookingId);
	}