package com.example.SpringSecurity3.controller;

import com.example.SpringSecurity3.dto.UserDetailsDTO;
import com.example.SpringSecurity3.service.JwtService;
import com.example.SpringSecurity3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @GetMapping("/details")
    public ResponseEntity<UserDetailsDTO> getUserDetails(@RequestHeader("Authorization") String authorizationHeader) {
        return ResponseEntity.ok(userService.getUserDetails(authorizationHeader));
    }

    @GetMapping("/is-expired")
    public ResponseEntity<Boolean> isExpired(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.split(" ")[1];
        return ResponseEntity.ok(jwtService.isTokenExpired(token));
    }
}
