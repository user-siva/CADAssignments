package com.com.zsgs.TaskMaster.datalayer;

import com.com.zsgs.TaskMaster.dto.User;

public class LoginModel {
    private static LoginModel repository;

    private LoginModel() {

    }

    public static LoginModel getInstance() {
        if (repository == null) {
            repository = new LoginModel();
        }
        return repository;
    }

    private User loggedInuser;

    public User validate(String userName, String email, String password) {
        if (userName.equals("Siva") && password.equals("admin")) {
            User user = new User("Siva", email, "admin");

            loggedInuser = user;
            return user;
        }
        return null;
    }

    public User loggedInuserDetail() {
        return loggedInuser;
    }
}
