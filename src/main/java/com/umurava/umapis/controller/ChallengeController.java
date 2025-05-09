package com.umurava.umapis.controller;

import com.umurava.umapis.dto.ChallengeDto;
import com.umurava.umapis.model.Challenges;
import com.umurava.umapis.model.User;
import com.umurava.umapis.service.ChallengeService;
import com.umurava.umapis.service.UserService;
import com.umurava.umapis.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/umurava/v2/challenges")
public class ChallengeController {
    private final ChallengeService challengeService;
    private final UserService userService;

    public ChallengeController (ChallengeService challengeService, UserService userService) {
        this.challengeService = challengeService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Challenges>>> getAllChallenges () {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully obtained all challenges!!! 🎉🎉🎉", this.challengeService.getAllChallenges()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Challenges>> getChallengeById (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully found challenge!!! 🎉🎉🎉", this.challengeService.getChallengeById(id)));
    }

    @GetMapping("/user/me")
    public ResponseEntity<ApiResponse<List<Challenges>>> getChallengesByActiveUser () {
        User user = this.userService.getLoggedUser();
        return ResponseEntity.ok().body(new ApiResponse<>(true, "Successfully obtained challenge for user", this.challengeService.getAllChallengesByUser(user)));
    }

    @PostMapping(value = "/create", consumes = "multipart/form-data" )
    public ResponseEntity<ApiResponse<Challenges>> createChallenge (@RequestPart("challengeDto") ChallengeDto challengeDto, @RequestPart("challengeCover") MultipartFile challengeCover) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Successfully created a challenge!!! 🎉🎉🎉", this.challengeService.createChallenge(challengeDto, challengeCover)));
    }

}
