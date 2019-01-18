package com.libraryapp.library.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//TODO: tu trzymam metody CRUDish (find....)

    Optional<Book> findById(Long id);

//    void delete(Optional<Book> bookToDelete);

}
