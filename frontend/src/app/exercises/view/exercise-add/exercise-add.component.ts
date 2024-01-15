import { Component, OnInit, inject } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Training } from '../../../trainings/model/training';
import { TrainingsService } from '../../../trainings/service/trainings.service';
import { ExerciseForm } from '../../model/exercise-form';
import { Exercise } from '../../model/exercises';
import { ExercisesService } from '../../services/exercises.service';
import { Trainings } from '../../../trainings/model/trainings';
import { CommonModule } from '@angular/common';
import { BodyPart } from '../../model/exercise';

@Component({
  selector: 'app-exercise-add',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './exercise-add.component.html',
})
export class ExerciseAddComponent implements OnInit {
  service = inject(ExercisesService);
  trainingsService = inject(TrainingsService);
  router = inject(Router);
  params = inject(ActivatedRoute);

  trainings: Trainings | undefined;
  exerciseForm: FormGroup<ExerciseForm> | undefined;
  bodyParts: string[] | undefined;

  ngOnInit(): void {
    this.trainingsService.getTrainings().subscribe((t) => {
      const trainingId: string | null = this.params.snapshot.queryParamMap.get('training');

      this.trainings = t;

      this.bodyParts= Object.keys(BodyPart).filter(k => typeof BodyPart[k as any] === "number");

      this.exerciseForm = new FormGroup<ExerciseForm>({
        name: new FormControl('', { nonNullable: true }),
        bodyPart: new FormControl(this.bodyParts[0], { nonNullable: true }),
        difficulty: new FormControl(0, { nonNullable: true }),
        description: new FormControl('', {
          nonNullable: true,
        }),
        training: new FormControl(trainingId ? trainingId: t.trainings[0].id, { nonNullable: true }),
      });
    });
  }

  handleSubmit(event: Event) {
    event.preventDefault();
    this.service.addExercise(this.exerciseForm!.value).subscribe((e: any) => {
      this.router.navigateByUrl('/exercises/' + e.id);
    });
  }
}
