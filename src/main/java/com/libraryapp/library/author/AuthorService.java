package com.libraryapp.library.author;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
//
//    public List<AuthorResponse> getAllAuthors() {
//        return authorRepository.findAll().stream().map(authorMapper::map).collect(Collectors.toList());
//    }
//
//    public void addAuthor(CreateAuthorDto createAuthorDto) {
//        authorRepository.save(authorMapper.createNew(createAuthorDto));
//    }
//
    public Author findById(Long id) {
        Author author = authorRepository.findById(id);
        return author;
    }
}
