import { HttpClient, HttpHeaders } from '@angular/common/http';
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
    if (reservation.passager?.id) {
      Object.assign(reservationJson, {
        passager: { id: reservation.passager.id },
      });
    }
    if (reservation.vol) {
      Object.assign(reservationJson, { vol: { id: reservation.vol.id } });
    }
    if (reservation.client) {
      Object.assign(reservationJson, { client: { id: reservation.client.id } });
    }
    return reservationJson;
  }

  public getAll(): Observable<Reservation[]> {
    return this.httpClient.get<Reservation[]>(ReservationService.URL);
  }

  public getAllSortedById(): Observable<Reservation[]> {
    return this.httpClient.get<Reservation[]>(
      ReservationService.URL + '/sortedByIdDesc'
    );
  }

  public getById(id: number): Observable<Reservation> {
    return this.httpClient.get<Reservation>(ReservationService.URL + '/' + id);
  }

  public create(reservation: Reservation): Observable<Reservation> {
    let httpHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.post<Reservation>(
      ReservationService.URL,
      this.reservationToJson(reservation),
      { headers: httpHeader }
    );
  }

  public update(reservation: Reservation): Observable<Reservation> {
    let httpHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.put<Reservation>(
      ReservationService.URL + '/' + reservation.id,
      this.reservationToJson(reservation),
      { headers: httpHeader }
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(ReservationService.URL + '/' + id);
  }
}
