package com.libraryapp.library.author;

import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorResponse map(Author authorEntity) {
        return new AuthorResponse(authorEntity.getId(), authorEntity.getName(), authorEntity.getSurname());
    }

    public Author createNew(CreateAuthorDto AuthorDto) {
        Author author = new Author();
        author.setName(AuthorDto.getName());
        author.setSurname(AuthorDto.getSurname());

        return author;
    }

}
