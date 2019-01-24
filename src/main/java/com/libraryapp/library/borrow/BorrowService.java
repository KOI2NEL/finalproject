package com.libraryapp.library.borrow;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowService {

    private final BorrowRepository borrowRepository;
    private final BorrowMapper borrowMapper;

    public BorrowService(BorrowRepository borrowRepository, BorrowMapper borrowMapper) {
        this.borrowRepository = borrowRepository;
        this.borrowMapper = borrowMapper;
    }


    public List<BorrowResponse> getAllBorrows() {
        try {
            return borrowRepository.findAll()
                    .stream()
                    .map(borrowMapper::map)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Borrow DB is empty");
            return null;
        }
    }

    public BorrowResponse addBorrow(CreateBorrowDto createBorrowDto) {
        Borrow borrow = borrowMapper.createNew(createBorrowDto);

        try {
            return borrowMapper.map(borrowRepository.save(borrow));
        } catch (Exception e) {
            System.out.println("Was not possible to save borrow to database");
            e.printStackTrace();
            return null;
        }
    }

    public Borrow findById(Long id) {
        Borrow borrow = borrowRepository.findById(id);
        return borrow;
    }

    public BorrowResponse findResponseById(Long id) {
        Borrow borrow = findById(id);
        return borrowMapper.map(borrow);
    }

    public BorrowResponse returnBook(Long borrowId) {

        try {
            Borrow borrow = borrowRepository.findById(borrowId);

            borrow.setActive(false);
            borrow.setReturnDate(LocalDate.now());
            borrowRepository.save(borrow);

            return borrowMapper.map(borrow);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
