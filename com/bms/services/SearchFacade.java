package com.bms.services;

import com.bms.models.Movie;
import java.util.ArrayList;
import java.util.List;

public class SearchFacade {
	private final MovieService movieService;
	private final ShowService showService;
	private final TheatreService theatreService;

	public SearchFacade(MovieService movieService, ShowService showService, TheatreService theatreService){
		this.movieService = movieService;
		this.showService = showService;
		this.theatreService = theatreService;
	}
	public List<Movie> searchMovies(String searchQuery){ //  spider action
		List<Movie> result = new ArrayList<>();
		result.addAll(this.movieService.searchMoviesByGenre(searchQuery));
		result.addAll(this.movieService.searchMoviesByTitle(searchQuery));
		return result;
	}
	// public List<Movie> U List<Show> U List<Theatre> List<Entity>

}
