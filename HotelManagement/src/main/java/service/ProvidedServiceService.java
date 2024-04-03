package service;

import java.util.List;

import model.ProvidedService;

public interface ProvidedServiceService {
	ProvidedService saveService(ProvidedService service);
	Boolean removeService(Long providedServiceId);
	ProvidedService updateService(Long providedServiceId,ProvidedService service);
	List<ProvidedService> getAllServices();
	ProvidedService getService(Long providedServiceId);
	

}
