package com.example.SpringSecurity3.service;

import com.example.SpringSecurity3.dto.ApplicationRequestDTO;
import com.example.SpringSecurity3.dto.ApplicationStatus;
import com.example.SpringSecurity3.dto.FormDTO;
import com.example.SpringSecurity3.entity.Application;
import com.example.SpringSecurity3.entity.Building;
import com.example.SpringSecurity3.entity.Event;
import com.example.SpringSecurity3.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final BuildingRepository buildingRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final ApplicationStatusRepository applicationStatusRepository;
    private final ApplicationRepository applicationRepository;
    private final JwtService jwtService;


    public FormDTO getForm() {
        List<Building> buildings = buildingRepository.findAll();
        List<Event> events = eventRepository.findAll();
        return new FormDTO(events, buildings);
    }

    public void saveApplication(ApplicationRequestDTO applicationRequestDTO, String authorizationHeader) {
        Long userId = jwtService.extractUserId(authorizationHeader);
        Application application = mapDtoToEntity(applicationRequestDTO, userId);
        applicationRepository.save(application);
    }

    public Application mapDtoToEntity(ApplicationRequestDTO applicationRequestDTO, long userId) {
        return Application.builder()
                .user(userRepository.findById(userId))
                .event(eventRepository.findById(applicationRequestDTO.getEventId()))
                .date(applicationRequestDTO.getDate())
                .startTime(applicationRequestDTO.getStartTime())
                .endTime(applicationRequestDTO.getEndTime())
                .participants(applicationRequestDTO.getParticipants())
                .building(buildingRepository.findById(applicationRequestDTO.getBuildingId()))
                .room(roomRepository.findById(applicationRequestDTO.getRoomId()))
                .applicationStatus(applicationStatusRepository.findByName(String.valueOf(ApplicationStatus.PENDING)))
                .description(applicationRequestDTO.getDescription())
                .build();
    }

    public List<Application> getAllApplications() {
        List<Application> applications = applicationRepository.findAllByApplicationStatusEqualsPending();
        applications.forEach(application -> {
            List<Long> conflictingApplicationIds = applicationRepository.findApplicationIdsByDateAndBuildingAndRoomAndTimeRangeAndStatus(
                    application.getDate(),
                    application.getBuilding().getId(),
                    application.getRoom().getId(),
                    application.getStartTime(),
                    application.getEndTime()
            );
            if (!conflictingApplicationIds.isEmpty()) {
                application.setHasConflict(true);
            }
        });
        return applications;
    }

    public Application getApplicationById(long id) {
        return applicationRepository.findById(id);
    }

    public void acceptApplication(long id) {
        applicationRepository.updateApplicationStatus(id, String.valueOf(ApplicationStatus.ACCEPTED));
    }

    public void rejectApplication(long id) {
        applicationRepository.updateApplicationStatus(id, String.valueOf(ApplicationStatus.REJECTED));
    }

    public void amendApplication(long id, long buildingId, long roomId) {
        applicationRepository.updateApplicationPlace(id, buildingId, roomId);
    }
}
