package com.example.SpringSecurity3.repository;

import com.example.SpringSecurity3.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Application findById(long id);

    @Query("SELECT a.id FROM Application a JOIN a.applicationStatus as status WHERE a.date = :date AND a.building.id = :buildingId AND a.room.id = :roomId AND " +
            "((a.startTime >= :startTime AND a.startTime <= :endTime) OR (a.endTime >= :startTime AND a.endTime <= :endTime)) AND status.name = 'ACCEPTED'")
    List<Long> findApplicationIdsByDateAndBuildingAndRoomAndTimeRangeAndStatus(
            @Param("date") Date date,
            @Param("buildingId") long buildingId,
            @Param("roomId") long roomId,
            @Param("startTime") Time startTime,
            @Param("endTime") Time endTime
    );
}
