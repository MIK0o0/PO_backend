package com.example.SpringSecurity3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "building")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Building {

    @Id
    @Column(name = "id_building")
    Long id;

    @Column(name = "number")
    String number;

    @ManyToMany
    @JoinTable(
        name = "building_room",
        joinColumns = @JoinColumn(name = "fk_building"),
        inverseJoinColumns = @JoinColumn(name = "fk_room")
    )
    private List<Room> rooms;
}
