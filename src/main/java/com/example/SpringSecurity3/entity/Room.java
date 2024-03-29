package com.example.SpringSecurity3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "room")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_room")
    Long id;

    @Column(name = "number")
    String number;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Application> applications;
}
