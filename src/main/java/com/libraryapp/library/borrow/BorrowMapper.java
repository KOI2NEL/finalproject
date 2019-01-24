package com.libraryapp.library.borrow;

import com.libraryapp.library.book.BookService;
import com.libraryapp.library.user.UserResponse;
import com.libraryapp.library.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BorrowMapper {

    private final UserService userService;
    private final BookService bookService;

    @Autowired
    public BorrowMapper(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }


    public BorrowResponse map(Borrow borrowEntity) {
        BorrowResponse borrowResponse = new BorrowResponse();
        borrowResponse.setId(borrowEntity.getId());
        borrowResponse.setBorrowDate(borrowEntity.getBorrowDate().toString());
        borrowResponse.setReturnDate(borrowEntity.getReturnDate().toString());
        borrowResponse.setRequiredReturnDate(borrowEntity.getRequiredReturnDate().toString());
        borrowResponse.setFine(borrowEntity.getFine());
        borrowResponse.setActive(borrowEntity.isActive());

        UserResponse userResponses = userService.getUserOfBorrow(borrowEntity);
        borrowResponse.setUserResponse(userResponses);

        return borrowResponse;
    }

    public Borrow createNew(CreateBorrowDto borrowDto) {
        Borrow borrow = new Borrow();
        borrow.setUser(userService.findById(borrowDto.getUserId()));
        borrow.setBook(bookService.findById(borrowDto.getBookId()));
        borrow.setBorrowDate(borrowDto.getBorrowDate());
        borrow.setRequiredReturnDate(borrowDto.getRequiredReturnDate());
        borrow.setReturnDate(borrowDto.getRequiredReturnDate());
        borrow.setActive(borrowDto.isActive());
        return borrow;
    }
}
