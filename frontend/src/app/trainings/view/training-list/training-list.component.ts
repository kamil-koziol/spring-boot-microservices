import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Trainings } from '../../model/trainings';
import { TrainingsService } from '../../service/trainings.service';
import { Observable } from 'rxjs';
import { RouterLink } from '@angular/router';
import { SearchbarComponent } from '@components/searchbar/searchbar.component';
import { FilterTrainingsPipe } from '../../shared/filter-trainings.pipe';


@Component({
  selector: 'app-training-list',
  standalone: true,
  imports: [CommonModule, RouterLink, SearchbarComponent, FilterTrainingsPipe],
  templateUrl: './training-list.component.html',
})
export class TrainingListComponent implements OnInit {
  constructor(private service: TrainingsService) {}

  filterText: string = "";

  trainings!: Observable<Trainings>;
  
  public ngOnInit(): void {
    this.trainings = this.service.getTrainings();
  }
}
