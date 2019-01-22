package com.libraryapp.library.book;

import com.libraryapp.library.author.Author;
import com.libraryapp.library.bookdata.BookDataDto;
import com.libraryapp.library.user.User;

import java.util.List;

public class CreateBookDto {

    private Long bookDataId;
    //todo: dodac liste authorid i przerobic reszte
    public CreateBookDto(Long bookDataId) {
        this.bookDataId = bookDataId;
    }

    public CreateBookDto() {
    }

    public Long getBookDataId() {
        return bookDataId;
    }
}

