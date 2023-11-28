package org.example.initialize;

import org.example.exercise.entity.BodyPart;
import org.example.exercise.entity.Exercise;
import org.example.exercise.service.api.ExerciseService;
import org.example.training.entity.Training;
import org.example.training.service.api.TrainingService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final ExerciseService exerciseService;
    private final TrainingService trainingService;


    @Autowired
    public InitializeData(ExerciseService exerciseService, TrainingService trainingService) {
        this.exerciseService = exerciseService;
        this.trainingService = trainingService;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Training t1 = Training.builder()
                .id(UUID.fromString("a113d87b-3271-43d4-b8bb-5f00d2d7c78a"))
                .build();

        Training t2 = Training.builder()
                .id(UUID.fromString("b113d87b-3271-43d4-b8bb-5f00d2d7c78a"))
                .build();

        Training t3 = Training.builder()
                .id(UUID.fromString("c113d87b-3271-43d4-b8bb-5f00d2d7c78a"))
                .build();

        trainingService.create(t1);
        trainingService.create(t2);
        trainingService.create(t3);

        Exercise e1 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Flat bench press")
                .training(t1)
                .bodyPart(BodyPart.CHEST)
                .difficulty(5)
                .description("Lay on bench then push the weight")
                .build();

        Exercise e2 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Cable crossover")
                .training(t1)
                .bodyPart(BodyPart.CHEST)
                .difficulty(2)
                .description("Set cables then cross to the chest from up")
                .build();

        Exercise e3 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Triceps Pushback")
                .training(t1)
                .bodyPart(BodyPart.TRICEPS)
                .difficulty(2)
                .description("Get dumbbells and lean forward, then push back the weights")
                .build();

        Exercise e4 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Lateral pulldown")
                .training(t2)
                .bodyPart(BodyPart.LATS)
                .difficulty(5)
                .description("Sit in the machine, pull down the handle so you feel your lats working")
                .build();

        Exercise e5 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Pullup")
                .training(t2)
                .bodyPart(BodyPart.UPPER_BACK)
                .difficulty(10)
                .description("Get to the pullup bar then pull yourself up")
                .build();

        Exercise e6 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Lateral raise on bench")
                .training(t2)
                .bodyPart(BodyPart.DELTOIDS)
                .difficulty(4)
                .description("Chest on bench then pull the weights up")
                .build();

        Exercise e7 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Quad extension")
                .training(t3)
                .bodyPart(BodyPart.LEGS)
                .difficulty(4)
                .description("Sit in the machine then push the weight up")
                .build();

        Exercise e8 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Squats")
                .training(t3)
                .bodyPart(BodyPart.LEGS)
                .difficulty(10)
                .description("Place bar on your back then squat")
                .build();

        Exercise e9 = Exercise.builder()
                .id(UUID.fromString("e813d87b-3271-43d4-b8bb-5f00d2d7c78a"))
                .name("Biceps curls")
                .training(t3)
                .bodyPart(BodyPart.BICEPS)
                .difficulty(2)
                .description("Grab dumbells then pull the weigh up using arms")
                .build();

        exerciseService.create(e1);
        exerciseService.create(e2);
        exerciseService.create(e3);
        exerciseService.create(e4);
        exerciseService.create(e5);
        exerciseService.create(e6);
        exerciseService.create(e7);
        exerciseService.create(e8);
        exerciseService.create(e9);
    }
}
