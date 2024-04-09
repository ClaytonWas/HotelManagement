package com.hotel.service;

import java.util.List;

import com.hotel.model.Room;

public interface RoomService {
	void addRoom(Room room);
	Boolean removeRoom(Long roomId);
	void updateRoom(Long roomId, Room room);
	List<Room> searchByMinPriceOnly(double minPrice);
	List<Room> searchByMinPriceAndRoomType(double minPrice, String type);
	List<Room> searchByMaxPriceOnly(double maxPrice);
	List<Room> searchByMaxPriceAndRoomType(double maxPrice, String type);
	List<Room> searchByMinPriceAndMaxPrice(double minPrice, double maxPrice);
	List<Room> searchByMinPriceAndMaxPriceAndType(double minPrice, double maxPrice, String type);
	List<Room> searchByOnlyType(String type);
	List<Room> getAllRooms();
	Room getRoom(Long roomId);
	
}

