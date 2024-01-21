package com.example.SpringSecurity3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "schedule")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_schedule")
    Long id;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "schedule")
    private Set<Course> courses = new HashSet<>();
}
