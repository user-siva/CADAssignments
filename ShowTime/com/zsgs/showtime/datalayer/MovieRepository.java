package ShowTime.com.zsgs.showtime.datalayer;

import ShowTime.com.zsgs.showtime.dto.Movie;
import ShowTime.com.zsgs.showtime.dto.Time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRepository {
    private static MovieRepository instance;

    private Map<Movie, List<Time>> movieShowTimes;

    private MovieRepository() {
        movieShowTimes = new HashMap<>();
        loadSampleData();
    }

    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }

    public List<Movie> getAvailableMovies() {
        return new ArrayList<>(movieShowTimes.keySet());
    }

    public List<Time> getShowTimesForMovie(Movie movie) {
        return movieShowTimes.getOrDefault(movie, new ArrayList<>());
    }

    public void addMovieShowTime(Movie movie, Time showTime) {
        if (!movieShowTimes.containsKey(movie)) {
            movieShowTimes.put(movie, new ArrayList<>());
        }
        movieShowTimes.get(movie).add(showTime);
    }

    private void loadSampleData() {
        Movie movie1 = new Movie("Inception", "Sci-Fi", 148);
        Movie movie2 = new Movie("The Dark Knight", "Action", 152);
        Movie movie3 = new Movie("Interstellar", "Sci-Fi", 169);

        addMovieShowTime(movie1, new Time("2024-09-30", "18:00"));
        addMovieShowTime(movie1, new Time("2024-09-30", "21:00"));

        addMovieShowTime(movie2, new Time("2024-09-30", "17:00"));
        addMovieShowTime(movie2, new Time("2024-09-30", "20:00"));

        addMovieShowTime(movie3, new Time("2024-09-30", "19:00"));
        addMovieShowTime(movie3, new Time("2024-09-30", "22:00"));
    }
}
