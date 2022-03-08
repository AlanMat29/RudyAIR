import { VolService } from './../../../services/vol.service';
import { Reservation } from 'src/app/model/compte/reservation';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationService } from 'src/app/services/reservation.service';
import { Passager } from 'src/app/model/compte/passager';
import { Vol } from 'src/app/model/vol/vol';
import { Client } from 'src/app/model/compte/client';
import { CompteService } from 'src/app/services/compte.service';
import { PassagerService } from 'src/app/services/passager.service';

@Component({
  selector: 'app-reservation-edit',
  templateUrl: './reservation-edit.component.html',
  styleUrls: ['./reservation-edit.component.css'],
})
export class ReservationEditComponent implements OnInit {
  reservation: Reservation = new Reservation();
  currentDate: Date = new Date();
  // Vol Service
  vols: Vol[] = [];
  // Client
  clients: Client[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private reservationService: ReservationService,
    private router: Router,
    //Passager Service
    private passagerService: PassagerService,
    //Vol Service
    private volService: VolService,
    //Client Service
    private compteService: CompteService
  ) {
    // Instancie des objets nécessaires dans Reservation
    this.reservation.passager = new Passager();
    this.reservation.vol = new Vol();
    this.reservation.client = new Client();
    //Assign default value
    this.reservation.animaux = 0;
    this.reservation.bagage = 0;
    this.reservation.statut = true;
  }

  ngOnInit(): void {
    // On vient chercher la reservation en base si on a un id
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.reservationService.getById(params['id']).subscribe((result) => {
          this.reservation = result;
        });
      }
    });
    this.volService.getAll().subscribe((result) => {
      this.vols = result;
    });
    this.compteService.getAllClient().subscribe((result) => {
      this.clients = result;
    });
  }

  getAllVols() {
    return this.volService.getAll();
  }
  getAllClients() {
    return this.volService.getAll();
  }

  saveReservation() {
    console.log('heyyyy', this.reservation);
    if (this.reservation.id) {
      //creation requete put
      //Update passager before Reservation

      this.passagerService
        .update(this.reservation.passager!)
        .subscribe((newPassager) => {
          this.reservation.passager = newPassager;
          this.reservationService.update(this.reservation).subscribe((ok) => {
            this.goToReservationList();
          });
        });
    } else {
      //update requete put
      //Save passager before Reservation
      this.passagerService
        .create(this.reservation.passager!)
        .subscribe((newPassager) => {
          this.reservation.passager!.id = newPassager.id;
          this.reservationService.create(this.reservation).subscribe((ok) => {
            this.goToReservationList();
          });
        });
    }
  }

  goToReservationList() {
    this.router.navigate(['/admin/reservation']);
  }
}
