package com.com.zsgs.TaskMaster.screens.login;

import java.util.Scanner;

import com.com.zsgs.TaskMaster.BaseScreen;
import com.com.zsgs.TaskMaster.TaskMaster;
import com.com.zsgs.TaskMaster.dto.User;
import com.com.zsgs.TaskMaster.screens.tasklist.TaskListScreen;

public class LoginView extends BaseScreen {
    private LoginController controller;

    public LoginView() {
        controller = new LoginController(this);
    }

    public void onCreate() {
        if (hasNetworkConnection()) {
            System.out.println("Welcome to theatre " + TaskMaster.getInstance().appName);

            System.out.println("\n\nPlease login to proceed.");
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter the user name:");
            String name = scanner.next();
            System.out.println("\nEnter the email:");
            String email = scanner.next();
            System.out.println("Enter the password:");
            String password = scanner.next();

            controller.validateUser(name, email, password);
        } else {
            showAlertMessage("Please check internet connection");
        }
    }

    public void navigateTaskList(User loggedInUser) {
        System.out.println("Welcome " + loggedInUser.getName());
        TaskListScreen taskListScreen = new TaskListScreen();
        taskListScreen.onCreate();
    }

}
