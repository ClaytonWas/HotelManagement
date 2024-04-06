package service;

import java.util.List;

import model.ProvidedService;
import repository.ProvidedServiceRepository;

public class ProvidedServiceServiceImpl implements ProvidedServiceService{
	
	ProvidedServiceRepository serviceRepo;
	
	public ProvidedService saveService(ProvidedService service) {
		
		if(!serviceRepo.existsByNameAndDescription(service.getName(), service.getDescription())) {
			serviceRepo.save(service);
		}
		
		return service;
		
	}
	
	public Boolean removeService(Long providedServiceId) {
		
		if ((serviceRepo.deleteByProvidedServiceId(providedServiceId)) >= 1) {
			return true;
		}
		
		return false;
	}
	
	public ProvidedService getService(Long providedServiceId) {
		
		return serviceRepo.findByProvidedServiceId(providedServiceId);
	}
	
	public ProvidedService updateService(Long providedServiceId, ProvidedService service) {
		
		if (serviceRepo.existsById(providedServiceId)) {
			
			ProvidedService serviceTU = getService(providedServiceId);
			
			serviceTU.setName(service.getName());
			serviceTU.setDescription(service.getDescription());
			serviceTU.setPrice(service.getPrice());
			
			serviceRepo.save(serviceTU);
			
			return serviceTU;
		}
		
		return service;
	}
	
	public List<ProvidedService> getAllServices(){
		return serviceRepo.findAll();
	}

}
