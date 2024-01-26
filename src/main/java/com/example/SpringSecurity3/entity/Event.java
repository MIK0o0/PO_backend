package com.example.SpringSecurity3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "event")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    Long id;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "event")
    @JsonIgnore
    private Set<Application> applications;
}
