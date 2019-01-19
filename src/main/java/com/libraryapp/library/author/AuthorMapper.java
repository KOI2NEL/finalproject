package com.libraryapp.library.author;

import com.libraryapp.library.bookdata.BookData;
import com.libraryapp.library.bookdata.BookDataMapper;
import com.libraryapp.library.bookdata.BookDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    private final BookDataMapper bookDataMapper;
    private final BookDataService bookDataService;

    @Autowired
    public AuthorMapper(BookDataMapper bookDataMapper, BookDataService bookDataService) {
        this.bookDataMapper = bookDataMapper;
        this.bookDataService = bookDataService;
    }



    public Author createNew(CreateAuthorDto createAuthorDto) {
        Author author = new Author();
        author.setId(createAuthorDto.getId());
        author.setName(createAuthorDto.getName());
        author.setSurname(createAuthorDto.getSurname());
        //TODO: Zwracać listę książek
        return author;
    }

    public AuthorResponse map(Author author) {
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setId(author.getId());
        authorResponse.setName(author.getName());
        authorResponse.setSurname(author.getSurname());
        //TODO: Zwracać listę książek
            return authorResponse;
        }
    }
