package com.libraryapp.library.book;

import com.libraryapp.library.bookdata.BookDataDto;
import com.libraryapp.library.borrow.BorrowDto;

import java.util.HashSet;
import java.util.Set;

public class BookDto {
    private Long id;

    private BookDataDto bookDataDto;

    private Set<BorrowDto> borrowDtos = new HashSet<>();

}
