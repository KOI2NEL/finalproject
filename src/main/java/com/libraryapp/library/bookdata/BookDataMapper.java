package com.libraryapp.library.bookdata;

import org.springframework.stereotype.Component;

@Component
public class BookDataMapper {

    public BookDataDto toDto(BookData bookData) {

        return new BookDataDto();
    }


}
