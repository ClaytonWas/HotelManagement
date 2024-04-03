package service;

import java.util.List;

import model.Room;

public interface RoomService {
	Room addRoom(Room room);
	Boolean removeRoom(Long roomId);
	Room updateRoom(Long roomId, Room room);
	List<Room> getAllRooms();
	Room getRoom(Long roomId);
	
}
