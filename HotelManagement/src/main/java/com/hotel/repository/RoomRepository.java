package com.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
	boolean existsByRoomNumberAndType(String roomNumber, String type);
	
	List<Room> searchByPriceBetween(double min, double max);
	List<Room> searchByPriceBetweenAndType(double min, double max, String type);
	
	@Query("select r from Room r WHERE r.roomId = ?1")
	Room findByRoomId(Long roomId);
	
	int deleteByRoomId(Long roomId);
	
	List<Room> findAll();
	
	
}
