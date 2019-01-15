package com.libraryapp.library.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    //co jest uzywane przez BookService
    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getALL() {
        return new ArrayList<>(bookRepository.findAll().stream().collect(Collectors.toList()));
    }

//    public List<BookResponse> findByTitle (String title){
////        return bookRepository.findByTitle(title);
//    }


}
