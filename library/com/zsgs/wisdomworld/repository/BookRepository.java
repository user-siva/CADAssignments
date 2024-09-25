package com.zsgs.wisdomworld.repository;

import com.zsgs.wisdomworld.dto.Book;
import java.util.*;

public class BookRepository {

    private static BookRepository repository;
    private static List<Book> unavailableBooks = new ArrayList<>();

    private BookRepository() {
    }

    public static BookRepository getInstance() {

        if (repository == null) {
            repository = new BookRepository();
        }

        return repository;
    }

    public List<Book> getAvailableBooks() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        Book book2 = new Book("Pride and Prejudice", "Jane Austen", "978-1503290563");
        Book book3 = new Book("1984", "George Orwell", "978-0451524935");
        return Arrays.asList(book1, book2, book3);
    }

    public void addToUnAvailableBooks(Book b) {
        unavailableBooks.add(b);
    }

    public List<Book> getUnAvailbleBooks() {
        return unavailableBooks;
    }

    public boolean isLoggedIn() {
        return false;
    }
}
