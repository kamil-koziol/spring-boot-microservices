package org.example.training.dto;

import lombok.Builder;
import lombok.Data;
import org.example.training.entity.Training;

import java.util.UUID;

@Data
@Builder
public class GetTrainingResponse {

    UUID id;
    String name;

    public static GetTrainingResponse fromTraining(Training training) {
        var response = GetTrainingResponse.builder();

        response.id(training.getId());
        response.name(training.getName());

        return response.build();
    }
}
