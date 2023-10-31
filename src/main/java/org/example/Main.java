package org.example;

import org.example.exercise.dto.ExerciseDto;
import org.example.exercise.entity.BodyPart;
import org.example.exercise.entity.Exercise;
import org.example.exercise.service.ExerciseService;
import org.example.exercise.service.DefaultExerciseService;
import org.example.training.entity.Training;
import org.example.training.service.DefaultTrainingService;
import org.example.training.service.TrainingService;

import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Initialization

        DataStore dataStore = new DataStore();
        ExerciseService exerciseService = new DefaultExerciseService(dataStore);
        TrainingService trainingService = new DefaultTrainingService(dataStore);


        // Creation of objects

        Training t1 = Training.builder()
                .id(UUID.randomUUID())
                .name("Chest + Triceps")
                .exercises(new ArrayList<>())
                .build();

        Training t2 = Training.builder()
                .id(UUID.randomUUID())
                .name("Delts + Back")
                .exercises(new ArrayList<>())
                .build();

        Training t3 = Training.builder()
                .id(UUID.randomUUID())
                .name("Legs + Biceps + Abs")
                .exercises(new ArrayList<>())
                .build();


        Exercise e1 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Flat bench press")
                .training(t1)
                .bodyPart(BodyPart.CHEST)
                .difficulty(5)
                .description("Lay on bench then push the weight")
                .build();

        t1.getExercises().add(e1);

        Exercise e2 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Cable crossover")
                .training(t1)
                .bodyPart(BodyPart.CHEST)
                .difficulty(2)
                .description("Set cables then cross to the chest from up")
                .build();

        t1.getExercises().add(e2);

        Exercise e3 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Triceps Pushback")
                .training(t1)
                .bodyPart(BodyPart.TRICEPS)
                .difficulty(2)
                .description("Get dumbbells and lean forward, then push back the weights")
                .build();

        t1.getExercises().add(e3);

        Exercise e4 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Lateral pulldown")
                .training(t1)
                .bodyPart(BodyPart.LATS)
                .difficulty(5)
                .description("Sit in the machine, pull down the handle so you feel your lats working")
                .build();

        t2.getExercises().add(e4);

        Exercise e5 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Pullup")
                .training(t1)
                .bodyPart(BodyPart.UPPER_BACK)
                .difficulty(10)
                .description("Get to the pullup bar then pull yourself up")
                .build();

        t2.getExercises().add(e5);

        Exercise e6 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Lateral raise on bench")
                .training(t1)
                .bodyPart(BodyPart.DELTOIDS)
                .difficulty(4)
                .description("Chest on bench then pull the weights up")
                .build();

        t2.getExercises().add(e6);

        Exercise e7 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Quad extension")
                .training(t1)
                .bodyPart(BodyPart.LEGS)
                .difficulty(4)
                .description("Sit in the machine then push the weight up")
                .build();

        t3.getExercises().add(e7);

        Exercise e8 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Squats")
                .training(t1)
                .bodyPart(BodyPart.LEGS)
                .difficulty(10)
                .description("Place bar on your back then squat")
                .build();

        t3.getExercises().add(e8);

        Exercise e9 = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Biceps curls")
                .training(t1)
                .bodyPart(BodyPart.BICEPS)
                .difficulty(2)
                .description("Grab dumbells then pull the weigh up using arms")
                .build();

        t3.getExercises().add(e9);

        trainingService.addTraining(t1);
        trainingService.addTraining(t2);
        trainingService.addTraining(t3);

        exerciseService.addExercise(e1);
        exerciseService.addExercise(e2);
        exerciseService.addExercise(e3);
        exerciseService.addExercise(e4);
        exerciseService.addExercise(e5);
        exerciseService.addExercise(e6);
        exerciseService.addExercise(e7);
        exerciseService.addExercise(e8);
        exerciseService.addExercise(e9);
/*
        trainingService.getAll().forEach(training -> {
            System.out.println("Training:" + training.getName());
            training.getExercises().forEach(character -> {
                System.out.println("Exercise:" + character.getName());
            });
        });
*/

        // Zad 3.

        System.out.println("Zadanie 3. ");
        Set<Exercise> exerciseSet = exerciseService.getAll().stream().collect(Collectors.toSet());
        exerciseSet.forEach(exercise -> {
            System.out.println(exercise.getName());
        });

        // Zad 4.
        System.out.println("Zadanie 4. ");

        exerciseSet.stream()
                .filter(exercise -> exercise.getDifficulty() <= 3)
                .sorted()
                .forEach(character -> {
                    System.out.println(character.getName() + " " + character.getDifficulty());
                });

        // Zad 5.

        System.out.println("Zadanie 5. ");
        exerciseSet.stream().map(exercise -> {
            return ExerciseDto.builder()
                    .id(exercise.getId())
                    .name(exercise.getName())
                    .training(exercise.getTraining().getName())
                    .build();
        })
                .sorted((l, r) -> l.hashCode() - r.hashCode())
                .collect(Collectors.toList())
                .forEach(machineDto -> System.out.println(machineDto.toString()));



        // Zad 6.

        System.out.println("Zadanie 6. ");
        String filename = "blabla";
        dataStore.serialize(filename);
        dataStore.deserialize(filename).forEach(training -> {
            System.out.println(training);
        });

        // Zad 7.

        System.out.println("Zadanie 7. ");
        ForkJoinPool pool = new ForkJoinPool(2);
        trainingService.getAll().parallelStream().forEach(training -> {
            pool.execute(() -> {
                System.out.println("Started for " + training.getName() + " " + training.getExercises().size());
                training.getExercises().forEach(exercise -> {
                    try {
                        Thread.sleep(1000); // Sleep for 1 second
                        System.out.println("  Exercise: " + exercise + " Training: " + training.getName());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
                System.out.println("Ended for " + training.getName());
            });
        });

        pool.awaitQuiescence(10, TimeUnit.SECONDS);
        pool.shutdown();

    }
}