package com.libraryapp.library.user;

import com.libraryapp.error.ObjectNotFoundException;
import com.libraryapp.library.borrow.Borrow;
import com.libraryapp.library.borrow.BorrowMapper;
import com.libraryapp.library.borrow.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


//    public List<UserDto> getAllUsers() {
//        return userRepository.getAllBookDatas().stream().map(userMapper::toDto).collect(Collectors.toList());
//    }
}
