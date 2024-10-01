package ShowTime.com.zsgs.showtime.screens.login;

import ShowTime.com.zsgs.showtime.datalayer.*;
import ShowTime.com.zsgs.showtime.dto.*;

class LoginViewModel {

	private LoginView view;

	public LoginViewModel(LoginView screen) {
		view = screen;
	}

	public void validateUser(String userName, String password) {
		User loggedInUser = LoginModel.getInstance().validate(userName, password);
		if (loggedInUser != null) {
			view.navigateMovieList(loggedInUser);
		} else {
			view.showAlertMessage("Invalid User name or Password");
		}
	}
}
