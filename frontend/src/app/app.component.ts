import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterOutlet } from "@angular/router";
import { NavbarComponent } from "./components/navbar/navbar.component";
import { TrainingListComponent } from "./trainings/view/training-list/training-list.component";

@Component({
  selector: "app-root",
  standalone: true,
  imports: [CommonModule, RouterOutlet, NavbarComponent, TrainingListComponent],
  templateUrl: "./app.component.html",
})
export class AppComponent {
  title = "frontend";
}
