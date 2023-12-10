import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Exercises } from '../model/exercises';
import { Observable } from 'rxjs';
import { Exercise } from '../model/exercise';
import { v4 as uuidv4 } from 'uuid';

@Injectable({
  providedIn: 'root'
})
export class ExercisesService {
  addExercise(fields: Partial<{ name: string; bodyPart: string; difficulty: number; description: string; training: string; }>) {
    let id = uuidv4();
    return this.http.put("/api/exercises/" + id, fields);
  }

  constructor(private http: HttpClient) { }

  getExercises(): Observable<Exercises> {
    return this.http.get<Exercises>('/api/exercises');
  }

  getExercise(id: string): Observable<Exercise> {
    return this.http.get<Exercise>('/api/exercises/' + id);
  }

  deleteExercise(id: string)  {
    this.http.delete('/api/exercises/' + id).subscribe();
  }

  getTrainingsExercises(id: string): Observable<Exercises> {
    return this.http.get<Exercises>('/api/trainings/' + id + '/exercises');
  }

  updateExercise(id: string, fields: Partial<{ name: string; difficulty: number; description: string; }>) {
    return this.http.patch("/api/exercises/" + id, fields);
  }
}
