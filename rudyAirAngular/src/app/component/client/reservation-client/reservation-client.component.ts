import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reservation-client',
  templateUrl: './reservation-client.component.html',
  styleUrls: ['./reservation-client.component.css'],
})
export class ReservationClientComponent implements OnInit {
  clientForm!: FormGroup;

  constructor() {}

  ngOnInit(): void {
    this.clientForm = new FormGroup({
      nomCtrl: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.pattern('^[a-zA-Z-]+$'),
      ]),
      prenomCtrl: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.pattern('^[a-zA-Z-]+$'),
      ]),
      emailCtrl: new FormControl('', [
        Validators.required,
        Validators.email,
        Validators.pattern(
          '^(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=\\D*\\d)[A-Za-z\\d!$%@#£€*?&]{8,}$'
        ),
      ]),
      telCtrl: new FormControl('', [
        Validators.required,
        Validators.pattern('^-?(0|[1-9]d*)?$'),
      ]),
      dateCtrl: new FormControl('', Validators.required),
      adresseCtrl: new FormControl('', Validators.required),
      codeCtrl: new FormControl('', [
        Validators.required,
        Validators.maxLength(5),
        Validators.pattern('^-?(0|[1-9]d*)?$'),
      ]),
      villeCtrl: new FormControl('', Validators.required),
    });
  }
}
