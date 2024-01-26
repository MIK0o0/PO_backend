package com.example.SpringSecurity3.repository;

import com.example.SpringSecurity3.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

        public Room findById(long id);
}
