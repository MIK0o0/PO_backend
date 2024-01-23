package com.example.SpringSecurity3.service;

import com.example.SpringSecurity3.dto.FormDTO;
import com.example.SpringSecurity3.entity.Building;
import com.example.SpringSecurity3.entity.Event;
import com.example.SpringSecurity3.repository.BuildingRepository;
import com.example.SpringSecurity3.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final BuildingRepository buildingRepository;
    private final EventRepository eventRepository;

    public FormDTO getForm() {
        List<Building> buildings = buildingRepository.findAll();
        List<Event> events = eventRepository.findAll();
        return new FormDTO(events, buildings);
    }
}
