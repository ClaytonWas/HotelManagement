package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.ProvidedService;
import com.hotel.repository.ProvidedServiceRepository;

@Service
public class ProvidedServiceService {
	private ProvidedServiceRepository serviceRepo;
	
	@Autowired
	public ProvidedServiceService(ProvidedServiceRepository serviceRepo) {
		super();
		this.serviceRepo = serviceRepo;
	}
	
	public void saveService(ProvidedService service) {
		
		if(!serviceRepo.existsByNameAndDescription(service.getName(), service.getDescription())) {
			serviceRepo.save(service);
			
			System.out.println(service);
		}
		else {
			System.out.println("Failure to register service");
		}
		
		
		
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
	
	public void updateService(Long providedServiceId, ProvidedService service) {
		
		if (serviceRepo.existsById(providedServiceId)) {
			
			ProvidedService serviceTU = getService(providedServiceId);
			
			serviceTU.setName(service.getName());
			serviceTU.setDescription(service.getDescription());
			serviceTU.setPrice(service.getPrice());
			
			System.out.println("Service updated successfully");
		}
		
		System.out.println("Failure to update service");
	}
	
	public List<ProvidedService> getAllServices(){
		return serviceRepo.findAll();
	}

}

