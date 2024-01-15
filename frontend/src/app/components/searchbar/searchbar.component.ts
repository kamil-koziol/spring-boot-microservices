import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-searchbar',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './searchbar.component.html',
})
export class SearchbarComponent {

  @Input() searchText: string = "";
  @Input() placeholder: string = "";

  @Output() searchTextChange = new EventEmitter<string>();
}
