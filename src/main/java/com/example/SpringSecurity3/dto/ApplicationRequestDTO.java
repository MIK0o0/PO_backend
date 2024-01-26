package com.example.SpringSecurity3.dto;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequestDTO {
    int eventId;
    Date date;
    Time startTime;
    Time endTime;
    int participants;
    int buildingId;
    int roomId;
    String description;
}
