package com.example.SpringSecurity3.repository;

import com.example.SpringSecurity3.entity.Application;
import com.example.SpringSecurity3.entity.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Application findById(long id);

    @Query("SELECT a FROM Application a JOIN a.applicationStatus as status WHERE status.name = 'PENDING'")
    List<Application> findAllByApplicationStatusEqualsPending();

    @Query("SELECT a.id FROM Application a JOIN a.applicationStatus as status WHERE a.date = :date AND a.building.id = :buildingId AND a.room.id = :roomId AND " +
            "((a.startTime >= :startTime AND a.startTime <= :endTime) OR (a.endTime >= :startTime AND a.endTime <= :endTime)) AND status.name = 'ACCEPTED'")
    List<Long> findApplicationIdsByDateAndBuildingAndRoomAndTimeRangeAndStatus(
            @Param("date") Date date,
            @Param("buildingId") long buildingId,
            @Param("roomId") long roomId,
            @Param("startTime") Time startTime,
            @Param("endTime") Time endTime
    );

    @Transactional
    @Modifying
    @Query(value = "UPDATE application SET fk_application_status = (SELECT id_application_status FROM application_status WHERE name = :status) WHERE id_application = :id", nativeQuery = true)
    void updateApplicationStatus(@Param("id") long id, @Param("status") String status);

    @Transactional
    @Modifying
    @Query(value = "UPDATE application SET fk_building = :buildingId, fk_room = :roomId WHERE id_application = :id", nativeQuery = true)
    void updateApplicationPlace(@Param("id") long id, @Param("buildingId") long buildingId, @Param("roomId") long roomId);
}
