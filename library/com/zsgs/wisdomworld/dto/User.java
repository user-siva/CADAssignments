package com.zsgs.wisdomworld.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String password;
    private List<Book> borrowedBooks = new ArrayList<>();

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}
