package com.libraryapp.library.bookdata;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public CreateBookDataDto saveBookData(CreateBookDataDto createBookDataDto) {
        return bookDataRepository.save(createBookDataDto);
    }

    public Set<BookData> findBookDatas() {
        return null;
    }

    public BookData findById(Long id) {
        BookData bookData = bookDataRepository.findById(id);
        return bookData;
    }

    ;
}
