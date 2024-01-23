package com.example.SpringSecurity3.controller;

import com.example.SpringSecurity3.dto.FormDTO;
import com.example.SpringSecurity3.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping("/form")
    public ResponseEntity<FormDTO> getBuildings() {
        return ResponseEntity.ok(applicationService.getForm());
    }

}
