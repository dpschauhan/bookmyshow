package com.bms.models;
import java.util.ArrayList;
import java.util.List;

public class BookingHistory {
	List<Booking> bookingHistory;

	public BookingHistory(){
		bookingHistory = new ArrayList<>();
	}

	// C - create
	public void addBooking(Booking booking){
		this.bookingHistory.add(booking);
	}

	// D - delete
	public Boolean removeBooking(Booking booking){
		return this.bookingHistory.remove(booking);
	}

}
