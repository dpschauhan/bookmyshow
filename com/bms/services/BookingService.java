package com.bms.services;

import com.bms.models.Booking;
import com.bms.models.BookingHistory;
import com.bms.models.Show;
import com.bms.models.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookingService { //
	private BookingHistory bookingHistory;
	private static BookingService bookingService = null;

	private BookingService(){
		this.bookingHistory = new BookingHistory();
	}

	public static BookingService getBookingService(){
		if(bookingService == null){
			bookingService = new BookingService();
		}
		return bookingService;
	}

	
	// C - create 
	public Booking bookTickets(User user, Show showToBook, List<String> seatsToBook) throws Exception{
		
		// other things to do
		// check if show has those seats available
		//this.show.getSeats();

		List<String> availableSeats = showToBook.getAvailableSeats(); // ["A1","A2","B1","B2"] n 
		System.out.println(availableSeats);

		// seatsToBook ["A1","A2"] m O(m*n) -> O(m*1)

		Set<String> availableSeatsSet = new HashSet(availableSeats);
		Set<String> seatsToBookSet = new HashSet(seatsToBook);
		if(!availableSeatsSet.containsAll(seatsToBookSet)){
			System.out.println("Booking failed for "+ user.getName() +  " for show" + showToBook +" seatsToBook: " + seatsToBook + " availableSeats: " + availableSeats);
			throw new Exception("Insufficient seats.Please try again..");
		}

		Booking booking = new Booking(user,showToBook,seatsToBook);
		// book keeping
		// update available seats
		List<String> newAvailableSeats = new ArrayList();
		for (String seat : availableSeats){
			if(!seatsToBookSet.contains(seat)){
				newAvailableSeats.add(seat);
			}

		}
		//availableSeats.removeAll(seatsToBook);
		showToBook.setAvailableSeats(newAvailableSeats);
		// add this booking to BookingHistory
		this.bookingHistory.addBooking(booking);
		System.out.println("Booking confirmed for "+ user.getName() +  " for show" + showToBook +" seatsBooked: " + seatsToBook);
		return booking;
	}

	public void cancelBooking(Booking booking){
		// add seats booked back to show 
		Show show = booking.getShow();
		List<String> newAvailableSeats = new ArrayList();
		newAvailableSeats.addAll(show.getAvailableSeats()); // ["B1","B2"]
		newAvailableSeats.addAll(booking.getSeatsBooked()); // ["A1","A2"]
		show.setAvailableSeats(newAvailableSeats); // ["A1","A2","B1","B2"]
		// other things to do
		// remove this booking from BookingHistory
		this.bookingHistory.removeBooking(booking);
		System.out.println("Booking cancelled for "+ booking.getUser().getName() +  " for show" + show);
		
	}

	
}
