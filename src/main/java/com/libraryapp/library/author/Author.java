package com.libraryapp.library.author;

import com.libraryapp.library.book.Book;
import com.libraryapp.library.bookdata.BookData;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author_name")
    private String name;

    @Column(name = "author_surname")
    private String authorSurname;

    @ManyToMany(mappedBy = "authors")
    private Set<BookData> bookDatas = new HashSet<>();

}
