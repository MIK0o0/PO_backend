package com.example.SpringSecurity3.service;

import com.example.SpringSecurity3.dto.UserDetailsDTO;
import com.example.SpringSecurity3.entity.user.Role;
import com.example.SpringSecurity3.entity.user.User;
import com.example.SpringSecurity3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final static Set<Role> ADMIN_ROLES = Set.of(Role.ADMIN, Role.SUPER_USER);

    public UserDetailsDTO getUserDetails(String authorizationHeader) {
        Long userId = jwtService.extractUserId(authorizationHeader);
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        return user.get().toUserDetailsDTO();
    }

    public boolean hasUserPermission(String authorizationHeader) {
        return ADMIN_ROLES.contains(getUserRole(authorizationHeader));
    }

    public boolean isUserAdmin(String authorizationHeader) {
        return getUserRole(authorizationHeader).equals(Role.ADMIN);
    }

    private Role getUserRole(String authorizationHeader) {
        Long userId = jwtService.extractUserId(authorizationHeader);
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        return user.get().getRole();
    }
}
