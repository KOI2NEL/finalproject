package com.libraryapp.library.author;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll().stream().map(authorMapper::toDto).collect(Collectors.toList());
    }

    public void addAuthor(AuthorDto authorDto) {
        authorRepository.save(authorMapper.toEntity(authorDto));
    }

    public Author findById(Long id) {
        Author author = authorRepository.findOne(id);
        return author;
    }
}
