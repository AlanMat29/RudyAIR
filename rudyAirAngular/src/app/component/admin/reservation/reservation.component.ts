import { ReservationService } from './../../../services/reservation.service';
import { Component, OnInit } from '@angular/core';
import { PassagerService } from 'src/app/services/passager.service';
import { Reservation } from 'src/app/model/compte/reservation';

@Component({
  selector: 'admin-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css'],
})
export class ReservationComponent implements OnInit {
  constructor(
    private reservationService: ReservationService,
    private passagerService: PassagerService
  ) {}

  reservations: Reservation[] = [];

  ngOnInit(): void {
    this.listReservation();
  }

  listReservation() {
    this.reservationService.getAll().subscribe((result) => {
      this.reservations = result;
    });
  }
}
