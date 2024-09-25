package com.zsgs.wisdomworld.screens.borrowedbooks;

import com.zsgs.wisdomworld.BaseScreen;
import com.zsgs.wisdomworld.dto.Book;
import com.zsgs.wisdomworld.dto.User;
import com.zsgs.wisdomworld.repository.LoginModel;
import com.zsgs.wisdomworld.screens.homepage.HomePage;

import java.util.List;
import java.util.Scanner;

public class BorrowedBookList extends BaseScreen {

    public BorrowedBookList() {
    }

    public void onCreate() {
        showBorrowedBooks();
    }

    private void showBorrowedBooks() {
        LoginModel loginModel = LoginModel.getInstance();
        User user = loginModel.loggedInuserDetail();
        List<Book> borrowedBooks = user.getBorrowedBooks();

        System.out.println("Borrowed Books:");
        if (borrowedBooks.isEmpty()) {
            System.out.println("You have not borrowed any books.");
        } else {
            for (int i = 0; i < borrowedBooks.size(); i++) {
                Book book = borrowedBooks.get(i);
                System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor());
            }
        }
        System.out.println("0. Back to Main Menu");

        Scanner sc = new Scanner(System.in);
        System.out.print("Choose a book to return (or 0 to go back): ");
        int choice = sc.nextInt();

        if (choice > 0 && choice <= borrowedBooks.size()) {
            System.out.println("You returned \"" + borrowedBooks.get(choice - 1).getTitle() + "\".");
            user.returnBook(borrowedBooks.get(choice - 1));
        } else if (choice == 0) {
            HomePage homePage = new HomePage(user);
            homePage.onCreate();
        } else {
            System.out.println("Invalid choice. Please try again.");
            showBorrowedBooks();
        }
    }
}
