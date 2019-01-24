package com.libraryapp.library.user;

import com.libraryapp.error.ObjectNotFoundException;
import com.libraryapp.library.borrow.Borrow;
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

    public UserResponse addUser(CreateUserDto createUserDto) {
        User user = userMapper.createNew(createUserDto);

        try {
            return userMapper.map(userRepository.save(user));
        } catch (Exception e) {
            System.out.println("Was not possible to save user to database");
            e.printStackTrace();
            return null;
        }
    }

    public UserResponse findResponseById(Long id) {
        User user = findById(id);
        return userMapper.map(user);
    }
}
