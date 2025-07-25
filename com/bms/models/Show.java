package com.bms.models;

import java.util.List;

public class Show {
	private final Movie movie;
	private final Theatre theatre;
	private final ShowTime showTime;
	private List<String> availableSeats;

	public Show(Movie movie, Theatre theatre, ShowTime showTime){
		this.movie = movie;
		this.theatre = theatre;
		this.showTime = showTime;
		this.availableSeats = this.theatre.getSeats();
	}

	public Movie getMovie() {
		return movie;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public ShowTime getShowTime() {
		return showTime;
	}

	public List<String> getAvailableSeats() {
		return availableSeats;
	}	
    public void setAvailableSeats(List<String> availableSeats) {
        this.availableSeats = availableSeats;
    }

		@Override
		public String toString() {
				return "Show details for " + this.movie + " \n" + 
								"theatre: " + this.theatre +"\n" + 
								"showTime: " + this.showTime +"\n"+
								"availableSeats: " + this.availableSeats +"\n";
		}
	
	
	
}
