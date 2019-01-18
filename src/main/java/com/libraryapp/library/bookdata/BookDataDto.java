package com.libraryapp.library.bookdata;

import com.libraryapp.library.author.AuthorDto;
import com.libraryapp.library.book.BookDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookDataDto {

    private Long id;

    private String title;

    private List<String> authorDtos = new ArrayList<>();

    private List<String> bookDtos = new ArrayList<>();

    public BookDataDto(Long id, String title) {
        this.id = id;
        this.title = title;
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
}
