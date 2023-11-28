package org.example.training.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class GetTrainingsResponse {

    @Data
    @AllArgsConstructor
    public static class Training {
        UUID id;
        String name;
    }

    @Singular
    List<Training> trainings;

    public static GetTrainingsResponse fromTrainings(List<org.example.training.entity.Training> trainings) {
        var response = GetTrainingsResponse.builder();

        trainings.forEach(training -> {
            response.training(new Training(training.getId(), training.getName()));
        });

        return response.build();
    }
}
