package com.libraryapp;

import com.libraryapp.library.author.Author;
import com.libraryapp.library.author.AuthorRepository;
import com.libraryapp.library.author.AuthorService;
import com.libraryapp.library.book.Book;
import com.libraryapp.library.book.BookRepository;
import com.libraryapp.library.book.BookService;
import com.libraryapp.library.bookdata.BookData;
import com.libraryapp.library.bookdata.BookDataRepository;
import com.libraryapp.library.bookdata.BookDataService;
import com.libraryapp.library.borrow.Borrow;
import com.libraryapp.library.borrow.BorrowRepository;
import com.libraryapp.library.borrow.BorrowService;
import com.libraryapp.library.user.User;
import com.libraryapp.library.user.UserRepository;
import com.libraryapp.library.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

    private final BookService bookService;
    private final BookDataService bookDataService;
    private final BorrowService borrowService;
    private final AuthorService authorService;
    private final UserService userService;
    private final AuthorRepository authorRepository;
    private final BookDataRepository bookDataRepository;
    private final UserRepository userRepository;
    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LibraryApplication(BookService bookService, BookDataService bookDataService, BorrowService borrowService, AuthorService authorService, UserService userService, AuthorRepository authorRepository, BookDataRepository bookDataRepository, UserRepository userRepository, BorrowRepository borrowRepository, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookDataService = bookDataService;
        this.borrowService = borrowService;
        this.authorService = authorService;
        this.userService = userService;
        this.authorRepository = authorRepository;
        this.bookDataRepository = bookDataRepository;
        this.userRepository = userRepository;
        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
//        Author author = new Author();
//
//        Set<Author> authors = new HashSet<>();
//        authors.add(author);
//        authorRepository.save(author);
//        BookData bookData = new BookData("sadf", authors);
////        bookDataRepository.save(bookData);
////        Book book = new Book(100L, bookData);
////        bookRepository.save(book);
////        User user = new User();
////        userRepository.save(user);
//////        Borrow borrow = new Borrow(user, book, LocalDate.now(), LocalDate.now(),0.0, true);
//////        borrowRepository.save(borrow);
//        Borrow borrow = new Borrow();
//        borrow.setUser(userService.findById(1L));
//        borrow.setBook(bookService.findById(1L));
//        borrowRepository.save(borrow);
    }
}

