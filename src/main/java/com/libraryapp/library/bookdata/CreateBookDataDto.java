package com.libraryapp.library.bookdata;

import java.util.ArrayList;
import java.util.List;

public class CreateBookDataDto {
    private Long id;

    private String title;

    private List<Long> authorId = new ArrayList<>();

    private List<Long> bookId = new ArrayList<>();

    public CreateBookDataDto(Long id, String title, List<Long> authorId, List<Long> bookId) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.bookId = bookId;
    }

    public CreateBookDataDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Long> getAuthorId() {
        return authorId;
    }

    public void setAuthorId(List<Long> authorId) {
        this.authorId = authorId;
    }

    public List<Long> getBookId() {
        return bookId;
    }

    public void setBookId(List<Long> bookId) {
        this.bookId = bookId;
    }
}
