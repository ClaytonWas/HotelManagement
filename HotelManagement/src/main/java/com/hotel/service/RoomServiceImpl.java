package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Room;
import com.hotel.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{
	private RoomRepository roomRepo;
	
	@Autowired
	public RoomServiceImpl(RoomRepository roomRepo) {
		super();
		this.roomRepo = roomRepo;
	}
	
	public void addRoom(Room room) {
		if(!roomRepo.existsByRoomNumberAndType(room.getRoomNumber(), room.getType())) {
			roomRepo.save(room);
			
			System.out.println(room);
		}
		else {
			System.out.println("Failure to register room");
		}
			
		//return room;
	}
	
	
	public Boolean removeRoom(Long roomId) {
		
		if((roomRepo.deleteByRoomId(roomId)) >= 1) {
			return true;
		}
		
		return false;
	}
	
	public Room getRoom(Long roomId) {
		
		return roomRepo.findByRoomId(roomId);
	}
	
	public void updateRoom(Long roomId, Room roomUpdated) {
		
		if (roomRepo.existsById(roomId)) {
			
			Room roomTU = getRoom(roomId);
			
			roomTU.setBookings(roomUpdated.getBookings());
			
			roomRepo.save(roomTU);
			
			System.out.println("Room successfully updated");
		}
		
		System.out.println("Failure to update room");
	}
	
	public List<Room> getAllRooms(){
		return roomRepo.findAll();
	}
	
	public List<Room> searchByMinPriceOnly(double minPrice){
		return roomRepo.searchByPriceGreaterThanEqual(minPrice);
	}
	
	public List<Room> searchByMinPriceAndRoomType(double minPrice, String type){
		return roomRepo.searchByPriceGreaterThanEqualAndType(minPrice, type);
	};
	
	public List<Room> searchByMaxPriceOnly(double maxPrice){
		return roomRepo.searchByPriceLessThanEqual(maxPrice);
	}
	
	public List<Room> searchByMaxPriceAndRoomType(double maxPrice, String type){
		return roomRepo.searchByPriceLessThanEqualAndType(maxPrice, type);
	};
	
	public List<Room> searchByMinPriceAndMaxPrice(double minPrice, double maxPrice){
		return roomRepo.searchByPriceBetween(minPrice, maxPrice);
	};
	
	public List<Room> searchByMinPriceAndMaxPriceAndType(double minPrice, double maxPrice, String type){
		return roomRepo.searchByPriceBetweenAndType(minPrice, maxPrice, type);
	}
	
	public List<Room> searchByOnlyType(String type){
		return roomRepo.searchByType(type);
	}
}
