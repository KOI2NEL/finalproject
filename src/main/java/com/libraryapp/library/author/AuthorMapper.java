package com.libraryapp.library.author;

import com.libraryapp.library.bookdata.BookDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    private final BookDataMapper bookDataMapper;

    @Autowired
    public AuthorMapper(BookDataMapper bookDataMapper) {
        this.bookDataMapper = bookDataMapper;
    }

    public AuthorDto toDto(Author author) {
        AuthorDto authorDto = new AuthorDto();

        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setSurname(author.getSurname());

        author.getBookDatas()
                .forEach(bookData -> authorDto
                        .getBookDataDtos().add(bookDataMapper.toDto(bookData)));

        return authorDto;
    }

}
