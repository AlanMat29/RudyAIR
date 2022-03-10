import { CompteService } from 'src/app/services/compte.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './services/auth.service';
import { Client } from './model/compte/client';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'rudyAirAngular';

  getUserType() {
    if (localStorage.getItem('typeCompte') == 'admin') {
      return 'admin';
    }
    return 'client';
  }
}
