package com.example.SpringSecurity3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "building_room")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuildingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_building_room")
    Long id;

    @Column(name = "fk_building")
    Long idBuilding;

    @Column(name = "fk_room")
    Long idRoom;

}
