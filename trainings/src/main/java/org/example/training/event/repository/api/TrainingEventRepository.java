package org.example.training.event.repository.api;
import org.example.training.entity.Training;

import java.util.UUID;

public interface TrainingEventRepository {
    void delete(UUID id);

    void create(Training training);
}
