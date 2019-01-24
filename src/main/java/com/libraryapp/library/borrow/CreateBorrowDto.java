package com.libraryapp.library.borrow;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CreateBorrowDto {

    private Long userId;

    private Long bookId;

    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate borrowDate;

    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate requiredReturnDate;

    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate returnDate;

    private boolean isActive = true;

    public CreateBorrowDto(Long userId, Long bookId, LocalDate borrowDate, LocalDate requiredReturnDate, LocalDate returnDate, boolean isActive) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.requiredReturnDate = requiredReturnDate;
        this.returnDate = returnDate;
        this.isActive = isActive;
    }

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
