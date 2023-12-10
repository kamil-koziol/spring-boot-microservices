import { Component, OnInit, inject } from '@angular/core';
import { TrainingsService } from '../../service/trainings.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Training } from '../../model/training';
import { CommonModule } from '@angular/common';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ExercisesService } from '../../../exercises/services/exercises.service';
import { Exercises } from '../../../exercises/model/exercises';
import { TrainingForm } from '../../model/training-form';

@Component({
  selector: 'app-training-detail',
  standalone: true,
  imports: [CommonModule, RouterLink, ReactiveFormsModule],
  templateUrl: './training-detail.component.html',
})
export class TrainingDetailComponent implements OnInit {
  service = inject(TrainingsService);
  exerciseService = inject(ExercisesService);
  route = inject(ActivatedRoute);
  router = inject(Router);

  training: Training | undefined;
  exercises: Exercises | undefined;

  trainigForm: FormGroup<TrainingForm> | undefined;

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      let id: string = params['id'];

      this.service.getTraining(id)
      .subscribe((training: Training) => {
        this.training = training;

        this.trainigForm = new FormGroup<TrainingForm>({
          name: new FormControl(training.name, {nonNullable: true}),
        });
      });

      this.exerciseService.getTrainingsExercises(id).subscribe((exercises: Exercises) => {
        this.exercises = exercises;
      });
      
    });
  }

  deleteExercise(id: string) {
    this.exerciseService.deleteExercise(id);
    this.exercises!.exercises = this.exercises!.exercises.filter((item) => item.id !== id);
  }

  handleSubmit(event: Event) {
    event.preventDefault();
    this.service.updateTraining(this.training!.id, this.trainigForm!.value["name"]).subscribe(a => {
      console.log(a);
    });
  }
}
