package ShowTime.com.zsgs.showtime.screens.theatrelist;

import ShowTime.com.zsgs.showtime.dto.Movie;
import ShowTime.com.zsgs.showtime.dto.Theatre;
import ShowTime.com.zsgs.showtime.datalayer.TheatreRepository;
import ShowTime.com.zsgs.showtime.screens.theatrelist.TheatreListView;

import java.util.List;

public class TheatreListViewModel {
    private TheatreListView view;
    private Movie movie;

    public TheatreListViewModel(TheatreListView view, Movie movie) {
        this.view = view;
        this.movie = movie;
    }

    public void loadAvailableTheatres() {
        List<Theatre> availableTheatres = TheatreRepository.getInstance().getTheatresForMovie(movie);

        view.showAvailableTheatres(availableTheatres);
    }
}
