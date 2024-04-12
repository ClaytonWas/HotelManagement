package com.hotel.model;

import jakarta.persistence.CascadeType;

//The git file had it labeled in a file called entity might cause problems later 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name = "Customer_ID")
	private long customerId;
	
	@Column(name="customer_name")
	private String name;
	
	private byte age;
	private String gender;
	
	@Column(name="customer_phone_number")
	private String phoneNumber;
	
	@Column(name="customer_email")
	private String email;
	
	@Column(length = 10)
	private long contact;
	private String city;
	
	@OneToMany(mappedBy = "customerId",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Booking> bookings;
	
	
	public Customer() {
		super();
		this.bookings = new HashSet<Booking>();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(long customerId, String name, String phoneNumber, String email) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public Set<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", bookings=" + bookings + "]";
	}

	
}