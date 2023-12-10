import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink, CommonModule, RouterLinkActive],
  templateUrl: './navbar.component.html',
})
export class NavbarComponent {
  menuItems = [
    {"path": "/", "label": "Home"},
    {"path": "/trainings", "label": "Trainings"},
    {"path": "/exercises", "label": "Exercises"},
  ]
}
