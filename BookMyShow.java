

import com.bms.models.Booking;
import com.bms.models.Movie;
import com.bms.models.Show;
import com.bms.models.ShowTime;
import com.bms.models.Theatre;
import com.bms.models.User;
import com.bms.services.BookingService;
import com.bms.services.MovieService;
import com.bms.services.ShowService;
import com.bms.services.TheatreService;
import java.util.Arrays;
import java.util.List;

public class BookMyShow {
	public static void main(String[] args) throws Exception {
			
		User rosy = new User("Rosy"
					,"987654321"
					,"rosy@psit.ac.in");

		User messy = new User("Messy"
					,"987654123"
					,"messy@psit.ac.in");									 

		System.out.println(rosy);
		System.out.println(messy.toString());

		Movie spiderMan = new Movie("SpiderMan",120,"Action");
		Movie threeIdiots = new Movie("3 Idiots",150,"Comedy");
		Movie robotTwo = new Movie("Robot 2",120,"Sci-Fi");

		System.out.println(spiderMan);
		System.out.println(threeIdiots);
		System.out.println(robotTwo);
		
		MovieService movieService = new MovieService();
		movieService.addMovie(spiderMan);
		movieService.addMovie(threeIdiots);
		movieService.addMovie(robotTwo);
		

		Theatre pvr = new Theatre("pvr","Kanpur",Arrays.asList("A1","A2","B1","B2"));
		Theatre inox = new Theatre("inox","Kanpur",Arrays.asList("A1","B1","C1"));
	
		System.out.println(pvr);
		System.out.println(inox);
	
		TheatreService theatreService = new TheatreService();
		theatreService.addTheatre(pvr);
		theatreService.addTheatre(inox);

		System.out.println(ShowTime.MORNING_SHOW);
		
		Show s1 = new Show(spiderMan,pvr,ShowTime.MORNING_SHOW);
		Show s2 = new Show(threeIdiots,inox,ShowTime.FIRST_SHOW);
		Show s3 = new Show(robotTwo,pvr,ShowTime.SECOND_SHOW);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		ShowService showService = new ShowService();
		showService.addShow(s1);
		showService.addShow(s2);
		showService.addShow(s3);

		System.out.println("User interaction begins...");
		String searchQuery = args[0]; // spider / pvr
		System.out.println("Searching movies for " + searchQuery);
		List<Movie> moviesSearchResult = movieService.searchMoviesByTitle(searchQuery);
		for(Movie movie: moviesSearchResult){
			System.out.println(movie);
		}
		System.out.println("------------- ");

		System.out.println("Searching theatres for " + searchQuery);
		List<Theatre> theatresSearchResult = theatreService.searchTheatresByName(searchQuery);
		for(Theatre theatre: theatresSearchResult){
			System.out.println(theatre);
		}
		System.out.println("------------- ");

		Theatre theatreClicked = theatresSearchResult.get(0);
		System.out.println("Searching shows for " + theatreClicked.getName());
		List<Show> showsSearchResult = showService.searchShowsByTheatre(theatreClicked);
		for(Show show: showsSearchResult){
			System.out.println(show);
		}
		System.out.println("------------- ");

		BookingService bookingService = BookingService.getBookingService();
		Booking rosyBooking = bookingService.bookTickets(rosy,s1,Arrays.asList("A1", "A2"));
		User bob = new User("Bob"
					,"987659321"
					,"bob@psit.ac.in");
		Booking bobBooking = bookingService.bookTickets(bob,s1,Arrays.asList("B1"));
		bookingService.cancelBooking(rosyBooking);
		Booking messyBooking = bookingService.bookTickets(messy,s1,Arrays.asList("A1", "A2"));

}
}