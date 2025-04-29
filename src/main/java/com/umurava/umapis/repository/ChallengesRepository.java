package com.umurava.umapis.repository;

import com.umurava.umapis.model.Challenges;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChallengesRepository extends JpaRepository<Challenges, Long> {
    Optional<Challenges> getChallengesById (Long id);
}
