package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.ProvidedService;

@Repository
public interface ProvidedServiceRepository extends JpaRepository<ProvidedService, Long> {
	
	boolean existsByNameAndDescription(String name, String description);
	
	@Query("select s from ProvidedService s WHERE ProvidedService.providedServiceId = ?1")
	ProvidedService findByProvidedServiceId(Long providedServiceId);
	
	int deleteByProvidedServiceId(Long providedServiceId);
	
	List<ProvidedService> findAll();

}
