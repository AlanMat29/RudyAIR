import { Passager } from './../model/compte/passager';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PassagerService {
  private static URL = 'http://localhost:8080/rudyair/api/passager';

  constructor(private httpClient: HttpClient) {}

  private passagerToJson(passager: Passager): any {
    const passagerJson = {
      id: passager.id,
      nom: passager.nom,
      prenom: passager.prenom,
      dateDeNaissance: passager.dateDeNaissance,
    };
    return passagerJson;
  }

  public getAll(): Observable<Passager[]> {
    return this.httpClient.get<Passager[]>(PassagerService.URL);
  }

  public getById(id: number): Observable<Passager> {
    return this.httpClient.get<Passager>(PassagerService.URL + '/' + id);
  }

  public getAllWithReservation(id: number): Observable<Passager[]> {
    return this.httpClient.get<Passager[]>(
      PassagerService.URL + '/reservation'
    );
  }

  public create(passager: Passager): Observable<Passager> {
    let httpHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.post<Passager>(
      PassagerService.URL,
      this.passagerToJson(passager),
      { headers: httpHeader }
    );
  }

  public update(passager: Passager): Observable<Passager> {
    let httpHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.put<Passager>(
      PassagerService.URL + '/' + passager.id,
      this.passagerToJson(passager),
      { headers: httpHeader }
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(PassagerService.URL + '/' + id);
  }
}
