package com.libraryapp.library.borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public ResponseEntity<List<BorrowResponse>> getAll() {
        List<BorrowResponse> borrowResponses = borrowService.getAllBorrows();
        if (borrowResponses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(borrowResponses, HttpStatus.OK);
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public ResponseEntity<BorrowResponse> add(@RequestBody CreateBorrowDto createBorrowDto) {
        BorrowResponse borrowResponse = borrowService.addBorrow(createBorrowDto);

        if (borrowResponse != null) {
            return new ResponseEntity<>(borrowResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BorrowResponse getById(@PathVariable("id") Long id) {
        return borrowService.findResponseById(id);
    }

}
