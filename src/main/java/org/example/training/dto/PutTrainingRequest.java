package org.example.training.dto;

import lombok.Builder;
import lombok.Data;
import org.example.exercise.entity.BodyPart;

import java.util.UUID;

@Builder
@Data
public class PutTrainingRequest {
    String name;
    String additionalInfo;
}
