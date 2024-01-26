package com.example.SpringSecurity3;

import com.example.SpringSecurity3.dto.ApplicationRequestDTO;
import com.example.SpringSecurity3.dto.ApplicationStatus;
import com.example.SpringSecurity3.dto.FormDTO;
import com.example.SpringSecurity3.entity.Application;
import com.example.SpringSecurity3.entity.Building;
import com.example.SpringSecurity3.entity.Event;
import com.example.SpringSecurity3.repository.*;
import com.example.SpringSecurity3.service.ApplicationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ApplicationServiceTest {

    @InjectMocks
    private ApplicationService applicationService;

    @Mock
    private BuildingRepository buildingRepository;

    @Mock
    private EventRepository eventRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private ApplicationStatusRepository applicationStatusRepository;

    @Mock
    private ApplicationRepository applicationRepository;


    @Test
    public void testGetForm() {
        List<Building> expectedBuildings = Arrays.asList(new Building(), new Building());
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());

        when(buildingRepository.findAll()).thenReturn(expectedBuildings);
        when(eventRepository.findAll()).thenReturn(expectedEvents);

        FormDTO result = applicationService.getForm();

        assertEquals(expectedBuildings, result.getBuildings());
        assertEquals(expectedEvents, result.getEvents());
    }

    @Test
    public void testMapDtoToEntity() {
        ApplicationRequestDTO applicationRequestDTO = new ApplicationRequestDTO();
        long userId = 1L;
        Application expectedApplication = Application.builder()
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

        Application result = applicationService.mapDtoToEntity(applicationRequestDTO, userId);

        assertEquals(expectedApplication, result);
    }

    @Test
    public void testGetApplicationById() {
        long id = 1L;
        Application expectedApplication = new Application();

        when(applicationRepository.findById(id)).thenReturn(expectedApplication);

        Application result = applicationService.getApplicationById(id);

        assertEquals(expectedApplication, result);
    }
}