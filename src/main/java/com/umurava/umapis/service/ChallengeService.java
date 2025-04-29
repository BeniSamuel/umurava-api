package com.umurava.umapis.service;

import com.umurava.umapis.dto.ChallengeDto;
import com.umurava.umapis.exception.NotFoundException;
import com.umurava.umapis.model.Challenges;
import com.umurava.umapis.repository.ChallengesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {
    private final ChallengesRepository challengesRepository;

    public ChallengeService (ChallengesRepository challengesRepository) {
        this.challengesRepository = challengesRepository;
    }

    public List<Challenges> getAllChallenges () {
        return this.challengesRepository.findAll();
    }

    public Challenges getChallengeById (Long id) {
        return this.challengesRepository.getChallengesById(id).orElseThrow(() -> new NotFoundException("Challenge not found!!! 💔💔💔"));
    }

    public Challenges createChallenge (ChallengeDto challengeDto) {
        Challenges newChallenge = new Challenges(challengeDto.getName(), challengeDto.getChallengeCover(), )
    }
}
