package com.example.SpringSecurity3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "application_status")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_application_status")
    Long id;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "applicationStatus")
    @JsonIgnore
    private List<Application> applications;
}
