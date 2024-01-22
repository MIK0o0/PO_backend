package com.example.SpringSecurity3.dto;

import lombok.Data;
import lombok.Value;

import java.sql.Time;
import java.util.Date;

@Value
@Data
public class RoundDTO {
    Long id;
    String name;
    Date date;
    Time startTime;
    Time endTime;
    boolean hasRights;
}
