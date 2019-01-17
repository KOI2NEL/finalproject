package com.libraryapp.library.author;

import com.libraryapp.library.bookdata.BookData;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToMany(mappedBy = "authors")
    private Set<BookData> bookDatas = new HashSet<>();

    public Author() {
    }

    public Author(Long id, String name, String surname, Set<BookData> bookDatas) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.bookDatas = bookDatas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<BookData> getBookDatas() {
        return bookDatas;
    }

    public void setBookDatas(Set<BookData> bookDatas) {
        this.bookDatas = bookDatas;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bookDatas=" + bookDatas +
                '}';
    }
}
