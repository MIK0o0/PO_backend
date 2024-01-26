package com.example.SpringSecurity3.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "field")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_field")
    Long id;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "field")
    @JsonManagedReference
    private List<Round> rounds;
}
