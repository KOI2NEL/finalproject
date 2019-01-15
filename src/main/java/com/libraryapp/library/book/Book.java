package com.libraryapp.library.book;

import com.libraryapp.library.author.Author;
import com.libraryapp.library.borrower.Borrower;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class  Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors ;


    @ManyToMany
    @JoinTable(
            name = "books_borrowers",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "borrower_id")}
    )
    private Set<Borrower> borrowers = new HashSet<>();


    public Book(Long bookId, String title, Set<Author> authors, Set<Borrower> borrowers) {
        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
        this.borrowers = borrowers;
    }

    public Book() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(Set<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", borrowers=" + borrowers +
                '}';
    }
}
