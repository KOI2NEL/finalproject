package com.libraryapp.library.user;

import com.libraryapp.library.borrow.BorrowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BorrowRepository borrowRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper, BorrowRepository borrowRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.borrowRepository = borrowRepository;
    }


    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }
}
