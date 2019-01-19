package com.libraryapp.library.book;

import com.libraryapp.library.bookdata.BookDataResponse;

public class BookResponse {

    private Long bookId;
    private BookDataResponse bookDataResponse;

    public BookResponse(Long bookId, BookDataResponse bookDataResponse) {
        this.bookId = bookId;
        this.bookDataResponse = bookDataResponse;
    }

    public Long getBookId() {
        return bookId;
    }

    public BookDataResponse getBookDataResponse() {
        return bookDataResponse;
    }
}
