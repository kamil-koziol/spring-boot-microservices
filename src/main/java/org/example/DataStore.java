package org.example;

import org.example.exercise.entity.Exercise;
import org.example.training.entity.Training;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DataStore {
    private List<Training> trainings = new ArrayList<>();
    private List<Exercise> exercises = new ArrayList<>();

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public List<Exercise> getAllExercises() {
        return exercises;
    }

    public Optional<Exercise> getExercise(UUID id) {
        return exercises.stream()
                .filter(character -> character.getId().equals(id))
                .findFirst();
    }

    public void addTraining(Training training) {
        trainings.add(training);
    }

    public Optional<Training> getTraining(UUID id) {
        return trainings.stream()
                .filter(profession -> profession.getId().equals(id))
                .findFirst();
    }

    public List<Training> getAllTrainings() {
        return trainings;
    }

    public void serialize(String filename) {
        try {
            var fileOutputStream = new FileOutputStream(filename);
            var objOutputStream = new ObjectOutputStream(fileOutputStream);
            objOutputStream.writeObject(trainings);
            objOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Training> deserialize(String filename) {
       List<Training> trainings = null;
       try
       {
           var fileInputStream = new FileInputStream(filename);
           var objectInputStream = new ObjectInputStream(fileInputStream);

           trainings = (List<Training>) objectInputStream.readObject();

           objectInputStream.close();
           fileInputStream.close();
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }

       return trainings;
    }
}
