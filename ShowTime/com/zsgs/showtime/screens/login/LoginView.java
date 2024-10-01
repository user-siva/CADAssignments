package ShowTime.com.zsgs.showtime.screens.login;

import ShowTime.com.zsgs.showtime.screens.movielist.*;
import ShowTime.com.zsgs.showtime.screens.login.*;
import ShowTime.com.zsgs.showtime.ShowTime;
import ShowTime.com.zsgs.showtime.BaseScreen;
import ShowTime.com.zsgs.showtime.dto.*;
import java.util.Scanner;

public class LoginView extends BaseScreen {
    private LoginViewModel controller;

    public LoginView() {
        controller = new LoginViewModel(this);
    }

    public void onCreate() {
        if (ShowTime.getInstance().hasNetworkConnection()) {
            System.out.println("Welcome to theatre " + ShowTime.getInstance().appName);

            System.out.println("\n\nPlease login to proceed.");
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter the user name:");
            String userName = scanner.next();
            System.out.println("Enter the password:");
            String password = scanner.next();

            controller.validateUser(userName, password);
        } else {
            showAlertMessage("Please check internet connection");
        }
    }

    public void navigateMovieList(User loggedInUser) {
        System.out.println("Welcome " + loggedInUser.getName());
        MovieListView movieListScreen = new MovieListView();
        movieListScreen.onCreate();
    }
}
