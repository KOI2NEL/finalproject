package com.libraryapp.library.borrow;

import org.springframework.stereotype.Service;

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
        return borrowRepository.findAll()
                .stream()
                .map(borrowMapper::map)
                .collect(Collectors.toList());
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
}
