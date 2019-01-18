package com.libraryapp.library.user;

import java.util.Set;

public class UserDto {
    private String name;

    private String surname;

    private String login;

    private char[] password;

    private Set<Long> borrowsId;

    public UserDto() {
    }

    public UserDto(String name, String surname, String login, char[] password, Set<Long> borrowsId) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.borrowsId = borrowsId;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public Set<Long> getBorrowsId() {
        return borrowsId;
    }

    public void setBorrowsId(Set<Long> borrowsId) {
        this.borrowsId = borrowsId;
    }
}
