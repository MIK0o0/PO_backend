package com.example.SpringSecurity3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "user_round")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRound {

    @Id
    @Column(name = "id_user_round")
    Long id;

    @Column(name = "id_user")
    Long userId;

    @Column(name = "id_round")
    Long roundId;

}
