package org.example.training.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PutTrainingRequest {
    String name;
}
