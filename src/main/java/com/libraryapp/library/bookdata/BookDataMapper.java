package com.libraryapp.library.bookdata;

import com.libraryapp.library.author.Author;
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

        try {
            bookDataEntity.getAuthors().forEach(author -> bookDataResponse.getAuthorResponse()
                    .add(authorMapper.map(author)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookDataResponse;
    }

    public BookData createNew(CreateBookDataDto createBookDataDto) {
        BookData bookData = new BookData();
        bookData.setTitle(createBookDataDto.getTitle());
        createBookDataDto.getAuthorId().forEach(id -> {
            Author author = authorService.findById(id);
            if (author != null) {
                bookData.getAuthors().add(author);
            }
        });
        return bookData;
    }

}
