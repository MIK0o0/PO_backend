package com.example.SpringSecurity3.repository;

import com.example.SpringSecurity3.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Long> {

    public List<Building> findAll();

    Building findById(long id);
}
