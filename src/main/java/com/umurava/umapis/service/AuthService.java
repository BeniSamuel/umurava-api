package com.umurava.umapis.service;

import com.umurava.umapis.dto.UserInformDto;
import com.umurava.umapis.dto.UserLoginDto;
import com.umurava.umapis.model.User;
import com.umurava.umapis.util.ApiResponse;
import com.umurava.umapis.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthService (UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public User registerUser (UserInformDto userInformDto) {
        return this.userService.createUser(userInformDto);
    }

    public ResponseEntity<ApiResponse<String>> loginUser (UserLoginDto userLoginDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword())
            );

            User user = this.userService.getUserByEmail(userLoginDto.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully logged in user!!! 🎉🎉🎉", this.jwtUtil.generateToken(user.getEmail())));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "Failed to login due to bad credential 💔💔💔", "Bad Credentials"));
        }
    }

}
