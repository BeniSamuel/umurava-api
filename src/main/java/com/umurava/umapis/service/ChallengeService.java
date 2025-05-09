package com.umurava.umapis.service;

import com.umurava.umapis.dto.ChallengeDto;
import com.umurava.umapis.enums.Clevel;
import com.umurava.umapis.enums.Cstatus;
import com.umurava.umapis.exception.NotFoundException;
import com.umurava.umapis.model.Challenges;
import com.umurava.umapis.model.User;
import com.umurava.umapis.repository.ChallengesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ChallengeService {
    private final ChallengesRepository challengesRepository;
    private final FileService fileService;
    private final UserService userService;

    public ChallengeService (ChallengesRepository challengesRepository, FileService fileService, UserService userService) {
        this.challengesRepository = challengesRepository;
        this.fileService = fileService;
        this.userService = userService;
    }

    public List<Challenges> getAllChallenges () {
        return this.challengesRepository.findAll();
    }

    public List<Challenges> getAllChallengesByUser (User user) {
        return this.challengesRepository.getChallengesByUser(user);
    }

    public Challenges getChallengeById (Long id) {
        return this.challengesRepository.getChallengesById(id).orElseThrow(() -> new NotFoundException("Challenge not found!!! 💔💔💔"));
    }

    public Challenges createChallenge (ChallengeDto challengeDto, MultipartFile file) throws IOException {
        Challenges newChallenge = new Challenges(fileService.uploadFile(file), challengeDto.getName(), challengeDto.getLongDescription(), challengeDto.getStartTime(), challengeDto.getEndTime(), Cstatus.OPEN, Clevel.JUNIOR);
        return this.challengesRepository.save(newChallenge);
    }

}
