import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Ville } from '../model/vol/ville';

@Injectable({
  providedIn: 'root',
})
export class VilleService {
  private static URL = 'http://localhost:8080/rudyair/api/ville';

  constructor(private httpClient: HttpClient) {}

  private villeToJson(ville: Ville): any {
    const villeJson = {
      id: ville.id,
      nom: ville.nom,
      pays: ville.pays,
      cp: ville.cp,
    };
    return villeJson;
  }

  public getAll(): Observable<Ville[]> {
    return this.httpClient.get<Ville[]>(VilleService.URL);
  }

  public getById(id: number): Observable<Ville> {
    return this.httpClient.get<Ville>(`${VilleService.URL}/${id}`);
  }

  public create(ville: Ville): Observable<Ville> {
    return this.httpClient.post<Ville>(
      VilleService.URL,
      this.villeToJson(ville)
    );
  }

  public update(ville: Ville): Observable<Ville> {
    console.log('villeToJson', this.villeToJson(ville));
    return this.httpClient.put<Ville>(
      `${VilleService.URL}/${ville.id}`,
      this.villeToJson(ville)
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${VilleService.URL}/${id}`);
  }
}
