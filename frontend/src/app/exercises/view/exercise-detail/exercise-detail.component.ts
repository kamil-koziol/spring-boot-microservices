import { Component, OnInit, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExercisesService } from '../../services/exercises.service';
import { TrainingsService } from '../../../trainings/service/trainings.service';
import { Trainings } from '../../../trainings/model/trainings';
import { Exercise } from '../../model/exercise';
import { ExerciseForm } from '../../model/exercise-form';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import e from 'express';
import { Training } from '../../../trainings/model/training';

@Component({
  selector: 'app-exercise-detail',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './exercise-detail.component.html',
})
export class ExerciseDetailComponent implements OnInit {

  service = inject(ExercisesService);
  trainingsService = inject(TrainingsService);
  route = inject(ActivatedRoute);
  router = inject(Router);

  training: Training | undefined;
  exercise: Exercise | undefined;
  exerciseForm: FormGroup<ExerciseForm> | undefined;
  editToggle: boolean = false;

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      let id = params['id'];

      this.service.getExercise(id).subscribe((exercise) => {
        this.exercise = exercise;

        this.trainingsService.getTraining(exercise.training.id).subscribe((t) => {
          this.training = t;
        });

        this.exerciseForm = new FormGroup<ExerciseForm>({
          name: new FormControl(exercise.name, { nonNullable: true }),
          bodyPart: new FormControl(exercise.bodyPart.toString(), { nonNullable: true }),
          difficulty: new FormControl(exercise.difficulty, {
            nonNullable: true,
          }),
          description: new FormControl(exercise.description, {
            nonNullable: true,
          }),
          training: new FormControl("", { nonNullable: true }),
        });

        this.exerciseForm.disable();
      });
    });
  }

  handleSubmit(event: Event) {
    event.preventDefault();
    this.service.updateExercise(this.exercise!.id, this.exerciseForm!.value).subscribe((e) => {this.leaveEditMode();})
  }

  enterEditMode() {
    this.editToggle = true;
    this.exerciseForm!.enable();
  }

  leaveEditMode() {
    this.editToggle = false;
    this.exerciseForm!.disable();
  }

}
