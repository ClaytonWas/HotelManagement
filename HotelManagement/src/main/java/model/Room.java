package model;
//idk

import java.time.LocalDate;
import java.util.HashMap;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROOM")
public class Room {
	
	@Id
	@Column(name = "Room_ID")
	private long roomId;
	
	@Column(name = "room_number")
	private String roomNumber;
	
	@Column(name = "room_type")
	private String type;
	
	@Column(name = "room_price")
	private double price;
	
	@OneToMany(mappedBy = "room")
	private HashMap<LocalDate, Booking> bookings;
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Room(long roomId, String roomNumber, String type, double price,
			HashMap<LocalDate, Booking> bookings) {
		super();
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.type = type;
		this.price = price;
		this.bookings = bookings;
	}


	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public HashMap<LocalDate, Booking> getBookings() {
		return bookings;
	}

	public void setBookings(HashMap<LocalDate, Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", type=" + type + ", price=" + price + "]";
	}
	
}
