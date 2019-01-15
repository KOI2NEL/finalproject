package com.libraryapp.library.book.web;

import com.libraryapp.library.author.Author;
import com.libraryapp.library.borrower.Borrower;

public class CreateBookDto {

    private Long bookId;
    private String title;
    private Borrower borrower;
    private Author author;

    public CreateBookDto(Long bookId, String title, Borrower borrower, Author author) {
        this.bookId = bookId;
        this.title = title;
        this.borrower = borrower;
        this.author = author;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

