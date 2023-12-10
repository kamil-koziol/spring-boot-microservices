import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Trainings } from '../model/trainings';
import { Training } from '../model/training';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class TrainingsService {
  putTraining(id: string, values: any) {
    return this.http.put("/api/trainings/" + id, JSON.stringify(values), httpOptions);
  }
  updateTraining(id: string, values: any) {
    return this.http.patch("/api/trainings/" + id, JSON.stringify(values), httpOptions);
  }

  constructor(private http: HttpClient) { }

  getTrainings(): Observable<Trainings> {
    return this.http.get<Trainings>("/api/trainings", httpOptions);
  }

  getTraining(id: string): Observable<Training> {
    return this.http.get<Training>("/api/trainings/" + id, httpOptions)
  }
  
}
