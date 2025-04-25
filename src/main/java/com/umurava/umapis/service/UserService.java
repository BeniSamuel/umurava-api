package com.umurava.umapis.service;

import com.umurava.umapis.dto.UserInformDto;
import com.umurava.umapis.enums.Gender;
import com.umurava.umapis.enums.Role;
import com.umurava.umapis.exception.NotFoundException;
import com.umurava.umapis.model.User;
import com.umurava.umapis.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers () {
        return this.userRepository.findAll();
    }

    public User getUserByEmail (String email) {
        return this.userRepository.getUserByEmail(email).orElseThrow(() -> new NotFoundException("User Not Found!!"));
    }

    public User getUserById (Long id) {
        return this.userRepository.getUserById(id).orElseThrow(() -> new NotFoundException("User Not Found!!"));
    }

    public User createUser (UserInformDto userInformDto) {
        User user = new User(userInformDto.getName(), userInformDto.getEmail(), userInformDto.getPhone(), passwordEncoder.encode(userInformDto.getPassword()), Role.DEFAULT, Gender.MALE);
        return this.userRepository.save(user);
    }

    public User updateUserById (Long id, UserInformDto userInformDto) {
        User user = this.getUserById(id);

        user.setName(userInformDto.getName());
        user.setEmail(userInformDto.getEmail());
        user.setPassword(userInformDto.getPassword());
        user.setPhone(user.getPhone());

        return this.userRepository.save(user);
    }

    public boolean deleteUserById (Long id) {
        User user = this.getUserById(id);
        this.userRepository.deleteById(id);
        return true;
    }
}
