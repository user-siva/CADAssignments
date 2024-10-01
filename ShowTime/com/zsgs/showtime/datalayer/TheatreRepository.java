package ShowTime.com.zsgs.showtime.datalayer;

import java.util.ArrayList;
import java.util.List;
import ShowTime.com.zsgs.showtime.dto.Movie;
import ShowTime.com.zsgs.showtime.dto.Theatre;

public class TheatreRepository {

    private static TheatreRepository instance;
    private List<Theatre> theatres;

    private TheatreRepository() {
        theatres = new ArrayList<>();
        theatres.add(new Theatre("1", "Grand Cinema", "Downtown", List.of("Inception", "The Dark Knight")));
        theatres.add(new Theatre("2", "Royal Theatre", "Uptown", List.of("Interstellar", "The Dark Knight")));
    }

    public static TheatreRepository getInstance() {
        if (instance == null) {
            instance = new TheatreRepository();
        }
        return instance;
    }

    public List<Theatre> getTheatresForMovie(Movie movie) {
        List<Theatre> result = new ArrayList<>();
        for (Theatre theatre : theatres) {
            if (theatre.getMovies().contains(movie.getTitle())) {
                result.add(theatre);
            }
        }
        return result;
    }
}
