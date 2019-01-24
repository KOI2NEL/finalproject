package com.libraryapp.library.borrow;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    Borrow findById(Long id);

    List<Borrow> findAllByRequiredReturnDateBefore(LocalDate localDate);
}
