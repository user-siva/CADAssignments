package ShowTime.com.zsgs.showtime.screens.theatrelist;

import ShowTime.com.zsgs.showtime.dto.Theatre;
import ShowTime.com.zsgs.showtime.dto.Movie;
import ShowTime.com.zsgs.showtime.screens.theatrelist.TheatreListViewModel;
import ShowTime.com.zsgs.showtime.screens.movielist.MovieListView;
import ShowTime.com.zsgs.showtime.screens.seatselection.SeatSelectionView;
import java.util.List;
import java.util.Scanner;

public class TheatreListView {
    private TheatreListViewModel viewModel;
    private Movie movie;

    public TheatreListView(Movie movie) {
        this.viewModel = new TheatreListViewModel(this, movie);
        this.movie = movie;
    }

    public void onCreate() {
        viewModel.loadAvailableTheatres();
    }

    public void showAvailableTheatres(List<Theatre> theatreList) {
        System.out.println("Available Theatres:");
        if (theatreList.isEmpty()) {
            System.out.println("No theatres available for this movie.");
            return;
        }

        for (int i = 0; i < theatreList.size(); i++) {
            Theatre theatre = theatreList.get(i);
            System.out.println((i + 1) + ". " + theatre.getName() + " - Location: " + theatre.getLocation());
        }

        System.out.println("0. Back to Movie List");
        handleUserSelection(theatreList);
    }

    private void handleUserSelection(List<Theatre> theatreList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose a theatre to proceed (or 0 to go back): ");
        int choice = sc.nextInt();

        if (choice > 0 && choice <= theatreList.size()) {
            Theatre selectedTheatre = theatreList.get(choice - 1);
            System.out.println("You selected: " + selectedTheatre.getName());
            SeatSelectionView seatSelection = new SeatSelectionView(movie, selectedTheatre);
            seatSelection.onCreate();
        } else if (choice == 0) {
            MovieListView movieListScreen = new MovieListView();
            movieListScreen.onCreate();
        } else {
            System.out.println("Invalid choice, please try again.");
            handleUserSelection(theatreList);
        }
    }
}
