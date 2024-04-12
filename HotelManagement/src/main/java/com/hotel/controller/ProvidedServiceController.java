package com.hotel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.model.Booking;
import com.hotel.model.ProvidedService;
import com.hotel.service.ProvidedServiceService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProvidedServiceController {
	ProvidedServiceService providedServiceService;

	public ProvidedServiceController(ProvidedServiceService providedServiceService) {
		super();
		this.providedServiceService = providedServiceService;
	}
	
	
	@GetMapping("/viewService")
	public String viewService(Model model) {
		
		List<ProvidedService> services = providedServiceService.getAllServices();
		
		model.addAttribute("services", services);
		
		return "services";
	}
	
	@GetMapping("/addService")
	public String addService(Model model) {
		
		model.addAttribute("service", new ProvidedService());
		
		return "createService";
	}
	
	@GetMapping("/submitServices")
	public String sumbitServices(@RequestParam(value = "selectedServices") List<Long> selectedServices, HttpSession httpSession)
	{
		Booking sessionBooking = (Booking) httpSession.getAttribute("booking");
		
		for (long serviceId: selectedServices)
		{
			ProvidedService selectedService = providedServiceService.getService(serviceId);
			
			sessionBooking.getProvidedServices().add(selectedService);
			
			selectedService.getBookings().add(sessionBooking);
			
			//Add a session attribute for the most recent serviceId
			httpSession.setAttribute("serviceId", serviceId);
		}
		
		System.out.println(sessionBooking.getProvidedServices());
		
		return "redirect:/viewDetails";
	}
	
	@PostMapping("/processAddService")
	public String processAddService(ProvidedService service, Model model) {
		
		providedServiceService.saveService(service);
		
		return "redirect:/addService";
	}
	

}

/*
 * package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anudip.Hotelmanagement.entity.Hotel;
import com.anudip.Hotelmanagement.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/add")
	public ResponseEntity<?> saveCustomer(@RequestBody() Hotel hotel) {
		Hotel dbhotel = hotelService.addHotel(hotel);
		return ResponseEntity.ok().body(dbhotel);
	}
	
	@DeleteMapping("/remove")
	public String deletedate(@PathVariable("id") Long id) {
		Hotel data = hotelService.getHotel(id);
		Boolean test = hotelService.removeHotel(id);
		return (data != null) ? (test) ? "deleted successfully" : "no id found" : "no data found";
	}
}
 */

