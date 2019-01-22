package com.libraryapp.library.user;

public class CreateUserDto {
    private String name;

    private String surname;

    private String login;

    private char[] password;

    public CreateUserDto(String name, String surname, String login, char[] password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public CreateUserDto() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public char[] getPassword() {
        return password;
    }
}
