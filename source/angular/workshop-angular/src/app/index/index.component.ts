import { Component } from '@angular/core';
import { NavComponent } from '../nav/nav.component';
import { HeaderComponent } from '../header/header.component';
import { HomeComponent } from "../home/home.component";
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-index',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, NavComponent, HomeComponent],
  templateUrl: './index.component.html',
  styleUrl: './index.component.css'
})
export class IndexComponent {

}
