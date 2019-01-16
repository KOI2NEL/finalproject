package com.libraryapp.library.user;

import com.libraryapp.library.borrow.Borrow;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private char[] password;

    @OneToMany(mappedBy = "uzytkownik")
    private Set<Borrow> borrows = new HashSet<>();


//    @ManyToMany(mappedBy = "users")
//    private Set<Book> books = new HashSet<>();

}
