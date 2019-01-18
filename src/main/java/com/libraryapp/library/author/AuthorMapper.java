package com.libraryapp.library.author;

import com.libraryapp.library.bookdata.BookDataMapper;
import com.libraryapp.library.bookdata.BookDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    private final BookDataMapper bookDataMapper;
    private final BookDataService bookDataService;

    @Autowired
    public AuthorMapper(BookDataMapper bookDataMapper, BookDataService bookDataService) {
        this.bookDataMapper = bookDataMapper;
        this.bookDataService = bookDataService;
    }

    public AuthorDto toDto(Author author) {
        AuthorDto authorDto = new AuthorDto();

        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setSurname(author.getSurname());
        author.getBookDatas()
                .forEach(bookData -> authorDto
                        .getBookDataDtos().add(author.getName()));

        return authorDto;
    }

//    public Author toEntity (AuthorDto authorDto){
//        Author author = new Author();
//
//        author.setId(authorDto.getId());
//        author.setName(authorDto.getName());
//        author.setSurname(authorDto.getSurname());
//
//        authorDto.getBookDataDtos()
//                .forEach(bookDataDto -> author
//                        .getBookDatas().add(bookDataMapper.toEntity(bookDataDto)));
//
//        return author;
//    }

    public Author toEntity(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        //TODO: Czy zwracać autorów książek, jeżeli tak to metodą z service czy tak jak zakomentowane wyżej?
        author.setBookDatas(bookDataService.findBookDatas());
        return author;
    }
}
