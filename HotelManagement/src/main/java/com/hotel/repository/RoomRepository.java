package com.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // You can add custom methods here if needed
	
	boolean existsByRoomNumberAndType(String roomNumber, String type);
	
	@Query("select r from Room r WHERE r.roomId = ?1")
	Room findByRoomId(Long roomId);
	
	int deleteByRoomId(Long roomId);
	
	List<Room> findAll();
	
	
}
