package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Room;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // You can add custom methods here if needed
}
