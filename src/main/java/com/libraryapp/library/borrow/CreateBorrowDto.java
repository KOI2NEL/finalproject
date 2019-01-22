package com.libraryapp.library.borrow;

import com.libraryapp.library.book.BookResponse;
import com.libraryapp.library.book.CreateBookDto;

import java.time.LocalDate;

public class CreateBorrowDto {

    private Long userId;

    private Long bookId;

    private LocalDate borrowDate;

    private LocalDate requiredReturnDate;

    private LocalDate returnDate;

    private boolean isActive;

    public CreateBorrowDto(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public CreateBorrowDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
