package com.libraryapp.library.author;

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
