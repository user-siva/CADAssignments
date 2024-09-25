package com.zsgs.wisdomworld.screens.availablebooks;

import com.zsgs.wisdomworld.repository.BookRepository;
import com.zsgs.wisdomworld.repository.LoginModel;
import com.zsgs.wisdomworld.BaseScreen;
import com.zsgs.wisdomworld.dto.Book;
import com.zsgs.wisdomworld.screens.homepage.HomePage;
import com.zsgs.wisdomworld.dto.User;

import java.util.List;
import java.util.Scanner;

public class BookList extends BaseScreen {
    private BookListViewModel viewModel;

    public BookList(User user) {
        this.viewModel = new BookListViewModel(this);
    }

    public void onCreate() {
        viewModel.displayAvailableBooks();
    }

    public void showAvailableBooks(List<Book> availableBooks) {
        System.out.println("Available Books:");
        for (int i = 0; i < availableBooks.size(); i++) {
            Book book = availableBooks.get(i);
            List<Book> unavailable = BookRepository.getInstance().getUnAvailbleBooks();
            boolean flag = true;
            for (int j = 0; j < unavailable.size(); j++) {
                if (book.equals(unavailable.get(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor());
        }
        System.out.println("0. Back to Main Menu");

        Scanner sc = new Scanner(System.in);
        System.out.print("Choose a book to borrow: ");
        int choice = sc.nextInt();
        LoginModel loginModel = LoginModel.getInstance();
        if (choice > 0 && choice <= availableBooks.size()) {
            Book b = availableBooks.get(choice - 1);
            loginModel.loggedInuserDetail().borrowBook(b);
            BookRepository.getInstance().addToUnAvailableBooks(b);
            System.out.println("Book borrowed successfully!");
        } else if (choice == 0) {
            HomePage mainMenu = new HomePage(loginModel.loggedInuserDetail());
            mainMenu.onCreate();
        } else {
            System.out.println("Invalid choice. Please try again.");
            showAvailableBooks(availableBooks);
        }
    }
}
