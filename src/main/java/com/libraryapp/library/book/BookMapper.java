package com.libraryapp.library.book;

import com.libraryapp.library.bookdata.BookData;
import com.libraryapp.library.bookdata.BookDataMapper;
import com.libraryapp.library.bookdata.BookDataService;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {


    private final BookDataService bookDataService;
    private final BookDataMapper bookDataMapper;

    public BookMapper(BookDataService bookDataService, BookDataMapper bookDataMapper) {
        this.bookDataService = bookDataService;
        this.bookDataMapper = bookDataMapper;
    }

    public BookResponse map(Book bookEntity) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setBookId(bookEntity.getId());
        bookResponse.setBookDataResponse(bookDataMapper.map(bookEntity.getBookData()));
        return bookResponse;
    }

    public Book createNew(CreateBookDto bookDto) {
        Book book = new Book();

        BookData bookData = bookDataService.findById(bookDto.getBookDataId());

        if (bookData != null) {
            book.setBookData(bookData);
            return book;
        } else {
            System.out.println("Was not possible to get book data from db with id: " + bookDto.getBookDataId());
            return null;
        }
    }

}
