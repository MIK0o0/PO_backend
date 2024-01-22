package com.example.SpringSecurity3.controller;

import com.example.SpringSecurity3.dto.FieldDTO;
import com.example.SpringSecurity3.dto.RoundDTO;
import com.example.SpringSecurity3.entity.Field;
import com.example.SpringSecurity3.entity.Round;
import com.example.SpringSecurity3.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/round")
public class RoundController {

    private final RoundService roundService;

    @GetMapping("/all")
    public ResponseEntity<List<FieldDTO>> getAllRounds(@RequestHeader("Authorization") String authorizationHeader) {
        return ResponseEntity.ok(roundService.getAllRounds(authorizationHeader));
    }
}
