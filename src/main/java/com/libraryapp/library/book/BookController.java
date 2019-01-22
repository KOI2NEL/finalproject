package com.libraryapp.library.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public ResponseEntity<List<BookResponse>> getAll() {
        List<BookResponse> bookResponses = bookService.getAllBooks();
        if(bookResponses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<BookResponse>>(bookResponses, HttpStatus.OK);
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public HttpStatus add(@RequestBody CreateBookDto createBookDto) {
        bookService.addBook(createBookDto);
        return HttpStatus.CREATED;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookResponse getById(@PathVariable("id") Long id) {
        return bookService.findResponseById(id);
    }


}
