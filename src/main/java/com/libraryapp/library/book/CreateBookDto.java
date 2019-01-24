package com.libraryapp.library.book;

public class CreateBookDto {

    private Long bookDataId;

    public CreateBookDto(Long bookDataId) {
        this.bookDataId = bookDataId;
    }

    public CreateBookDto() {
    }

    public Long getBookDataId() {
        return bookDataId;
    }
}

