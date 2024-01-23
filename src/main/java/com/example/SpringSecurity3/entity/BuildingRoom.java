package com.example.SpringSecurity3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "building_room")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuildingRoom {

    @Id
    @Column(name = "id_building_room")
    Long id;

    @Column(name = "fk_building")
    Long idBuilding;

    @Column(name = "fk_room")
    Long idRoom;
}
