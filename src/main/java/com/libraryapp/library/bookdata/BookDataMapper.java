package com.libraryapp.library.bookdata;

import org.springframework.stereotype.Component;

@Component
public class BookDataMapper {

    public BookDataDto toDto(BookData bookData) {

        return new BookDataDto(bookData.getId(),bookData.getTitle());
    }


    public BookData toEntity(BookDataDto bookDataDto) {
        return new BookData();
    }
}
