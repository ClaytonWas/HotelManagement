/*
package com.hotel.model;

// The git file had it labeled in a file called entity might cause problems later 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel_details")
public class Hotel {
	@Id
	@Column(name = "hotel_id")
	private long id;
	
	@Column(name = "hotel_name")
	private String name;
	
	@Column(name = "manager_name")
	private String managerName;
	
	@Column(name = "hotel_location")
	private String location;
	
	@OneToOne(mappedBy = "hotel")
	private Booking booking;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
}
*/