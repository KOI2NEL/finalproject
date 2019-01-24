package com.libraryapp.library.book;

import com.libraryapp.library.author.Author;
import com.libraryapp.library.bookdata.BookData;
import com.libraryapp.library.borrow.Borrow;
import com.libraryapp.library.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BookData bookData;

    @OneToMany(mappedBy = "book")
    private Set<Borrow> borrows = new HashSet<>();

    public Book() {
    }

    //TODO: POPRAWIC CONSTRUCTOR
    public Book(Long id, BookData bookData) {
        this.id = id;
        this.bookData = bookData;
//        this.borrows = borrows;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookData getBookData() {
        return bookData;
    }

    public void setBookData(BookData bookData) {
        this.bookData = bookData;
    }

    public Set<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(Set<Borrow> borrows) {
        this.borrows = borrows;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookData=" + bookData +
                ", borrows=" + borrows +
                '}';
    }
}
