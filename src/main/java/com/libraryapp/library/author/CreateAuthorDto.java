package com.libraryapp.library.author;

import com.libraryapp.library.bookdata.BookDataDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateAuthorDto {

    private String name;

    private String surname;

    public CreateAuthorDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public CreateAuthorDto() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
