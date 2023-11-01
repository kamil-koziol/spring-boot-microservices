package org.example.cmd;

import org.example.exercise.dto.PutExerciseRequest;
import org.example.exercise.entity.BodyPart;
import org.example.exercise.entity.Exercise;
import org.example.exercise.service.api.ExerciseService;
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

    public final TrainingService trainingService;
    public final ExerciseService exerciseService;
    @Autowired
    public CommandApplication(TrainingService trainingService, ExerciseService exerciseService) {
        this.trainingService = trainingService;
        this.exerciseService = exerciseService;
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
                    trainingService.getAll().forEach(training -> {
                        System.out.println(training);
                    });
                }
                case "get_exercises" -> {
                    exerciseService.getAll().forEach(exercise -> {
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

                    Optional<Training> training = trainingService.findById(request.getTraining());
                    Exercise exercise = new Exercise().builder()
                            .id(uuid)
                            .name(request.getName())
                            .description(request.getDescription())
                            .bodyPart(request.getBodyPart())
                            .training(training.get())
                            .difficulty(request.getDifficulty())
                            .build();


                    exerciseService.create(exercise);
                }
                case "delete_exercise" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    exerciseService.deleteById(uuid);
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
