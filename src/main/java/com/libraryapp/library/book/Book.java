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
public class  Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BookData bookData;

    @OneToMany(mappedBy = "book")
    private Set<Borrow> borrows = new HashSet<>();
}
