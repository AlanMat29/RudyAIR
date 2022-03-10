import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  constructor(private authService: AuthService, private router: Router) {}
  ngOnInit(): void {}

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('/acceuil');
  }

  get authenticated() {
    return this.authService.isAuthenticated();
  }

  get login() {
    return localStorage.getItem('connexion');
  }
}
