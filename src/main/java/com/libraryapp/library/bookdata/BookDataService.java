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

    public BookData saveBookData(BookData bookData) {
        return bookDataRepository.save(bookData);
    }

    public Set<BookData> findBookDatas() {
        //TODO: Czy tu muszę zwracać Set Książek które ma autor. Jeżeli tak to jak? Stworzyć metodę, która zwróci mi BookDatas dla danego Autora?
        return null;
    }

    ;
}
