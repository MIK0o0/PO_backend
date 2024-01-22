package com.example.SpringSecurity3.dto;

import lombok.Data;
import lombok.Value;

import java.util.Set;

@Value
@Data
public class FieldDTO {
    Long id;
    String name;
    Set<RoundDTO> rounds;
}
