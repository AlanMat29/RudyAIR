import { HttpClient } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Aeroport } from '../model/Vol-generique/aeroport';

@Injectable({
  providedIn: 'root'
})
export class AeroportService {
  private static URL = 'http://localhost:8888/rudyAir/api/aeroport';
  constructor(private httpAeroport: HttpClient) { }

  private aeroportToJson(aeroport: Aeroport): any {
    const obj = {
      id: aeroport.id,
      nom: aeroport.nom,
      ville: aeroport.ville,

      };
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
