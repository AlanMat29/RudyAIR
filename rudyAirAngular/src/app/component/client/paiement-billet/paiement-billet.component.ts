import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-paiement-billet',
  templateUrl: './paiement-billet.component.html',
  styleUrls: ['./paiement-billet.component.css'],
})
export class PaiementBilletComponent implements OnInit {
  paiementForm!: FormGroup;

  constructor() {}

  ngOnInit(): void {
    this.paiementForm = new FormGroup({
      numeroCtrl: new FormControl('', [
        Validators.required,
        Validators.minLength(16),
        Validators.maxLength(16),
        Validators.pattern('^[a-zA-Z-]*[0-9]+$'),
      ]),
      carteCtrl: new FormControl('', Validators.required),
      titulaireCtrl: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.pattern('^[A-Za-z]+((\\s)?([A-Za-z])+)*$'),
      ]),
      expirationCrtl: new FormControl('', Validators.required),
      cvvCtrl: new FormControl('', [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(3),
        Validators.pattern('^[a-zA-Z-]*[0-9]+$'),
      ]),
    });
  }
  payer() {
    console.log(this.paiementForm);
  }
}
