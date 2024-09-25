package com.zsgs.wisdomworld.screens.availablebooks;

import com.zsgs.wisdomworld.repository.BookRepository;

public class BookListViewModel {
    private BookList view;

    public BookListViewModel(BookList view) {
        this.view = view;
    }

    public void displayAvailableBooks() {
        view.showAvailableBooks(BookRepository.getInstance().getAvailableBooks());
    }
}
