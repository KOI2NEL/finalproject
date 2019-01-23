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

    public AuthorResponse addAuthor(CreateAuthorDto createAuthorDto) {
        Author author = authorMapper.createNew(createAuthorDto);

        try {
            return authorMapper.map(authorRepository.save(author));
        } catch (Exception e) {
            System.out.println("Was not possible to save author to database");
            e.printStackTrace();
            return null;
        }
    }

    public Author findById(Long id) {

        try {
            return authorRepository.findById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Couldn't find Author with id: " + id);
            e.printStackTrace();
            return null;
        }

    }

    public AuthorResponse findResponseById(Long id) {
        Author author = findById(id);
        return authorMapper.map(author);
    }

}
