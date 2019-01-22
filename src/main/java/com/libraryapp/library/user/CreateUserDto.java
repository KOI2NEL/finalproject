package com.libraryapp.library.user;

public class CreateUserDto {
    private String name;

    private String surname;

    private String login;

    private String password;

    public CreateUserDto(String name, String surname, String login, String password) {
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

    public String getPassword() {
        return password;
    }
}
