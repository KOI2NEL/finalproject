package com.libraryapp.library.user;


import com.libraryapp.library.borrow.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByBorrows(Borrow borrow);

    User findById(Long id);

    Optional<User> findUserByLogin(String login);
}

