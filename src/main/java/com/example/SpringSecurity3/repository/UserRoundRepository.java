package com.example.SpringSecurity3.repository;

import com.example.SpringSecurity3.entity.UserRound;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoundRepository extends JpaRepository<UserRound, Long> {

    List<UserRound> findAllByUserId(Long userId);
}
