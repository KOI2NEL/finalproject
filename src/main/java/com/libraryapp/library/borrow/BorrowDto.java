package com.libraryapp.library.borrow;

import com.libraryapp.library.book.Book;
import com.libraryapp.library.user.User;

import java.time.LocalDate;

public class BorrowDto {

    private Long id;

    private User user;

    private Book book;

    private LocalDate borrowDate;

    private LocalDate returnDate;

    private Double fine;

    private boolean isActive;
}
