package com.practice.board.domain.user.repository;

import com.practice.board.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByName(String name);

    Optional<User> getUserByEmail(String email);
}
