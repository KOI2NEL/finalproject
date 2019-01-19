package com.libraryapp.library.bookdata;


import com.libraryapp.library.author.Author;
import com.libraryapp.library.book.Book;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bookdatas")
public class BookData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // TODO: Zawsze mogę dodać autora do ksiązki, ale nie mogę dodać książki do autora bo mam adnotacke z joinami po tej stronie
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "bookdatas_authors",
            joinColumns = {@JoinColumn(name = "bookdata_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "bookData")
    private Set<Book> books = new HashSet<>();

    public BookData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", books=" + books +
                '}';
    }
}
