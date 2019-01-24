package com.libraryapp.library.borrow;

import com.libraryapp.library.book.BookResponse;
import com.libraryapp.library.user.UserResponse;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class BorrowResponse {
    private Long id;

    private UserResponse userResponse;

    private BookResponse bookResponse;

    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate borrowDate;

    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate requiredReturnDate;

    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate returnDate;

    private Double fine;

    private boolean isActive;


    public BorrowResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }

    public BookResponse getBookResponse() {
        return bookResponse;
    }

    public void setBookResponse(BookResponse bookResponse) {
        this.bookResponse = bookResponse;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getRequiredReturnDate() {
        return requiredReturnDate;
    }

    public void setRequiredReturnDate(LocalDate requiredReturnDate) {
        this.requiredReturnDate = requiredReturnDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
