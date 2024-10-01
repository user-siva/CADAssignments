package ShowTime.com.zsgs.showtime.datalayer;

import ShowTime.com.zsgs.showtime.dto.*;

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
    boolean isLoggedIn;

    public User validate(String userName, String password) {
        if (userName.equals("Siva") && password.equals("admin")) {
            User user = new User();
            user.setName(userName);
            user.setEmail("siva@zsgs.in");
            isLoggedIn = true;
            loggedInuser = user;
            return user;
        }
        return null;
    }

    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    public User loggedInuserDetail() {
        return loggedInuser;
    }

}
