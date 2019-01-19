package com.libraryapp.library.user;

import com.libraryapp.library.borrow.BorrowResponse;

import java.util.List;

public class UserResponse {
    private Long id;

    private String name;

    private String surname;

    List<BorrowResponse> borrowResponses;

    public UserResponse(Long id, String name, String surname, List<BorrowResponse> borrowResponses) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.borrowResponses = borrowResponses;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<BorrowResponse> getBorrowResponses() {
        return borrowResponses;
    }
}
