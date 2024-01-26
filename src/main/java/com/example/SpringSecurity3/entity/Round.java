package com.example.SpringSecurity3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "round")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_round")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "date")
    Date date;

    @Column(name = "start_time")
    Time startTime;

    @Column(name = "end_time")
    Time endTime;

    @JoinColumn(name = "id_field")
    @ManyToOne
    @JsonBackReference
    Field field;
}
