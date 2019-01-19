package com.libraryapp.library.borrow;

import com.libraryapp.library.book.Book;
import com.libraryapp.library.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "borrows")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private Long id;

    @ManyToMany(mappedBy = "borrows")
    private Set<User> user = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "borrows_books",
            joinColumns = {@JoinColumn(name = "borrow_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private Set<Book> books = new HashSet<>();

    private LocalDate borrowDate;

    private LocalDate returnDate;

    private Double fine;

    private boolean isActive;

    public Borrow() {
    }

    public Borrow(Set<User> user, Set<Book> books, LocalDate borrowDate, LocalDate returnDate, Double fine, boolean isActive) {
        this.user = user;
        this.books = books;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.fine = fine;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
