import { Component, OnInit, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { TrainingForm } from '../../model/training-form';
import { TrainingsService } from '../../service/trainings.service';
import { v4 } from 'uuid';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-training-add',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './training-add.component.html',
})
export class TrainingAddComponent implements OnInit {

  service = inject(TrainingsService);
  router = inject(Router);

  trainigForm: FormGroup<TrainingForm> | undefined;
  
  ngOnInit(): void {
    this.trainigForm = new FormGroup<TrainingForm>({
      name: new FormControl("", {nonNullable: true}),
    });
  }

  handleSubmit(event: Event) {
    event.preventDefault();

    let id = v4();
    this.service.putTraining(id, this.trainigForm!.value["name"]!).subscribe((e) => {this.router.navigateByUrl("/trainings/" + id)});
  }

}
