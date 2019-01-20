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
//
//
//    public Author createNew(CreateAuthorDto createAuthorDto) {
//        Author author = new Author();
//        author.setId(createAuthorDto.getId());
//        author.setName(createAuthorDto.getName());
//        author.setSurname(createAuthorDto.getSurname());
//        //TODO: Zwracać listę książek
//        return author;
//    }
//
//    public AuthorResponse map(Author author) {
//        AuthorResponse authorResponse = new AuthorResponse();
//        authorResponse.setId(author.getId());
//        authorResponse.setName(author.getName());
//        authorResponse.setSurname(author.getSurname());
//        //TODO: Zwracać listę książek
//            return authorResponse;
//        }
}
