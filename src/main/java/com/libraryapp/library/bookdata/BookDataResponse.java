package com.libraryapp.library.bookdata;

import com.libraryapp.library.author.AuthorResponse;

import java.util.Set;

public class BookDataResponse {
    private Long id;

    private String title;

    private Set<AuthorResponse> authorResponse;

    public BookDataResponse(Long id, String title, Set<AuthorResponse> authorResponse) {
        this.id = id;
        this.title = title;
        this.authorResponse = authorResponse;
    }

    public BookDataResponse() {
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

    public Set<AuthorResponse> getAuthorResponse() {
        return authorResponse;
    }

    public void setAuthorResponse(Set<AuthorResponse> authorResponse) {
        this.authorResponse = authorResponse;
    }
}
