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
        if(authorResponses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<AuthorResponse>>(authorResponses, HttpStatus.OK);
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public void add(@RequestBody CreateAuthorDto createAuthorDto) {
        authorService.addAuthor(createAuthorDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Author getById(@PathVariable("id") Long id) {
        return authorService.findById(id);
    }

}
