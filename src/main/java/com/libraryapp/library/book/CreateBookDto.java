package com.libraryapp.library.book;

import com.libraryapp.library.author.Author;
import com.libraryapp.library.user.User;

public class CreateBookDto {

    private Long bookId;
    private String title;
    private User user;
    private Author author;

    public CreateBookDto(Long bookId, String title, User user, Author author) {
        this.bookId = bookId;
        this.title = title;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

