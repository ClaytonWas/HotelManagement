package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hotel.model.ProvidedService;
import com.hotel.service.ProvidedServiceService;

@Controller
public class ProvidedServiceController {
	ProvidedServiceService providedServiceService;

	public ProvidedServiceController(ProvidedServiceService providedServiceService) {
		this.providedServiceService = providedServiceService;
	}
	
	@GetMapping("/services")
	public String addService(Model model) {
		model.addAttribute("service", new ProvidedService());
		return "services";
	}
	
	@PostMapping("/processAddService")
	public String processAddService(ProvidedService service, Model model) {
		providedServiceService.saveService(service);
		return "redirect:/services";
	}
}