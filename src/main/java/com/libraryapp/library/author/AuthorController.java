package com.libraryapp.library.author;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<AuthorDto> getAll() {
        return authorService.getAllAuthors();
    }

    @PostMapping
    public void addAuthor(@RequestBody AuthorDto authorDto) {
        authorService.addAuthor(authorDto);
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable("id") Long id) {
        return authorService.findById(id);
    }

}
