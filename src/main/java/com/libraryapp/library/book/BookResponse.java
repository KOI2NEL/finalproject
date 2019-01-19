package com.libraryapp.library.book;

public class BookResponse {

    private Long bookId;
    private String title;

    public BookResponse(Long bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }
}
