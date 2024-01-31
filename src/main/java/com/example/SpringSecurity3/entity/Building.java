package com.example.SpringSecurity3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
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
@JsonIncludeProperties({ "id", "number" })
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_building")
    Long id;

    @Column(name = "number")
    String number;

//    @ManyToMany
//    @JoinTable(
//        name = "building_room",
//        joinColumns = @JoinColumn(name = "fk_building"),
//        inverseJoinColumns = @JoinColumn(name = "fk_room")
//    )
//    private List<Room> rooms;

    @OneToMany(mappedBy = "building")
    private List<Application> applications;
}
