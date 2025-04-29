package com.umurava.umapis.controller;

import com.umurava.umapis.dto.ChallengeDto;
import com.umurava.umapis.model.Challenges;
import com.umurava.umapis.service.ChallengeService;
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

    public ChallengeController (ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Challenges>>> getAllChallenges () {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully obtained all challenges!!! 🎉🎉🎉", this.challengeService.getAllChallenges()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Challenges>> getChallengeById (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully found challenge!!! 🎉🎉🎉", this.challengeService.getChallengeById(id)));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Challenges>> createChallenge (@RequestPart("challengeDto") ChallengeDto challengeDto, @RequestPart("challengeCover") MultipartFile challengeCover) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Successfully created a challenge!!! 🎉🎉🎉", this.challengeService.createChallenge(challengeDto, challengeCover)));
    }
}
