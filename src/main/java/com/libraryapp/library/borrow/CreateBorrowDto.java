package com.libraryapp.library.borrow;

import com.libraryapp.library.book.BookResponse;
import com.libraryapp.library.book.CreateBookDto;

import java.time.LocalDate;

public class CreateBorrowDto {

    private Long userId;

    private Long bookId;

    private LocalDate borrowDate = LocalDate.now();

    private LocalDate returnDate = borrowDate.plusDays(7);

    private Double fine = 0.0;

    private boolean isActive = true;

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
}
