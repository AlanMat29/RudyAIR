import { Compte } from './../../../model/compte/compte';
import { CompteService } from './../../../services/compte.service';
import { Client } from './../../../model/compte/client';
import { ClientService } from './../../../services/client.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Adresse } from 'src/app/model/compte/adresse';

@Component({
  selector: 'app-informations-client',
  templateUrl: './informations-client.component.html',
  styleUrls: ['./informations-client.component.css'],
})
export class InformationsClientComponent implements OnInit {
  infosForm!: FormGroup;
  clients: Compte[] = [];
  client: Client = new Client();
  compte: Compte = new Compte();

  constructor(
    private router: Router,
    private clientService: ClientService,
    private activatedRoute: ActivatedRoute,
    private compteService: CompteService
  ) {
    this.client.adresse = new Adresse();
  }

  ngOnInit(): void {
    this.infosForm = new FormGroup({
      nomCtrl: new FormControl(this.client.nom, [
        Validators.required,
        Validators.minLength(2),
        Validators.pattern('^[a-zA-Z-]+$'),
      ]),
      prenomCtrl: new FormControl(this.client.prenom, [
        Validators.required,
        Validators.minLength(2),
        Validators.pattern('^[a-zA-Z-]+$'),
      ]),
      emailCtrl: new FormControl(this.client.email, [
        Validators.required,
        Validators.email,
        Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,3}$'),
      ]),
      telCtrl: new FormControl('', [
        Validators.required,
        Validators.maxLength(20),
        Validators.pattern('^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-s./0-9]*$'),
      ]),
      dateCtrl: new FormControl(this.client.dateNaissance, Validators.required),
      voieCtrl: new FormControl(this.client.adresse, Validators.required),
      adresseCtrl: new FormControl(this.client.adresse, Validators.required),
      codeCtrl: new FormControl(this.client.adresse, [
        Validators.required,
        Validators.maxLength(20),
        Validators.pattern('^[a-zA-Z-]*[0-9]+$'),
      ]),
      villeCtrl: new FormControl('', Validators.required),
      passwordCtrl: new FormControl(this.client.password, [
        Validators.required,
        Validators.pattern(
          '^(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=\\D*\\d)[A-Za-z\\d!$%@#£€*?&]{8,}$'
        ),
      ]),
    });

    this.activatedRoute.params.subscribe((compte) => {
      if (compte['id']) {
        this.compteService.getClientById(compte['id']).subscribe((result) => {
          this.compte = result;
        });
      }
    });
    this.compteService.getAll().subscribe((result) => {
      this.clients = result;
    });
  }

  save() {
    if (this.client.id) {
      this.compteService.update(this.client).subscribe((ok) => {
        this.router.navigate(['/client/informations']);
      });
    } else {
      this.compteService.create(this.client).subscribe((ok) => {
        this.router.navigate(['/client/informations']);
      });
    }
  }
}
