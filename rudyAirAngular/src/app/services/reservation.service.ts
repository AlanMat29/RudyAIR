import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reservation } from '../model/compte/reservation';

@Injectable({
  providedIn: 'root',
})
export class ReservationService {
  private static URL = 'http://localhost:8080/rudyair/api/reservation';

  constructor(private httpClient: HttpClient) {}

  private reservationToJson(reservation: Reservation): any {
    const reservationJson = {
      id: reservation.id,
      statut: reservation.statut,
      animaux: reservation.animaux,
      bagage: reservation.bagage,
      siege: reservation.siege,
    };

    if (reservation.passager) {
      Object.assign(reservationJson, {
        passager: {
          id: reservation.passager.id,
          nom: reservation.passager.nom,
          prenom: reservation.passager.prenom,
          dateDeNaissance: reservation.passager.dateDeNaissance,
        },
      });
    }

    if (reservation.vol) {
      Object.assign(reservationJson, {
        vol: { id: reservation.vol.id },
      });
    }

    if (reservation.client) {
      Object.assign(reservationJson, {
        client: { id: reservation.client.id },
      });
    }

    return reservationJson;
  }

  public getAll(): Observable<Reservation[]> {
    return this.httpClient.get<Reservation[]>(ReservationService.URL);
  }

  public getById(id: number): Observable<Reservation> {
    return this.httpClient.get<Reservation>(ReservationService.URL + '/' + id);
  }

  public create(reservation: Reservation): Observable<Reservation> {
    return this.httpClient.post<Reservation>(
      ReservationService.URL,
      this.reservationToJson
    );
  }

  public update(id: number): Observable<Reservation> {
    return this.httpClient.put<Reservation>(
      ReservationService.URL + '/' + id,
      this.reservationToJson
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(ReservationService.URL + '/' + id);
  }
}
