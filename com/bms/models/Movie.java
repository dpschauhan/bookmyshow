package com.bms.models;
public class Movie {
	private final String title; // spiderman
	private final int duration; // 120 mins
	private final String genre; // sci-fiction

	public Movie(String title,int duration,String genre){
		this.title = title;
		this.duration = duration;
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public String getGenre() {
		return genre;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
			return "Movie details for " + this.title + " \n" + 
							"genre: " + this.genre +"\n" + 
							"duration: " + this.duration +"\n";
	}


}
