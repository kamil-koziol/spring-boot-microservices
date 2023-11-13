package org.example.cmd;

import org.example.exercise.controller.api.ExerciseController;
import org.example.exercise.dto.PatchExerciseRequest;
import org.example.exercise.dto.PutExerciseRequest;
import org.example.exercise.entity.BodyPart;
import org.example.exercise.entity.Exercise;
import org.example.exercise.service.api.ExerciseService;
import org.example.training.controller.api.TrainingController;
import org.example.training.entity.Training;
import org.example.training.service.api.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Component
public class CommandApplication implements CommandLineRunner {
    private final ExerciseController exerciseController;
    private final TrainingController trainingController;

    @Autowired
    public CommandApplication(ExerciseController exerciseController, TrainingController trainingController) {
        this.exerciseController = exerciseController;
        this.trainingController = trainingController;
    }
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            command = scanner.next();
            switch (command) {
                case "get_trainings" -> {
                    trainingController.getTrainings().getTrainings().forEach(training -> {
                        System.out.println(training);
                    });
                }
                case "get_training" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    System.out.println(trainingController.getTraining(uuid));
                }
                case "get_exercises" -> {
                    exerciseController.getExercises().getExercises().forEach(exercise -> {
                        System.out.println(exercise);
                    });
                }
                case "put_exercise" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    PutExerciseRequest request = PutExerciseRequest.builder()
                            .name(scanner.next())
                            .bodyPart(BodyPart.valueOf(scanner.next()))
                            .difficulty(scanner.nextInt())
                            .description(scanner.next())
                            .training(UUID.fromString(scanner.next()))
                            .build();

                    exerciseController.putExercise(uuid, request);
                }

                case "patch_exercise" -> {
                    UUID id = UUID.fromString(scanner.next());

                    PatchExerciseRequest request = PatchExerciseRequest.builder()
                            .name(scanner.next())
                            .description(scanner.next())
                            .difficulty(scanner.nextInt())
                            .build();

                    exerciseController.patchExercise(id, request);
                }
                case "delete_exercise" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    exerciseController.deleteExercise(uuid);
                }
                case "quit" -> {
                    break main_loop;
                }
                case "help" -> {
                    String[] commands = new String[] {
                            "get_trainings",
                            "get_exercises",
                            "put_exercise",
                            "delete_exercise",
                            "quit",
                            "help"
                    };

                    Arrays.stream(commands).forEach(cmd -> {
                        System.out.println(cmd);
                    });
                }
            }
        }

    }
}
