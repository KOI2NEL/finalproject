package com.libraryapp.library.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
//TODO; analiza co jest w repozytorium, a co trzeba napisać jako request

    List<Book> findByTitle(String title);

}
