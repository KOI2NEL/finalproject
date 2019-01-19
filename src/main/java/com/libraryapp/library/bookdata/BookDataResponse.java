package com.libraryapp.library.bookdata;

import com.libraryapp.library.borrow.BorrowResponse;
import sun.security.util.AuthResources;

public class BookDataResponse {
    private Long id;

    private String title;

    private AuthResources authResources;

    public BookDataResponse(Long id, String title, AuthResources authResources) {
        this.id = id;
        this.title = title;
        this.authResources = authResources;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public AuthResources getAuthResources() {
        return authResources;
    }
}
