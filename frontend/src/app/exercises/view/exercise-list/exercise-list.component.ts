import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Exercises } from '../../model/exercises';
import { ExercisesService } from '../../services/exercises.service';
import { Observable } from 'rxjs';
import { TrainingsService } from '../../../trainings/service/trainings.service';
import { Trainings } from '../../../trainings/model/trainings';
import { FilterExercisesPipe } from '../../shared/filter-exercises.pipe';
import { FormsModule } from '@angular/forms';
import { SearchbarComponent } from "../../../components/searchbar/searchbar.component";
import { DropdownComponent } from "../../../components/dropdown/dropdown.component";

@Component({
    selector: 'app-exercise-list',
    standalone: true,
    templateUrl: './exercise-list.component.html',
    imports: [RouterLink, CommonModule, FilterExercisesPipe, FormsModule, SearchbarComponent, DropdownComponent]
})
export class ExerciseListComponent implements OnInit {
  exercises!: Exercises;
  trainings!: Trainings;
  trainingsIdToNameMap: Map<string, string> = new Map<string, string>();
  filterText: string = "";


  constructor(private service: ExercisesService, private trainingsService: TrainingsService) {}

  ngOnInit(): void {
    this.service.getExercises().subscribe((exercises) => {
      this.exercises = exercises;
    });
    this.trainingsService.getTrainings().subscribe((trainings) => {
      this.trainings = trainings;
      trainings.trainings.forEach((training) => {
        this.trainingsIdToNameMap.set(training.id, training.name);
      })
    });
  }

  deleteExercise(id: string) {
    this.service.deleteExercise(id);
    this.exercises.exercises = this.exercises.exercises.filter((item) => item.id !== id);
  }

  setAllCheckboxes(event: Event) {
    const clickedCheckbox = event.target as HTMLInputElement;

    document.querySelectorAll<HTMLInputElement>('input[type=checkbox]').forEach((checkbox) => {
      if(checkbox === clickedCheckbox) {return;}

      checkbox.checked = clickedCheckbox.checked;
    })
  }
}
