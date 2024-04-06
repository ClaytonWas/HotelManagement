package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hotel.model.Room;
import com.hotel.service.RoomService;

@Controller
public class RoomController {
	RoomService roomService;
	
	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	
	@GetMapping("/addRoom")
	public String addRoom(Model model) {
		model.addAttribute("room", new Room());
		
		return "rooms";
	}
	
	@PostMapping("/processAddRoom")
	public String proccessAddRoom(Room room, Model model) {
		
		roomService.addRoom(room);
		
		return "redirect:/addRoom";
	}
	
}

