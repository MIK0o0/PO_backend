package com.example.SpringSecurity3.entity;

import com.example.SpringSecurity3.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "application")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_application")
    Long id;

    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_event")
    private Event event;

    @Column(name = "date")
    Date date;

    @Column(name = "start_time")
    Time startTime;

    @Column(name = "end_time")
    Time endTime;

    @Column(name = "participants")
    int participants;

    @ManyToOne
    @JoinColumn(name = "fk_building")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "fk_room")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "fk_application_status")
    private ApplicationStatus applicationStatus;

    @Column(name = "description")
    String description;

    @Transient
    private boolean hasConflict;

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", user=" + user +
                ", event=" + event +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", participants=" + participants +
                ", building=" + building +
                ", room=" + room +
                ", applicationStatus=" + applicationStatus +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&
                // Include other relevant fields
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, description /* Other fields */);
    }
}
