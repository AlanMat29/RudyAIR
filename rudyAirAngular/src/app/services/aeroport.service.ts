import { HttpClient } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Aeroport } from '../model/vol/aeroport';

@Injectable({
  providedIn: 'root',
})
export class AeroportService {
  private static URL = 'http://localhost:8080/rudyair/api/aeroport';
  constructor(private httpAeroport: HttpClient) {}

  private aeroportToJson(aeroport: Aeroport): any {
    const aeroportJson = {
      id: aeroport.id,
      nom: aeroport.nom,
    };
    if (aeroport.ville) {
      Object.assign(aeroportJson, {
        ville: { id: aeroport.ville.id },
      });
    }
    return aeroportJson;
  }

  public getAll(): Observable<Aeroport[]> {
    return this.httpAeroport.get<Aeroport[]>(AeroportService.URL);
  }

  public getById(id: number): Observable<Aeroport[]> {
    return this.httpAeroport.get<Aeroport[]>(`${AeroportService.URL}/${id}`);
  }

  public create(Aeroport: Aeroport): Observable<Aeroport> {
    return this.httpAeroport.post<Aeroport>(
      AeroportService.URL,
      this.aeroportToJson(Aeroport)
    );
  }

  public update(Aeroport: Aeroport): Observable<Aeroport> {
    console.log(this.aeroportToJson(Aeroport));
    return this.httpAeroport.put<Aeroport>(
      `${AeroportService.URL}/${Aeroport.id}`,
      this.aeroportToJson(Aeroport)
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpAeroport.delete<void>(`${AeroportService.URL}/${id}`);
  }
}
