package com.libraryapp.library.bookdata;

import com.libraryapp.library.author.Author;

import java.util.ArrayList;
import java.util.List;

public class CreateBookDataDto {

    private String title;

    private List<Long> authorId;

    public CreateBookDataDto(String title, List<Long> authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public List<Long> getAuthorId() {
        return authorId;
    }
}
