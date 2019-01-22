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
        return borrowRepository.findAll().stream().map(borrowMapper::map).collect(Collectors.toList());
    }

    public void addBorrow(CreateBorrowDto createBorrowDto) {
        borrowRepository.save(borrowMapper.createNew(createBorrowDto));
    }

    public Borrow findById(Long id){
        Borrow borrow = borrowRepository.findById(id);
        return borrow;
    }

    public BorrowResponse findResponseById(Long id){
        Borrow borrow = findById(id);
        return borrowMapper.map(borrow);
    }
}
