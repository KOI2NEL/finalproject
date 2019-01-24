package com.libraryapp.library.bookdata;

import java.util.List;

public class CreateBookDataDto {

    private String title;

    private List<Long> authorId;

    public CreateBookDataDto(String title, List<Long> authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    public CreateBookDataDto() {
    }

    public String getTitle() {
        return title;
    }

    public List<Long> getAuthorId() {
        return authorId;
    }
}
