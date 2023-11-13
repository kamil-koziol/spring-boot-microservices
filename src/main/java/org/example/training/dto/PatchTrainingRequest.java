package org.example.training.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PatchTrainingRequest {
    String name;
    String additionalInfo;
}