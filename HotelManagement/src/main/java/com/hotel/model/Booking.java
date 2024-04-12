package com.hotel.model;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.CascadeType;

//The git file had it labeled in a file called entity might cause problems later 


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOKING")
public class Booking {
	
	@Id
	@GeneratedValue
	@Column(name = "Booking_ID")
	private Long bookingId;
	@Column(name="guest_name")
	private String guestName;
	
	//@Column(name = "customerId_ID")
	//private long customerIdId;
	
	//@Column(name = "room_ID")
	//private long roomId;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	// Guest have to provide their Identification Details (eg - Aadhar, Driving licence, PAN card, etc)
	@Column(name = "id_proof")
	private String guestIdProof;
	
	@Column(name = "guest_address")
	private String address;
	
	@Column(name="guest_contact")
	private long contact;
	
	// Guest will provide the approx price of the room which is above minimum price
	@Column(name="room_price")
	private int price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Customer_ID")
	private Customer customerId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Room_ID")
	private Room roomId;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "services_in_booking",
			joinColumns = {
					@JoinColumn(name = "Booking_Id", referencedColumnName = "Booking_ID",
							nullable = false, updatable = false, insertable = false)},
			inverseJoinColumns = {
					@JoinColumn(name = "ProvidedService_Id", referencedColumnName = "ProvidedService_ID",
							nullable = false, updatable = false, insertable = false)})
	private Set<ProvidedService> providedServices;
	
	public Booking() {
		super();
		this.providedServices = new HashSet<ProvidedService>();
		// TODO Auto-generated constructor stub
	}
		
	public Booking(LocalDate startDate, LocalDate endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Booking(Long bookingId, String guestName, LocalDate startDate,
			LocalDate endDate, String guestIdProof, String address, long contact, int price, Customer customerId,
			Room roomId, Set<ProvidedService> providedServices) {
		super();
		this.bookingId = bookingId;
		this.guestName = guestName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.guestIdProof = guestIdProof;
		this.address = address;
		this.contact = contact;
		this.price = price;
		this.customerId = customerId;
		this.roomId = roomId;
		this.providedServices = providedServices;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestIdProof() {
		return guestIdProof;
	}

	public void setGuestIdProof(String guestIdProof) {
		this.guestIdProof = guestIdProof;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Customer getcustomerId() {
		return customerId;
	}

	public void setcustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	
	
	public Room getRoomId() {
		return roomId;
	}


	public void setRoom(Room roomId) {
		this.roomId = roomId;
	}
	
	

	public Set<ProvidedService> getProvidedServices() {
		return providedServices;
	}


	public void setProvidedServices(Set<ProvidedService> providedServices) {
		this.providedServices = providedServices;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}