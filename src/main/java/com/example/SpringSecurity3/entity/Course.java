package com.example.SpringSecurity3.entity;

import com.example.SpringSecurity3.dto.Day;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.DayOfWeek;

@Entity
@Table(name = "course")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    Long id;

    @ManyToOne
    @JoinColumn(name = "fk_schedule")
    @JsonIgnore
    Schedule schedule;

    @Column(name = "teacher")
    String teacher;

    @Column(name = "day")
    @Enumerated(EnumType.STRING)
    Day day;

    @Column(name = "start_time")
    Time startTime;

    @Column(name = "end_time")
    Time endTime;

    @Column(name = "participants")
    int participants;

    @Column(name = "building")
    String building;

    @Column(name = "room")
    String room;
}
