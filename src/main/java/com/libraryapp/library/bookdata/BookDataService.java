package com.libraryapp.library.bookdata;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDataService {

    private final BookDataRepository bookDataRepository;

    public BookDataService(BookDataRepository bookDataRepository) {
        this.bookDataRepository = bookDataRepository;
    }
//    private final BookDataMapper bookDataMapper;

//    @Autowired
//    public BookDataService(BookDataRepository bookDataRepository, BookDataMapper bookDataMapper) {
//        this.bookDataRepository = bookDataRepository;
//        this.bookDataMapper = bookDataMapper;
//    }


    public List<BookData> findAll() {
        return bookDataRepository.findAll();
    }

    public BookData saveBookData(BookData bookData) {
        return bookDataRepository.save(bookData);
    }
}
