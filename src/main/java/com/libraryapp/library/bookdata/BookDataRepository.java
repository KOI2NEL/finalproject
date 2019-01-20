package com.libraryapp.library.bookdata;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDataRepository extends JpaRepository<BookData, Long> {
    CreateBookDataDto save(CreateBookDataDto createBookDataDto);

    BookData findById(Long id);

}
