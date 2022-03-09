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
        ville: {
          id: aeroport.ville.id,
          pays: aeroport.ville.pays,
          nom: aeroport.ville.nom,
          cp: aeroport.ville.cp,
        },
      });
    }
    return aeroportJson;
  }

  public getAll(): Observable<Aeroport[]> {
    return this.httpAeroport.get<Aeroport[]>(AeroportService.URL);
  }

  public getById(id: number): Observable<Aeroport> {
    return this.httpAeroport.get<Aeroport>(`${AeroportService.URL}/${id}`);
  }

  public create(aeroport: Aeroport): Observable<Aeroport> {
    return this.httpAeroport.post<Aeroport>(
      AeroportService.URL,
      this.aeroportToJson(aeroport)
    );
  }

  public update(aeroport: Aeroport): Observable<Aeroport> {
    return this.httpAeroport.put<Aeroport>(
      AeroportService.URL + '/' + aeroport.id,
      this.aeroportToJson(aeroport)
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpAeroport.delete<void>(`${AeroportService.URL}/${id}`);
  }
}
