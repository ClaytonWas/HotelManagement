package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Room;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // You can add custom methods here if needed
	
	boolean existsByRoomNumberAndType(Integer roomNumber, String type);
	
	@Query("select r from Room r WHERE r.roomId = ?1")
	Room findByRoomId(Long roomId);
	
	int deleteByRoomId(Long roomId);
	
	List<Room> findAll();
	
	
}
