package com.example.SpringSecurity3.service;

import com.example.SpringSecurity3.dto.UserDetailsDTO;
import com.example.SpringSecurity3.entity.user.User;
import com.example.SpringSecurity3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public UserDetailsDTO getUserDetails(String authorizationHeader) {
        Long userId = jwtService.extractUserId(authorizationHeader);
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        return user.get().toUserDetailsDTO();
    }
}
