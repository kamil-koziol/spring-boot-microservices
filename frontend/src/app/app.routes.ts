import { Routes } from '@angular/router';
import { TrainingListComponent } from './trainings/view/training-list/training-list.component';
import { ExerciseListComponent } from './exercises/view/exercise-list/exercise-list.component';
import { ExerciseDetailComponent } from './exercises/view/exercise-detail/exercise-detail.component';
import { TrainingDetailComponent } from './trainings/view/training-detail/training-detail.component';
import { ExerciseAddComponent } from './exercises/view/exercise-add/exercise-add.component';
import { TrainingAddComponent } from './trainings/view/training-add/training-add.component';


export const routes: Routes = [
    {"path": "trainings", component: TrainingListComponent},
    {"path": "trainings/:id", component: TrainingDetailComponent},
    {"path": "trainings-add", component: TrainingAddComponent},
    {"path": "exercises", component: ExerciseListComponent},
    {"path": "exercises/:id", component: ExerciseDetailComponent},
    {"path": "exercise-add", component: ExerciseAddComponent},
];
