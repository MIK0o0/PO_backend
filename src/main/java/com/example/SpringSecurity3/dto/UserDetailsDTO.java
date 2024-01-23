package com.example.SpringSecurity3.dto;

import com.example.SpringSecurity3.entity.user.Role;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Data
@Builder
public class UserDetailsDTO {
     Long id;
     String email;
     String firstName;
     String lastName;
     Role role;
}
