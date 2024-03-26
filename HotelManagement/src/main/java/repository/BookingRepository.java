package repository;
import org.springframework.data.jpa.repository.JpaRepository;
import model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> { 

}