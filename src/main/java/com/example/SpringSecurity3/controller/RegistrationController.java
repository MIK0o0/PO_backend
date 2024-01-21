package com.example.SpringSecurity3.controller;

import com.example.SpringSecurity3.dto.RegistrationDetailsDTO;
//import com.example.SpringSecurity3.entity.RegistrationEntity;
import com.example.SpringSecurity3.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

//    @GetMapping("/get/all")
//    public List<RegistrationEntity> getAllRegistrations() {
//        //TODO: implement
//        return null;
//    }
}
