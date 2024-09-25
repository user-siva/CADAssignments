package com.zsgs.wisdomworld.repository;

import com.zsgs.wisdomworld.dto.*;

public class LoginModel {
    private static LoginModel repository;
    private User loggedInuser;

    private LoginModel() {

    }

    public static LoginModel getInstance() {
        if (repository == null) {
            repository = new LoginModel();
        }
        return repository;
    }

    public User validate(String userName, String password) {
        if (userName.equals("Siva") && password.equals("admin")) {
            User user = new User();
            user.setName(userName);
            user.setPassword(password);

            loggedInuser = user;
            return user;
        }
        return null;
    }

    public User loggedInuserDetail() {
        return loggedInuser;
    }

}
