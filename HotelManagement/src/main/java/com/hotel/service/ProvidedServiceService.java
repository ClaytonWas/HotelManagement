package com.hotel.service;

import java.util.List;

import com.hotel.model.ProvidedService;

public interface ProvidedServiceService {
	void saveService(ProvidedService service);
	Boolean removeService(Long providedServiceId);
	void updateService(Long providedServiceId,ProvidedService service);
	List<ProvidedService> getAllServices();
	ProvidedService getService(Long providedServiceId);
	

}

