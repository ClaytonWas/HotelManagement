package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Room;
import com.hotel.repository.RoomRepository;

@Service
public class RoomService {
	private RoomRepository roomRepo;
	
	@Autowired
	public RoomService(RoomRepository roomRepo) {
		this.roomRepo = roomRepo;
	}
	
	public void addRoom(Room room) {
		if(!roomRepo.existsByRoomNumberAndType(room.getRoomNumber(), room.getType())) {
			roomRepo.save(room);
			
			System.out.println(room);
		} else System.out.println("Failure to register room");
	}
	
	public Boolean removeRoom(Long roomId) {
		if((roomRepo.deleteByRoomId(roomId)) >= 1) return true;		
		return false;
	}
	
	public Room getRoom(Long roomId) {
		return roomRepo.findByRoomId(roomId);
	}
	
	public void updateRoom(Long roomId, Room room) {
		if (roomRepo.existsById(roomId)) {
			
			Room roomTU = getRoom(roomId);
			
			roomTU.setRoomNumber(room.getRoomNumber());
			roomTU.setType(room.getType());
			roomTU.setPrice(room.getPrice());
			
			roomRepo.save(roomTU);
			
			System.out.println("Room successfully updated");
		}
		System.out.println("Failure to update room");
	}
	
	public List<Room> getAllRooms(){
		return roomRepo.findAll();
	}
	
	public List<Room> searchRooms(double min, double max, String type) {
		return roomRepo.findAll();
		//if (type == null) return roomRepo.searchByPriceBetween(min, max);
		//return roomRepo.searchByPriceBetweenAndType(min, max, type);
	}
}