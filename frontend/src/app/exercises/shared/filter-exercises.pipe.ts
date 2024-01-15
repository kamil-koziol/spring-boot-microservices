import { Pipe, PipeTransform } from '@angular/core';
import { Exercise } from '../model/exercises';

@Pipe({
  name: 'filterExercises',
  standalone: true
})
export class FilterExercisesPipe implements PipeTransform {

  transform(exercises: Exercise[], text: string): Exercise[] {
    return exercises.filter((exercise) => {
      return exercise.name.toLowerCase().includes(text.toLowerCase())
    });
  }

}
