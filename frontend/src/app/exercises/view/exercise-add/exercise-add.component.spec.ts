import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseAddComponent } from './exercise-add.component';

describe('ExerciseAddComponent', () => {
  let component: ExerciseAddComponent;
  let fixture: ComponentFixture<ExerciseAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ExerciseAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ExerciseAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
