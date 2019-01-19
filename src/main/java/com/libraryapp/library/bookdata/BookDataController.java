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
        List<BookData> bookDatas = bookDataService.findAll();
        if (bookDatas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<BookData>>(bookDatas, HttpStatus.OK);
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public ResponseEntity<CreateBookDataDto> createBookData(@RequestBody CreateBookDataDto createBookDataDto) {
        bookDataService.saveBookData(createBookDataDto);
        return new ResponseEntity<>(createBookDataDto, HttpStatus.CREATED);
    }

}
