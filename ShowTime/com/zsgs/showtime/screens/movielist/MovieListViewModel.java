package ShowTime.com.zsgs.showtime.screens.movielist;

import java.util.List;
import ShowTime.com.zsgs.showtime.dto.Movie;
import ShowTime.com.zsgs.showtime.datalayer.MovieRepository;

public class MovieListViewModel {
    private MovieListView movieListScreen;

    public MovieListViewModel(MovieListView movieListScreen) {
        this.movieListScreen = movieListScreen;
    }

    public void displayAvailableMovies() {
        List<Movie> availableMovies = MovieRepository.getInstance().getAvailableMovies();
        movieListScreen.showAvailableMovies(availableMovies);
    }
}
