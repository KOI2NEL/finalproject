package com.libraryapp.library.bookdata;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookdata")
public class BookDataController {

    private final BookDataService bookDataService;

    public BookDataController(BookDataService bookDataService) {
        this.bookDataService = bookDataService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<BookDataResponse>> listAllBookData() {
        List<BookDataResponse> bookDataResponses = bookDataService.getAllBookDatas();
        if (bookDataResponses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<BookDataResponse>>(bookDataResponses, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<BookDataResponse> createBookData(@RequestBody CreateBookDataDto createBookDataDto) {
        BookDataResponse bookDataResponse = bookDataService.addBookData(createBookDataDto);
        if (bookDataResponse != null) {
            return new ResponseEntity<>(bookDataResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BookDataResponse getById(@PathVariable("id") Long id) {
        return bookDataService.findResponseById(id);
    }


}
