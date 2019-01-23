package com.libraryapp.library.bookdata;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookDataService {

    private final BookDataRepository bookDataRepository;
    private final BookDataMapper bookDataMapper;


    public BookDataService(BookDataRepository bookDataRepository, BookDataMapper bookDataMapper) {
        this.bookDataRepository = bookDataRepository;
        this.bookDataMapper = bookDataMapper;
    }

    public List<BookDataResponse> getAllBookDatas() {
        return bookDataRepository.findAll()
                .stream()
                .map(bookDataMapper::map)
                .collect(Collectors.toList());
    }

    public BookDataResponse addBookData(CreateBookDataDto createBookDataDto) {
        BookData bookData = bookDataMapper.createNew(createBookDataDto);
        try {
            return bookDataMapper.map(bookDataRepository.save(bookData));
        } catch (Exception e) {
            System.out.println(e.getMessage() + " Couldnt save BookData.");
            return null;
        }
    }

    public BookData findById(Long id) {

        try {
            return bookDataRepository.findById(id);
        } catch (Exception e) {
            System.out.println("Was not possible to get book data from db with id: " + id);
            e.printStackTrace();
            return null;
        }
    }

    public BookDataResponse findResponseById(Long id) {
        BookData bookData = findById(id);
        return bookDataMapper.map(bookData);
    }

}
