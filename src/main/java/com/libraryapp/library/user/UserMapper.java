package com.libraryapp.library.user;

import com.libraryapp.library.borrow.BorrowService;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final BorrowService borrowService;

    public UserMapper(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    public UserResponse map (User userEntity){
//        return new UserResponse(userEntity.getId(),userEntity.getName(),userEntity.getSurname(),userEntity.getBorrows());
        return null;
    }

    public User createNew(CreateUserDto userDto){
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassword(userDto.getPassword());

        return user;
    }

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        user.getBorrows().forEach(borrow -> userDto.getBorrowsId().add(user.getId()));

        return userDto;
    }
}
