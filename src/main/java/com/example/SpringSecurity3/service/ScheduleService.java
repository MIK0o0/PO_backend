package com.example.SpringSecurity3.service;

import com.example.SpringSecurity3.entity.Schedule;
import com.example.SpringSecurity3.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    
    private final ScheduleRepository scheduleRepository;
    
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }
}
