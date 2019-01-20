package com.libraryapp.library.borrow;

import com.libraryapp.library.book.BookResponse;
import com.libraryapp.library.user.UserResponse;

import java.time.LocalDate;

public class BorrowResponse {
    private Long id;

    private UserResponse userResponse;

    private BookResponse bookResponse;

    private LocalDate borrowDate;

    private LocalDate returnDate;

    private Double fine;

    private boolean isActive;

    public BorrowResponse(Long id, UserResponse userResponse, BookResponse bookResponse, LocalDate borrowDate, LocalDate returnDate, Double fine, boolean isActive) {
        this.id = id;
        this.userResponse = userResponse;
        this.bookResponse = bookResponse;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.fine = fine;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public BookResponse getBookResponse() {
        return bookResponse;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public Double getFine() {
        return fine;
    }

    public boolean isActive() {
        return isActive;
    }
}
