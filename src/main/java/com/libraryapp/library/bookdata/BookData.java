package com.libraryapp.library.bookdata;


import com.libraryapp.library.author.Author;
import com.libraryapp.library.book.Book;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book_data")
public class BookData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//TODO: Dodać konstruktory, a jak
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

    public Long getId() {
        return id;
    }


}
