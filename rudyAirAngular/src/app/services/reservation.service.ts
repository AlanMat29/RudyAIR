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
        vol: {
          id: reservation.vol.id,
          dateDepart: reservation.vol.dateDepart,
          dateArrivee: reservation.vol.dateArrivee,
          statutVol: reservation.vol.statutVol,
          numeroVol: reservation.vol.numeroVol,
          volGenerique: reservation.vol.volGenerique,
          avion: reservation.vol.avion,
        },
      });
    }

    // Double imbrication de classe (Client dans Resa et Adresse dans Client)
    if (reservation.client) {
      const clientJson = {
        id: reservation.client.id,
        nom: reservation.client.nom,
        prenom: reservation.client.prenom,
        dateNaissance: reservation.client.dateNaissance,
        emaild: reservation.client.email,
        abonnement: reservation.client.abonnement,
      };
      if (reservation.client.adresse) {
        Object.assign(clientJson, {
          adresse: {
            numero: reservation.client.adresse.numero,
            voie: reservation.client.adresse.voie,
            cp: reservation.client.adresse.cp,
            pays: reservation.client.adresse.pays,
          },
        });
      }
      Object.assign(reservationJson, clientJson);
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
