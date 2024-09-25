package com.zsgs.wisdomworld.screens.Login;

import com.zsgs.wisdomworld.repository.BookRepository;
import com.zsgs.wisdomworld.dto.User;
import com.zsgs.wisdomworld.repository.LoginModel;

public class LoginViewModel {
    private LoginView view;

    public LoginViewModel(LoginView screen) {
        view = screen;
    }

    private String userName = "ZSGS";

    private String userPassword = "admin";

    public void validateUser(String userName, String password) {
        User loggedInUser = LoginModel.getInstance().validate(userName, password);
        if (loggedInUser != null) {
            view.navigateBookList(loggedInUser);
        } else {
            view.showErroMessage("Invalid User name or Password");
        }
    }
}
