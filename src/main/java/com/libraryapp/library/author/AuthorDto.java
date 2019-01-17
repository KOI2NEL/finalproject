package com.libraryapp.library.author;

import com.libraryapp.library.bookdata.BookDataDto;

import java.util.HashSet;
import java.util.Set;

public class AuthorDto {

    private Long id;

    private String name;

    private String surname;

    private Set<BookDataDto> bookDataDtos = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<BookDataDto> getBookDataDtos() {
        return bookDataDtos;
    }

}
