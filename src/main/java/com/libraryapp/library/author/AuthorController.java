package com.libraryapp.library.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public ResponseEntity<List<AuthorResponse>> getAll() {
        List<AuthorResponse> authorResponses = authorService.getAllAuthors();
        if (authorResponses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(authorResponses, HttpStatus.OK);
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public ResponseEntity<AuthorResponse> add(@RequestBody CreateAuthorDto createAuthorDto) {
        AuthorResponse authorResponse = authorService.addAuthor(createAuthorDto);

        if (authorResponse != null) {
            return new ResponseEntity<>(authorResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AuthorResponse getById(@PathVariable("id") Long id) {
        return authorService.findResponseById(id);
    }

}
