package com.example.SpringSecurity3.repository;

import com.example.SpringSecurity3.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldRepository extends JpaRepository<Field, Long> {

    List<Field> findAll();
}
