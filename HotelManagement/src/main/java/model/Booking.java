package model;

//The git file had it labeled in a file called entity might cause problems later 


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_details")
public class Booking {
	
	@Id
	@Column(name = "booking_id")
	private Long bookingId;
	@Column(name="guest_name")
	private String guestName;
	
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
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}