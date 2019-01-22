package com.libraryapp.library.book;

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
        return bookRepository.findAll().stream().map(bookMapper::map).collect(Collectors.toList());
    }


    public void addBook(CreateBookDto createBookDto) {
        bookRepository.save(bookMapper.createNew(createBookDto));
    }

    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

    public BookResponse findResponseById (Long id){
        Book book = findById(id);
        return bookMapper.map(book);
    }


}
