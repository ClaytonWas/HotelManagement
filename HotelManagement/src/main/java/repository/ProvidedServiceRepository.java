package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.ProvidedService;

public interface ProvidedServiceRepository extends JpaRepository<ProvidedService, Long> {

}
