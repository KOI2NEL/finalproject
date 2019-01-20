package com.libraryapp.library.book;

import com.libraryapp.library.bookdata.BookDataMapper;
import com.libraryapp.library.bookdata.BookDataService;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    private final BookController bookController;
    private final BookDataService bookDataService;
    private final BookDataMapper bookDataMapper;

    public BookMapper(BookController bookController, BookDataService bookDataService, BookDataMapper bookDataMapper) {
        this.bookController = bookController;
        this.bookDataService = bookDataService;
        this.bookDataMapper = bookDataMapper;
    }

    public BookResponse map(Book bookEntity) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setBookId(bookEntity.getId());

        //TODO: Przypisać bookData do Book
        return null;
    }

    public Book createNew(CreateBookDto bookDto) {
        Book book = new Book();
        book.setBookData(bookDataService.findById(bookDto.getBookDataId()));
        return book;
    }

}
