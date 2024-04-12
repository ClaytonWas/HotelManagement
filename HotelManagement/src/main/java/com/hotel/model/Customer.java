package com.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name = "Customer_ID")
	private long customerId;
	
	@Column(name="customer_name")
	private String name;
	
	@Column(name="customer_phone_number")
	private String phoneNumber;
	
	@Column(name="customer_email")
	private String email;
	
	@OneToMany(mappedBy = "customer")
	private Map<LocalDate, Booking> bookings;
	
	public Customer() {}
	
	public Customer(String name, String phoneNumber, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.bookings = new HashMap<LocalDate, Booking>();
	}
	
	public void setCustomerId(long customerId) { this.customerId = customerId; }
	public String getPhoneNumber() { return phoneNumber; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public long getCustomerId() { return customerId; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Map<LocalDate, Booking> getBookings() { return bookings; }
	public void setBookings(Map<LocalDate, Booking> bookings) { this.bookings = bookings; }

	@Override
	public String toString() {
		return "Customer [name=" + name  + ", phoneNumber=" + phoneNumber + ", email=" + email + ", bookings=" + bookings + "]";
	}
}