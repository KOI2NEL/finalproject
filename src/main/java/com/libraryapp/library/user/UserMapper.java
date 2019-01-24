package com.libraryapp.library.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse map(User userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
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
