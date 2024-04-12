package com.hotel.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROVIDEDSERVICE")
public class ProvidedService {
	
	@Id
	@GeneratedValue
	@Column(name = "ProvidedService_ID")
	private long providedServiceId;
	
	@Column(name = "service_name")
	private String name;
	
	@Column(name = "service_description")
	private String description;
	
	@Column(name = "service_price")
	private double price;
	
	@ManyToMany(mappedBy = "providedServices")
	private Set<Booking> bookings;
	
	public ProvidedService() {}

	public ProvidedService(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public void setProvidedServiceId(long providedServiceId) { this.providedServiceId = providedServiceId; }
	public long getProvidedServiceId() { return providedServiceId; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }
	public Set<Booking> getBookings() { return bookings; }
	public void setBookings(Set<Booking> bookings) { this.bookings = bookings; }

	@Override
	public String toString() {
		return "ProvidedService [name=" + name + ", description=" + description + ", price=" + price + "]";
	}
}