package com.bms.models;

import java.util.List;

public class Booking {
	private final User user; // Rosy
	private final Show show; // (spiderman , pvr , MORNING_SHOW)
	private final List<String> seatsBooked; // 2 -  "A1","A2" 
	// List<Seat> Seat - id , type - SeatType

	public Booking(final User user,final Show show,final List<String> seatsBooked){
		this.user = user;
		this.show = show;
		this.seatsBooked = seatsBooked;
	}
    public List<String> getSeatsBooked() {
        return seatsBooked;
    }
    public Show getShow() {
        return show;
    }
    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Booking for " + this.user.getName() + "\n"+
				      "for show for " + this.show +  "\n"+
							"seats Booked: " + this.seatsBooked;
    }
		

	
}