package com.bms.services;

import com.bms.models.Movie;
import java.util.ArrayList;
import java.util.List;

public class MovieService {  // CRUD on Movies
	List<Movie> movies;

	public MovieService(){
		this.movies = new ArrayList<>();
	}

	public void addMovie(Movie movie){
		movies.add(movie);
	}

	public Boolean removeMovie(Movie movie){
		return movies.remove(movie);
	}

	public List<Movie> searchMoviesByTitle(String searchQuery){
		List<Movie> result = new ArrayList<>();
		for(Movie movie: this.movies){
			if (movie.getTitle().toLowerCase().contains(searchQuery.trim().toLowerCase())){
				result.add(movie);
			}
		}
		return result;
	}

	public List<Movie> searchMoviesByGenre(String searchQuery){
		List<Movie> result = new ArrayList<>();
		for(Movie movie: this.movies){
			if (movie.getGenre().toLowerCase().contains(searchQuery.trim().toLowerCase())){
				result.add(movie);
			}
		}
		return result;
	}
	
}
