package com.umurava.umapis.repository;

import com.umurava.umapis.model.Challenges;
import com.umurava.umapis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface ChallengesRepository extends JpaRepository<Challenges, Long> {
    Optional<Challenges> getChallengesById (Long id);
    List<Challenges> getChallengesByUser(User user);
}
