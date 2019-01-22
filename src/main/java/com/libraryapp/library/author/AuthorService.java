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


    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::map)
                .collect(Collectors.toList());
    }

    public void addAuthor(CreateAuthorDto createAuthorDto) {
        authorRepository.save(authorMapper.createNew(createAuthorDto));
    }

    public Author findById(Long id) {
        Author author = null;
        try {
            author = authorRepository.findById(id);
            return author;
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Couldn't find Author with id: " + id);
            return null;
        }

    }

    public AuthorResponse findResponseById(Long id) {
        Author author = findById(id);
        return authorMapper.map(author);
    }

}
