import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/model/compte/reservation';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css'],
})
export class ReservationListComponent implements OnInit {
  constructor(private reservationService: ReservationService) {}

  reservations: Reservation[] = [];

  ngOnInit(): void {
    this.listAllResa();
  }

  listAllResa() {
    this.reservationService.getAllSortedById().subscribe((result) => {
      this.reservations = result;
    });
  }

  deleteResaById(id: number) {
    this.reservationService.deleteById(id).subscribe((ok) => {
      this.listAllResa();
    });
  }
}
