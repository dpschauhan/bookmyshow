package com.bms.models;

import java.util.List;

public class Theatre {
	private final String name; // pvr
	private final String location; // kanpur city or (lat,lon) Coordinate
	private final List<String> seats; 
	// "A1","A2","B1","B2"
	// List<Screen> screens; Screen - id, name, List<Seat> seats
	private final int seatCapacity; // 150

	public Theatre(String name, String location, List<String> seats){
		this.name = name;
		this.location = location;
		this.seats = seats;
		this.seatCapacity = this.seats.size();
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public List<String> getSeats() {
		return seats;
	}
	@Override
	public String toString() {
			return "Theatre details for " + this.name + " \n" + 
							"location: " + this.location +"\n" + 
							"seatCapacity: " + this.seatCapacity +"\n";
	}
}
