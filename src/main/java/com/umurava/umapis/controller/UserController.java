package com.umurava.umapis.controller;

import com.umurava.umapis.dto.UserInformDto;
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

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers () {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully Obtained users!!! 🎉🎉🎉", this.userService.getAllUsers()));
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<User>> getCurrentUser () {
        return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained user!!! 🎉🎉🎉", this.userService.getLoggedUser()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully obtained user!!! 🎉🎉🎉", this.userService.getUserById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUserById (@PathVariable Long id, @RequestBody UserInformDto userInformDto) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Successfully updated user!!! 🎉🎉🎉", this.userService.updateUserById(id, userInformDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUserById (@PathVariable Long id) {
        if (this.userService.deleteUserById(id)) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully deleted user!!! 🎉🎉🎉", "Deleted"));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Failed to deleted user!!!", "Failed"));
        }
    }
}
