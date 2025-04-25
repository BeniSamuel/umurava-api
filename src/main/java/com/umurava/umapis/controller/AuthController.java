package com.umurava.umapis.controller;

import com.umurava.umapis.dto.UserInformDto;
import com.umurava.umapis.model.User;
import com.umurava.umapis.service.AuthService;
import com.umurava.umapis.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/umurava/v2/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController (AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register-user")
    public ResponseEntity<ApiResponse<User>> registerUser (@RequestBody UserInformDto userInformDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Successfully registered a user!!! 🎉🎉🎉", this.authService.registerUser(userInformDto)));
    }
}
