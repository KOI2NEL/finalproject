package com.libraryapp.library.borrow;

import com.libraryapp.library.book.BookMapper;
import com.libraryapp.library.book.BookResponse;
import com.libraryapp.library.book.BookService;
import com.libraryapp.library.user.UserResponse;
import com.libraryapp.library.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BorrowMapper {

    private final UserService userService;
    private final BookService bookService;
    private final BookMapper bookMapper;

    @Autowired
    public BorrowMapper(UserService userService, BookService bookService, BookMapper bookMapper) {
        this.userService = userService;
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }


    public BorrowResponse map(Borrow borrowEntity) {
        BorrowResponse borrowResponse = new BorrowResponse();
        borrowResponse.setId(borrowEntity.getId());
        borrowResponse.setBorrowDate(borrowEntity.getBorrowDate());
        borrowResponse.setReturnDate(borrowEntity.getReturnDate());
        borrowResponse.setRequiredReturnDate(borrowEntity.getRequiredReturnDate());
        borrowResponse.setFine(borrowEntity.getFine());
        borrowResponse.setActive(borrowEntity.isActive());

        UserResponse userResponses = userService.getUserOfBorrow(borrowEntity);
        borrowResponse.setUserResponse(userResponses);

        borrowResponse.setBookResponse(bookMapper.map(borrowEntity.getBook()));

        return borrowResponse;
    }

    public Borrow createNew(CreateBorrowDto borrowDto) {
        Borrow borrow = new Borrow();
        borrow.setUser(userService.findById(borrowDto.getUserId()));
        borrow.setBook(bookService.findById(borrowDto.getBookId()));
        borrow.setBorrowDate(borrowDto.getBorrowDate());
        borrow.setRequiredReturnDate(borrowDto.getRequiredReturnDate());
        borrow.setReturnDate(borrowDto.getReturnDate());
        borrow.setActive(borrowDto.isActive());
        borrow.setFine(0.0);
        return borrow;
    }
}
