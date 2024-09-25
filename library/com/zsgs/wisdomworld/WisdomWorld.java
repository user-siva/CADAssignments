package com.zsgs.wisdomworld;

import com.zsgs.wisdomworld.screens.Login.LoginView;
import com.zsgs.wisdomworld.screens.homepage.*;
import com.zsgs.wisdomworld.repository.BookRepository;
import com.zsgs.wisdomworld.repository.LoginModel;
import com.zsgs.wisdomworld.dto.User;

public class WisdomWorld {
    private static WisdomWorld wisdomWorld;

    public String appName = "Wisdom World Application";
    public String appVersion = "0.0.4";
    public int appVersionCode = 4;

    public static WisdomWorld getInstance() {
        if (wisdomWorld == null) {
            wisdomWorld = new WisdomWorld();
        }
        return wisdomWorld;
    }

    public static void main(String[] args) {
        WisdomWorld instance = WisdomWorld.getInstance();
        instance.onCreate();
    }

    public void onCreate() {
        if (BookRepository.getInstance().isLoggedIn()) {
            User user = LoginModel.getInstance().loggedInuserDetail();
            HomePage homePage = new HomePage(user);
            homePage.onCreate();
        } else {
            LoginView loginScreen = new LoginView();
            loginScreen.onCreate();
        }
    }
}
