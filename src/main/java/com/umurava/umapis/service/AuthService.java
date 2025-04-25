package com.umurava.umapis.service;

import com.umurava.umapis.dto.UserInformDto;
import com.umurava.umapis.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public AuthService (UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    public User registerUser (UserInformDto userInformDto) {
        return this.userService.createUser(userInformDto);
    }

}
