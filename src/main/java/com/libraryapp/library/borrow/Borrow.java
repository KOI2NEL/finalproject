package com.libraryapp.library.borrow;

import com.libraryapp.library.book.Book;
import com.libraryapp.library.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Currency;

@Entity
@Table(name = "borrows")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private Long id;

    @ManyToOne
    private User uzytkownik;

    @ManyToOne
    private Book book;

    private LocalDate borrowDate;

    private LocalDate returnDate;

    private Currency fine = Currency.getInstance("PLN");

    private boolean isActive;

}
