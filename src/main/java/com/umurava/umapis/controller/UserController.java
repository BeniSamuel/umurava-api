package com.umurava.umapis.controller;

import com.umurava.umapis.model.User;
import com.umurava.umapis.service.UserService;
import com.umurava.umapis.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/umurava/v2/users")
public class UserController {
    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers () {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully Obtained users!!! 🎉🎉🎉", this.userService.getAllUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully obtained user!!! 🎉🎉🎉", this.userService.getUserById(id)));
    }
}
