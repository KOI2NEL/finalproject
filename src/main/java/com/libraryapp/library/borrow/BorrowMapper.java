package com.libraryapp.library.borrow;

import org.springframework.stereotype.Component;

@Component
public class BorrowMapper {

    public BorrowResponse map(Borrow borrowEntity) {
//        return new BorrowResponse(borrowEntity.getId(),borrowEntity.getUser(),borrowEntity.getBooks(),borrowEntity.getBorrowDate(),borrowEntity.getReturnDate(),borrowEntity.getFine(),borrowEntity.isActive());
        return null;
    }

    public Borrow createNew(CreateBorrowDto borrowDto) {
        Borrow borrow = new Borrow();
//        borrow.setBooks(borrowDto.getBookId());
//        borrow.setUser(borrowDto.getUserId());
//
        return borrow;
    }
}
