package com.bms.services;

import java.util.ArrayList;
import java.util.List;

import com.bms.models.Theatre;

public class TheatreService {
	List<Theatre> theatres;

	public TheatreService(){
		this.theatres = new ArrayList<>();
	}

	public void addTheatre(Theatre theatre){
		this.theatres.add(theatre);
	}

	public Boolean removeTheatre(Theatre theatre){
		return this.theatres.remove(theatre);
	}
	public List<Theatre> searchTheatresByName(String searchQuery){
		List<Theatre> result = new ArrayList<>();
		for(Theatre theatre: theatres){
			if (theatre.getName().toLowerCase().contains(searchQuery.trim().toLowerCase())){
				result.add(theatre);
			}
		}
		return result;

	}

	public List<Theatre> searchTheatresByLocation(String searchQuery){
		List<Theatre> result = new ArrayList<>();
		for(Theatre theatre: theatres){
			if (theatre.getLocation().toLowerCase().contains(searchQuery.trim().toLowerCase())){
				result.add(theatre);
			}
		}
		return result;

	}


}
