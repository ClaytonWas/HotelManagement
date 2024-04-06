package com.hotel.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> { 
	
	boolean existsByStartDateAndRoomId(LocalDate startDate, Long roomId);
	
	@Query("select b from Booking b WHERE b.bookingId = ?1")
	Booking findByBookingId(Long bookingId);
	
	int deleteByBookingId(Long bookingId);
	
	List<Booking> findAll();
	
}