package com.hotel.service;

import java.util.List;

import com.hotel.model.Room;

public interface RoomService {
	void addRoom(Room room);
	Boolean removeRoom(Long roomId);
	void updateRoom(Long roomId, Room room);
	List<Room> getAllRooms();
	Room getRoom(Long roomId);
	
}

