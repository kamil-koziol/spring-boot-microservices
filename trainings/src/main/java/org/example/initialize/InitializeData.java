package org.example.initialize;

import org.example.training.entity.Training;
import org.example.training.service.api.TrainingService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final TrainingService trainingService;


    @Autowired
    public InitializeData(TrainingService trainingService) {
        this.trainingService = trainingService;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Training t1 = Training.builder()
                .id(UUID.fromString("a113d87b-3271-43d4-b8bb-5f00d2d7c78a"))
                .name("Chest + Triceps")
                .build();

        Training t2 = Training.builder()
                .id(UUID.fromString("b113d87b-3271-43d4-b8bb-5f00d2d7c78a"))
                .name("Delts + Back")
                .build();

        Training t3 = Training.builder()
                .id(UUID.fromString("c113d87b-3271-43d4-b8bb-5f00d2d7c78a"))
                .name("Legs + Biceps + Abs")
                .build();

        trainingService.create(t1);
        trainingService.create(t2);
        trainingService.create(t3);
    }
}
