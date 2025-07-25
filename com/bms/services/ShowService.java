package com.bms.services;

import java.util.ArrayList;
import java.util.List;

import com.bms.models.Movie;
import com.bms.models.Show;
import com.bms.models.Theatre;

public class ShowService {
	private List<Show> shows;

	public ShowService(){
		this.shows = new ArrayList<>();
	}

	public void addShow(Show show){
		this.shows.add(show);
	}
	public Boolean removeShow(Show show){
		return this.shows.remove(show);
	}
	
	public List<Show> searchShowsByMovie(Movie movie){
		List<Show> result = new ArrayList<>();
		for(Show show: this.shows){
			if (show.getMovie().equals(movie)){
				result.add(show);
			}
		}
		return result;
	}

	public List<Show> searchShowsByTheatre(Theatre theatre){
		List<Show> result = new ArrayList<>();
		for(Show show: this.shows){
			if (show.getTheatre().equals(theatre)){
				result.add(show);
			}
		}
		return result;
	}
	
}
