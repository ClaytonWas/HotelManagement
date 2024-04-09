package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		super();
		this.roomService = roomService;
	}
	
	@GetMapping("/viewRoom")
	public String viewRoom(Model model) {
		
		List<Room> rooms = roomService.getAllRooms();
		
		model.addAttribute("rooms", rooms);
		
		return "rooms";
		
	}
	
	@GetMapping("/addRoom")
	public String addRoom(Model model) {
		
		model.addAttribute("room", new Room());
		
		return "createRoom";
	}
	
	@PostMapping("/processAddRoom")
	public String proccessAddRoom(Room room, Model model) {
		
		roomService.addRoom(room);
		
		return "redirect:/addRoom";
	}
	
	@GetMapping("/searchRooms")
	public String searchRooms(Model model, @RequestParam(required = false, value = "minPriceStr", defaultValue = "") String minPriceStr, 
			@RequestParam(required = false, value = "maxPriceStr", defaultValue = "") String maxPriceStr, 
			@RequestParam(required  = false, value = "roomType", defaultValue = "") String roomType)
	{
		
		double minPrice = 0.0;
		double maxPrice = 0.0;
		
		List<Room> rooms = roomService.getAllRooms();
		
		if ((!minPriceStr.isEmpty()) || (!maxPriceStr.isEmpty()))
		{
				try {
				        if (!minPriceStr.isEmpty()) 
				        {
				            minPrice = Double.parseDouble(minPriceStr);
				        }
			    } 
				catch (NumberFormatException e) 
				{
				    	
					minPrice = 0.0;
			    }
				
			    try {
			    	if (!maxPriceStr.isEmpty()) 
			    	{
			    		maxPrice = Double.parseDouble(maxPriceStr);
			    	}
			    } 
			    catch (NumberFormatException e) 
			    {
			    		
			    		maxPrice = 0.0;
			    }
			          
			    if (minPrice > 0.0 && maxPrice == 0.0) 
			    {
					if (roomType.isEmpty())
					{
						rooms = roomService.searchByMinPriceOnly(minPrice);
					}
					else
					{
						rooms = roomService.searchByMinPriceAndRoomType(minPrice, roomType);
					}
					
				}
			    
			    if (maxPrice > 0.0 && minPrice == 0.0)
			    {
			    	if (roomType.isEmpty())
			    	{
			    		rooms = roomService.searchByMaxPriceOnly(maxPrice);
			    	}
			    	else
			    	{
			    		rooms = roomService.searchByMaxPriceAndRoomType(maxPrice, roomType);
			    	}
			    }
			    
			    if (minPrice > 0.0 && maxPrice > 0.0)
			    {
			    	if (minPrice < maxPrice)
			    	{
			    		if (roomType.isEmpty()) 
				    	{
				    		rooms = roomService.searchByMinPriceAndMaxPrice(minPrice, maxPrice);
				    	}
			    		else
			    		{
			    			rooms = roomService.searchByMinPriceAndMaxPriceAndType(minPrice, maxPrice, roomType);
			    		}
			    	}
			    	
			    }
		}
		else 
		{
			if (!roomType.isEmpty())
			{
				rooms = roomService.searchByOnlyType(roomType);
			}
			
		}
		
		model.addAttribute("rooms", rooms);
				
		return "rooms";
	}
	
}

