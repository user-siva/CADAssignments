package com.zsgs.wisdomworld.screens.homepage;

import com.zsgs.wisdomworld.dto.User;
import com.zsgs.wisdomworld.screens.availablebooks.BookList;
import com.zsgs.wisdomworld.screens.borrowedbooks.BorrowedBookList;

import java.util.Scanner;

public class HomePage {
    private User user;

    public HomePage(User user) {
        this.user = user;
    }

    public void onCreate() {
        showMenu();
    }

    private void showMenu() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nMain Menu:");
            System.out.println("1. Available Books");
            System.out.println("2. Borrowed Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    BookList bookList = new BookList(user);
                    bookList.onCreate();
                    break;
                case 2:
                    BorrowedBookList borrowedBookList = new BorrowedBookList();
                    borrowedBookList.onCreate();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
