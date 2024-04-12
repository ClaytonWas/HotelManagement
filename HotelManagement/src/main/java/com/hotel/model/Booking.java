package com.hotel.model;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.repository.RoomRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOKING")
public class Booking {
	
	@Id
	@GeneratedValue
	@Column(name = "Booking_ID")
	private Long bookingId;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name = "customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "room")
	private Room room;
	
	@ManyToMany
	@JoinTable(name = "services_in_booking",
			joinColumns = {
					@JoinColumn(name = "Booking_Id", referencedColumnName = "Booking_ID",
							nullable = false, updatable = false, insertable = false)},
			inverseJoinColumns = {
					@JoinColumn(name = "ProvidedService_Id", referencedColumnName = "ProvidedService_ID",
							nullable = false, updatable = false, insertable = false)})
	private Set<ProvidedService> providedServices;
	
	public Booking() {}
		
	public Booking(Long bookingId, Customer customer, Room room, LocalDate startDate, LocalDate endDate) {
		this.bookingId = bookingId;
		this.customer = customer;
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Booking(Room room, LocalDate startDate, LocalDate endDate) {
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public LocalDate getStartDate() { return startDate; }
	public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
	public LocalDate getEndDate() { return endDate; }
	public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
	public Long getBookingId() { return bookingId; }
	public void setBookingId(Long bookingId) { this.bookingId = bookingId; }
	public Customer getCustomer() { return customer; }
	public void setCustomer(Customer customer) { this.customer = customer; }
	public Room getRoom() { return room; }
	public void setRoom(Room room) { this.room = room; }
	public Set<ProvidedService> getProvidedServices() { return providedServices; }
	public void setProvidedServices(Set<ProvidedService> providedServices) { this.providedServices = providedServices; }

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", roomNum=" + (this.room != null ? room.getRoomNumber() : "error, no associated room")
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}