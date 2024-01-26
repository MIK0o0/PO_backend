package com.example.SpringSecurity3.controller;

import com.example.SpringSecurity3.dto.ApplicationRequestDTO;
import com.example.SpringSecurity3.dto.FormDTO;
import com.example.SpringSecurity3.entity.Application;
import com.example.SpringSecurity3.service.ApplicationService;
import com.example.SpringSecurity3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;
    private final UserService userService;

    @GetMapping("/form")
    public ResponseEntity<FormDTO> getBuildings(@RequestHeader("Authorization") String authorizationHeader) {
        if (!userService.hasUserPermission(authorizationHeader)) {
            return ResponseEntity.status(403).build();
        }
        return ResponseEntity.ok(applicationService.getForm());
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveApplication(@RequestHeader("Authorization") String authorizationHeader, @RequestBody ApplicationRequestDTO applicationDTO) {
        if (!userService.hasUserPermission(authorizationHeader)) {
            return ResponseEntity.status(403).build();
        }
        System.out.println(applicationDTO);
        applicationService.saveApplication(applicationDTO, authorizationHeader);
        return ResponseEntity.ok("Application saved");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Application>> getAllApplications(@RequestHeader("Authorization") String authorizationHeader) {
        if (!userService.isUserAdmin(authorizationHeader)) {
            return ResponseEntity.status(403).build();
        }
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@RequestHeader("Authorization") String authorizationHeader, @PathVariable long id) {
        if (!userService.isUserAdmin(authorizationHeader)) {
            return ResponseEntity.status(403).build();
        }
        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }

    @PutMapping("/accept/{id}")
    public ResponseEntity<String> acceptApplication(@RequestHeader("Authorization") String authorizationHeader, @PathVariable long id) {
        if (!userService.isUserAdmin(authorizationHeader)) {
            return ResponseEntity.status(403).build();
        }
        applicationService.acceptApplication(id);
        return ResponseEntity.ok("Application accepted");
    }

    @PutMapping("/reject/{id}")
    public ResponseEntity<String> rejectApplication(@RequestHeader("Authorization") String authorizationHeader, @PathVariable long id) {
        if (!userService.isUserAdmin(authorizationHeader)) {
            return ResponseEntity.status(403).build();
        }
        applicationService.rejectApplication(id);
        return ResponseEntity.ok("Application rejected");
    }

    @PutMapping("/amend/{id}")
    public ResponseEntity<String> amendApplication(@RequestHeader("Authorization") String authorizationHeader, @PathVariable long id, @RequestParam long buildingId, @RequestParam long roomId) {
        if (!userService.isUserAdmin(authorizationHeader)) {
            return ResponseEntity.status(403).build();
        }
        applicationService.amendApplication(id, buildingId, roomId);
        return ResponseEntity.ok("Application amended");
    }

}
