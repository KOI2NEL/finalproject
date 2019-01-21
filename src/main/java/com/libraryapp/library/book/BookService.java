package com.libraryapp.library.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getALL() {
        return bookRepository.findAll().stream().collect(Collectors.toList());
    }

//    public Optional<Book> getById(Long id) {
//        return bookRepository.findById(id);
//    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

//    public void deleteBook (Long id) {
//        Optional<Book> bookToDelete = bookRepository.findById(id);
//        bookRepository.delete(bookToDelete);
//    }
//    public List<BookResponse> findByTitle (String title){
////        return bookRepository.findByTitle(title);
//    }


}
