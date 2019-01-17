package com.libraryapp;

import com.libraryapp.library.author.AuthorService;
import com.libraryapp.library.book.BookService;
import com.libraryapp.library.bookdata.BookDataService;
import com.libraryapp.library.borrow.BorrowService;
import com.libraryapp.library.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

//	private final BookService bookService;
//	private final BookDataService bookDataService;
//	private final BorrowService borrowService;
//	private final AuthorService authorService;
//	private final UserService userService;
//
//	@Autowired
//	public LibraryApplication(BookService bookService, BookDataService bookDataService, BorrowService borrowService, AuthorService authorService, UserService userService) {
//		this.bookService = bookService;
//		this.bookDataService = bookDataService;
//		this.borrowService = borrowService;
//		this.authorService = authorService;
//		this.userService = userService;
//	}


    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);

    }


}

