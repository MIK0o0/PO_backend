package com.example.SpringSecurity3.repository;

import com.example.SpringSecurity3.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    public List<Event> findAll();
}
