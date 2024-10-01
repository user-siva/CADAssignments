package ShowTime.com.zsgs.showtime.screens.movielist;

import java.util.List;
import java.util.Scanner;
import ShowTime.com.zsgs.showtime.dto.*;
import ShowTime.com.zsgs.showtime.ShowTime;
import ShowTime.com.zsgs.showtime.screens.theatrelist.TheatreListView;

public class MovieListView {

    private MovieListViewModel viewModel;

    public MovieListView() {
        this.viewModel = new MovieListViewModel(this);
    }

    public void onCreate() {
        viewModel.displayAvailableMovies();
    }

    public void showAvailableMovies(List<Movie> availableMovies) {
        System.out.println("Available Movies:");
        if (availableMovies.isEmpty()) {
            System.out.println("No movies available at the moment.");
        } else {
            for (int i = 0; i < availableMovies.size(); i++) {
                Movie movie = availableMovies.get(i);
                System.out.println((i + 1) + ". " + movie.getTitle() + " (" + movie.getGenre() + ")");
            }
        }
        System.out.println("0. Back to Main Menu");

        Scanner sc = new Scanner(System.in);
        System.out.print("Choose a movie to view details (or 0 to go back): ");
        int choice = sc.nextInt();

        if (choice > 0 && choice <= availableMovies.size()) {
            Movie selectedMovie = availableMovies.get(choice - 1);
            TheatreListView theatreListView = new TheatreListView(selectedMovie);
            theatreListView.onCreate();
        } else if (choice == 0) {
            ShowTime.getInstance().onCreate();
        } else {
            System.out.println("Invalid choice. Please try again.");
            showAvailableMovies(availableMovies);
        }
    }

    private void showMovieDetails(Movie movie) {
        System.out.println("Movie Details:");
        System.out.println("Title: " + movie.getTitle());
        System.out.println("Genre: " + movie.getGenre());
        System.out.println("Duration: " + movie.getDuration() + " minutes");

        Scanner sc = new Scanner(System.in);
        System.out.print("Press any key to go back to the movie list...");
        sc.nextLine();
        onCreate();
    }
}
