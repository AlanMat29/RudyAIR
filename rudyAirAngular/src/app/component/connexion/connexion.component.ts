import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { CompteService } from 'src/app/services/compte.service';
import { Client } from 'src/app/model/compte/client';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent implements OnInit {
  form!: FormGroup;
  error = false;
  emailConnexion = '';
  clients: Client[] = [];

  constructor(
    private authService: AuthService,
    private router: Router,
    private compteService: CompteService
  ) {}

  ngOnInit(): void {
    this.listAllClient();
    this.form = new FormGroup({
      login: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  save() {
    this.authService
      .authentication(
        this.form.controls['login'].value,
        this.form.controls['password'].value
      )
      .subscribe({
        next: (ok) => {
          this.error = false;
          localStorage.setItem('login', this.form.controls['login'].value);
          localStorage.setItem(
            'token',
            btoa(
              this.form.controls['login'].value +
                ':' +
                this.form.controls['password'].value
            )
          );
          this.router.navigateByUrl('/accueil');
        },
        error: (error) => {
          this.error = true;
        },
      });
  }

  listAllClient() {
    this.compteService.getAllClient().subscribe((result) => {
      this.clients = result;
    });
  }

  storeCompteType() {
    console.log(this.clients);
    for (let c of this.clients) {
      if (c.email == this.emailConnexion) {
        localStorage.setItem('typeCompte', 'client');
        return 'client';
      }
    }
    localStorage.setItem('typeCompte', 'admin');
    return 'admin';
  }
}
