package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import model.Room;
import service.RoomService;

@Controller
public class RoomController {
	RoomService roomService;
	
	@Autowired
	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	
	@GetMapping("/addRoom")
	public String addRoom() {
		return "rooms";
	}
	
	@PostMapping("/processAddRoom")
	public String proccessAddRoom(Room room, Model model) {
		
		roomService.addRoom(room);
		
		System.out.println(room);
		
		return "redirect:/addRoom";
	}
	
}
