package com.example.SpringSecurity3.service;

import com.example.SpringSecurity3.dto.FieldDTO;
import com.example.SpringSecurity3.dto.RoundDTO;
import com.example.SpringSecurity3.entity.Field;
import com.example.SpringSecurity3.entity.Round;
import com.example.SpringSecurity3.entity.UserRound;
import com.example.SpringSecurity3.repository.FieldRepository;
import com.example.SpringSecurity3.repository.UserRoundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoundService {

    private final FieldRepository fieldRepository;
    private final UserRoundRepository userRoundRepository;
    private final JwtService jwtService;

    public List<FieldDTO> getAllRounds(String authorizationHeader) {
        Long userId = jwtService.extractUserId(authorizationHeader);
        List<Field> fields = fieldRepository.findAll();
        List<UserRound> rounds = userRoundRepository.findAllByUserId(userId);
        return mapToDTO(fields, rounds);
    }

    private List<FieldDTO> mapToDTO(List<Field> fields, List<UserRound> rounds) {
        List<FieldDTO> roundDTOs = new ArrayList<>();

        for (Field field : fields) {
            Set<RoundDTO> roundDTOSet = field.getRounds().stream()
                    .map(round -> {
                        boolean hasRights = rounds.stream()
                                .anyMatch(userRound -> userRound.getRoundId().equals(round.getId()));
                        return new RoundDTO(
                                round.getId(),
                                round.getName(),
                                round.getDate(),
                                round.getStartTime(),
                                round.getEndTime(),
                                hasRights
                        );
                    })
                    .collect(Collectors.toSet());

            roundDTOs.add(new FieldDTO(field.getId(), field.getName(), roundDTOSet));
        }

        return roundDTOs;
    }
}
