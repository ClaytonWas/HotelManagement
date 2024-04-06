package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Room;
import repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{
	RoomRepository roomRepo;
	
	public void addRoom(Room room) {
		if(!roomRepo.existsByRoomNumberAndType(room.getRoomNumber(), room.getType())) {
			roomRepo.save(room);
			
			System.out.println(room);
		}
		
		System.out.println("Failure to register room");
		
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
	
	public Room updateRoom(Long roomId, Room room) {
		
		if (roomRepo.existsById(roomId)) {
			
			Room roomTU = getRoom(roomId);
			
			roomTU.setRoomNumber(room.getRoomNumber());
			roomTU.setType(room.getType());
			roomTU.setPrice(room.getPrice());
			
			roomRepo.save(roomTU);
			
			return roomTU;
		}
		
		return room;
	}
	
	public List<Room> getAllRooms(){
		return roomRepo.findAll();
	}

}
