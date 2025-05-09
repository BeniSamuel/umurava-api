package com.umurava.umapis.repository;

import com.umurava.umapis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByEmail (String email);
    Optional<User> getUserById (Long id);
}
