package com.example.SpringSecurity3.repository;

import com.example.SpringSecurity3.entity.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationStatusRepository extends JpaRepository<ApplicationStatus, Long> {

    ApplicationStatus findById(long id);

    ApplicationStatus findByName(String name);
}
