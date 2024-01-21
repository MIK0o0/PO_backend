package com.example.SpringSecurity3.repository;

import com.example.SpringSecurity3.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    
    List<Schedule> findAll();
}
