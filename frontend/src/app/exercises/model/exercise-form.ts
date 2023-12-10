import { FormControl, FormGroup } from '@angular/forms';

export interface ExerciseForm {
    name: FormControl<string>,
    bodyPart: FormControl<string>,
    difficulty: FormControl<number>,
    description: FormControl<string>,
    training: FormControl<string>
}