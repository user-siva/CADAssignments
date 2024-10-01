package ShowTime.com.zsgs.showtime;

import ShowTime.com.zsgs.showtime.screens.login.*;
import ShowTime.com.zsgs.showtime.screens.movielist.*;
import ShowTime.com.zsgs.showtime.datalayer.*;

public class ShowTime {

    private static ShowTime instance;

    private ShowTime() {

    }

    public String appName = "ShowTime Application";

    public String appVersion = "0.0.4";

    public int appVersionCode = 4;

    public static ShowTime getInstance() {
        if (instance == null) {
            instance = new ShowTime();
        }
        return instance;
    }

    public static void main(String arg[]) {
        ShowTime.getInstance().onCreate();
    }

    public void onCreate() {
        if (LoginModel.getInstance().isLoggedIn()) {
            MovieListView movieListScreen = new MovieListView();
            movieListScreen.onCreate();
        } else {
            LoginView loginScreen = new LoginView();
            loginScreen.onCreate();
        }
    }

    public boolean hasNetworkConnection() {
        return checkConnection();
    }

    private boolean checkConnection() {
        return true;
    }
}
