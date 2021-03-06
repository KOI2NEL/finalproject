package com.libraryapp.library.user;

import com.libraryapp.library.borrow.BorrowMapper;
import com.libraryapp.library.borrow.BorrowService;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse map(User userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(userEntity.getName());
        userResponse.setSurname(userEntity.getSurname());

        return userResponse;
    }

    public User createNew(CreateUserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassword(userDto.getPassword());

        return user;
    }
}
