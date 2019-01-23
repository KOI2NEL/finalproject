package com.libraryapp.library.book;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::map)
                .collect(Collectors.toList());
    }


    public BookResponse addBook(CreateBookDto createBookDto) {
        Book book = bookMapper.createNew(createBookDto);

        try {
            return bookMapper.map(bookRepository.save(book));
        } catch (Exception e) {
            System.out.println("Was not possible to save book to database");
            e.printStackTrace();
            return null;
        }
    }

    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

    public BookResponse findResponseById (Long id){
        Book book = findById(id);
        return bookMapper.map(book);
    }


}
