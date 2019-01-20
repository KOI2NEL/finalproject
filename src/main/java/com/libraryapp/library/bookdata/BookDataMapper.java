package com.libraryapp.library.bookdata;

import com.libraryapp.library.author.AuthorMapper;
import com.libraryapp.library.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDataMapper {

    private final AuthorMapper authorMapper;
    private final AuthorService authorService;

    @Autowired
    public BookDataMapper(AuthorMapper authorMapper, AuthorService authorService) {
        this.authorMapper = authorMapper;
        this.authorService = authorService;
    }


    public BookDataResponse map(BookData bookDataEntity) {
        BookDataResponse bookDataResponse = new BookDataResponse();
        bookDataResponse.setId(bookDataEntity.getId());
        bookDataResponse.setTitle(bookDataEntity.getTitle());

        bookDataEntity.getAuthors().forEach(author -> bookDataResponse.getAuthorResponse().add(authorMapper.map(author)));


        return bookDataResponse;
    }

    public BookData createNew(CreateBookDataDto bookDataDto) {
        BookData bookData = new BookData();
        bookDataDto.getAuthorId().forEach(id -> bookData.getAuthors().add(authorService.findById(id)));
        return bookData;
    }

}
