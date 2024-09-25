package com.zsgs.wisdomworld.screens.Login;

import java.util.Scanner;
import com.zsgs.wisdomworld.repository.*;
import com.zsgs.wisdomworld.BaseScreen;
import com.zsgs.wisdomworld.screens.availablebooks.BookList;
import com.zsgs.wisdomworld.screens.homepage.HomePage;
import com.zsgs.wisdomworld.dto.*;;

public class LoginView extends BaseScreen {
    private LoginViewModel viewModel;

    public LoginView() {
        viewModel = new LoginViewModel(this);
    }

    public void onCreate() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Wisdom World Library System");
        System.out.println("Please log in to continue");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User user = LoginModel.getInstance().validate(username, password);

        if (user != null) {
            System.out.println("Login successful. Welcome, " + user.getName() + "!");
            HomePage homePage = new HomePage(user);
            homePage.onCreate();
        } else {
            System.out.println("Invalid credentials. Please try again.");
            onCreate();
        }
    }

    public void navigateBookList(User user) {
        BookList booklist = new BookList(user);
        booklist.onCreate();
    }

    public void showErroMessage(String message) {
        System.out.println(message);
    }

}
