package com.libraryapp.library.bookdata;


import com.libraryapp.library.author.Author;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book_data")
public class BookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @OneToMany(cascade = {CascadeType.PERSIST})
    private Set<Author> authors = new HashSet<>();


    public Long getId() {
        return id;
    }

}
