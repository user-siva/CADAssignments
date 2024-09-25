package com.com.zsgs.TaskMaster.screens.login;

import com.com.zsgs.TaskMaster.datalayer.LoginModel;
import com.com.zsgs.TaskMaster.dto.User;

public class LoginController {

    private LoginView view;

    public LoginController(LoginView screen) {
        view = screen;
    }

    public void validateUser(String userName, String email, String password) {
        User loggedInUser = LoginModel.getInstance().validate(userName, email, password);
        if (loggedInUser != null) {
            view.navigateTaskList(loggedInUser);
        } else {
            view.showAlertMessage("Invalid User name or Password");
        }
    }

}
