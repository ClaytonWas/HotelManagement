package com.hotel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.model.Room;
import com.hotel.service.RoomService;


@Controller
public class RoomController {
	RoomService roomService;
	
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	@GetMapping("/rooms")
	public String addRoom(Model model) {
		List<Room> rooms = roomService.searchRooms(0, Double.MAX_VALUE, null);
	    model.addAttribute("rooms", rooms);
		return "rooms";
	}
	
	@PostMapping("/processAddRoom")
	public String proccessAddRoom(Room room, Model model) {
		roomService.addRoom(room);
		return "redirect:/rooms";
	}
	
	@GetMapping("/viewRoom")
	public String viewRoom(Model model) {
		model.addAttribute("rooms", roomService.getAllRooms());
		return "rooms";
	}
	
	@GetMapping("/searchRooms")
	public String searchRooms(Model model, 
			@RequestParam(required = false, value = "minPriceStr", defaultValue = "") String minPriceStr, 
	        @RequestParam(required = false, value = "maxPriceStr", defaultValue = "") String maxPriceStr, 
	        @RequestParam(required  = false, value = "roomType", defaultValue = "") String roomType) {
	    double minPrice = 0.0, maxPrice = 1000.0;
	    try { 
	        if (!minPriceStr.isEmpty()) minPrice = Double.parseDouble(minPriceStr); 
	    } catch (NumberFormatException e) { minPrice = 0.0; }
	    try { 
	        if (!maxPriceStr.isEmpty()) maxPrice = Double.parseDouble(maxPriceStr); 
	    } catch (NumberFormatException e)  { maxPrice = 1000.0; }
	        
	    List<Room> rooms = roomService.searchRooms(minPrice, maxPrice, roomType.isEmpty() ? null : roomType);
	    model.addAttribute("rooms", rooms);
	    
	    for (Room i : rooms) System.out.println(i);
	            
	    return "rooms"; // Return the rooms.html template directly
	}


	 
}