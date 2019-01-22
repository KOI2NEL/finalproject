package com.libraryapp.library.user;

import com.libraryapp.error.ObjectNotFoundException;
import com.libraryapp.library.borrow.Borrow;
import com.libraryapp.library.borrow.BorrowMapper;
import com.libraryapp.library.borrow.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BorrowRepository borrowRepository;


    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, BorrowRepository borrowRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.borrowRepository = borrowRepository;

    }

    public UserResponse getUserOfBorrow(Borrow borrow) {
        User user = userRepository.findUserByBorrows(borrow)
                .orElseThrow(() -> new ObjectNotFoundException(borrow.getId().toString()));
        return userMapper.map(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }

    public void addUser(CreateUserDto createUserDto) {
        userRepository.save(userMapper.createNew(createUserDto));
    }

    public UserResponse findResponseById(Long id) {
        User user = findById(id);
        return userMapper.map(user);
    }
}
