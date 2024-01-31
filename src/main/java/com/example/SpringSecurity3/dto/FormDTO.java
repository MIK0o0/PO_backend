package com.example.SpringSecurity3.dto;

import com.example.SpringSecurity3.entity.Building;
import com.example.SpringSecurity3.entity.BuildingRoom;
import com.example.SpringSecurity3.entity.Event;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Value
@Data
public class FormDTO {
    List<Event> events;
    List<BuildingRoom> buildings;
}
