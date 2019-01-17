package com.libraryapp.library.bookdata;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookdatas")
public class BookDataController {

    private final BookDataService bookDataService;

    public BookDataController(BookDataService bookDataService) {
        this.bookDataService = bookDataService;
    }

    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public ResponseEntity<List<BookData>> listAllBookData() {
        List<BookData> bookDataList = bookDataService.findAll();
        if (bookDataList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<BookData>>(bookDataList, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<BookData> createBookData(@RequestBody BookData bookData) {
        bookDataService.saveBookData(bookData);
        return new ResponseEntity<>(bookData, HttpStatus.CREATED);
    }

}
