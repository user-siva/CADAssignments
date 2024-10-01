package ShowTime.com.zsgs.showtime.screens.seatselection;

import ShowTime.com.zsgs.showtime.screens.movielist.*;
import ShowTime.com.zsgs.showtime.dto.Movie;
import ShowTime.com.zsgs.showtime.dto.Theatre;
import ShowTime.com.zsgs.showtime.dto.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeatSelectionView {

    private SeatSelectionViewModel seatSelectionViewModel;
    private Movie selectedMovie;
    private Theatre selectedTheatre;
    private String showTimeId;

    public SeatSelectionView(Movie selectedMovie, Theatre selectedTheatre) {
        this.selectedMovie = selectedMovie;
        this.selectedTheatre = selectedTheatre;
        this.showTimeId = generateShowTimeId(selectedMovie, selectedTheatre);
        this.seatSelectionViewModel = new SeatSelectionViewModel(this);
    }

    public void onCreate() {
        displayAvailableSeats();
    }

    private void displayAvailableSeats() {
        List<Seat> availableSeats = seatSelectionViewModel.getAvailableSeats(selectedTheatre.getId(), showTimeId);

        System.out.println("Available Seats for " + selectedMovie.getTitle() + " at " + selectedTheatre.getName());
        if (availableSeats.isEmpty()) {
            System.out.println("No seats available.");
            return;
        }

        for (Seat seat : availableSeats) {
            System.out.println(
                    "Seat Number: " + seat.getSeatNumber() + " - " + (seat.isAvailable() ? "Available" : "Reserved"));
        }

        handleSeatSelection();
    }

    private void handleSeatSelection() {
        Scanner sc = new Scanner(System.in);
        List<Integer> seatNumbers = new ArrayList<>();

        System.out.println("Enter the seat numbers to reserve (comma-separated) or 0 to cancel:");
        String input = sc.nextLine();

        if (input.equals("0")) {
            System.out.println("Seat selection cancelled.");
            return;
        }

        String[] numbers = input.split(" ");
        for (String number : numbers) {
            try {
                int seatNumber = Integer.parseInt(number.trim());
                if (seatNumber > 0) {
                    seatNumbers.add(seatNumber);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid seat number: " + number);
            }
        }

        boolean allReserved = true;
        for (int seatNumber : seatNumbers) {
            boolean reservationSuccess = seatSelectionViewModel.reserveSeat(selectedTheatre.getId(), showTimeId,
                    seatNumber);
            if (!reservationSuccess) {
                System.out
                        .println("Failed to reserve seat " + seatNumber + ". It might already be reserved or invalid.");
                allReserved = false;
            } else {
                System.out.println("Seat " + seatNumber + " has been successfully reserved!");
            }
        }

        if (allReserved) {
            System.out.println("All selected seats have been successfully reserved!");
        }

        goBackToMainMenu();
    }

    private void goBackToMainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to go back to the main menu? (yes/no): ");
        String choice = sc.next();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Returning to the main menu...");

            MovieListView movielist = new MovieListView();
            movielist.onCreate();
        } else {
            System.out.println("Exiting seat selection.");
        }
    }

    private String generateShowTimeId(Movie selectedMovie, Theatre selectedTheatre) {
        return selectedTheatre.getId();
    }
}
