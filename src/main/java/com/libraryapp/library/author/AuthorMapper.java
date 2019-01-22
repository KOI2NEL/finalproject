package com.libraryapp.library.author;

import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorResponse map(Author authorEntity) {
        try {
            return new AuthorResponse(authorEntity.getId(), authorEntity.getName(), authorEntity.getSurname());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Author createNew(CreateAuthorDto AuthorDto) {
        Author author = new Author();
        author.setName(AuthorDto.getName());
        author.setSurname(AuthorDto.getSurname());

        return author;
    }

}
