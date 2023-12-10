import { Pipe, PipeTransform } from '@angular/core';
import { Training } from '../model/training';

@Pipe({
  name: 'filterTrainings',
  standalone: true
})
export class FilterTrainingsPipe implements PipeTransform {

  transform(trainings: Training[], text: string): Training[] {
    return trainings.filter((trainings) => {
      return trainings.name.toLowerCase().includes(text.toLowerCase())
    });
  }

}
