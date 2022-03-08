import { Client } from './../../../model/compte/client';
import { ClientService } from './../../../services/client.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

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
        Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,3}$'),
      ]),
      telCtrl: new FormControl('', [
        Validators.required,
        Validators.maxLength(20),
        Validators.pattern('^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-s./0-9]*$'),
      ]),
      dateCtrl: new FormControl('', Validators.required),
      voieCtrl: new FormControl('', Validators.required),
      adresseCtrl: new FormControl('', Validators.required),
      codeCtrl: new FormControl('', [
        Validators.required,
        Validators.maxLength(20),
        Validators.pattern('^[a-zA-Z-]*[0-9]+$'),
      ]),
      villeCtrl: new FormControl('', [
        Validators.required,
        Validators.pattern(
          '^(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=\\D*\\d)[A-Za-z\\d!$%@#£€*?&]{8,}$'
        ),
      ]),
    });
  }

  submit() {
    console.log(this.clientForm);
  }
}
