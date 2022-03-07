import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Ville } from '../model/vol/ville';

@Injectable({
  providedIn: 'root',
})
export class VilleService {
  private static URL = 'http://localhost:8080/boot/api/ville';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Ville[]> {
    return this.httpClient.get<Ville[]>(VilleService.URL);
  }

  public get(id: number): Observable<Ville> {
    return this.httpClient.get<Ville>(`${VilleService.URL}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${VilleService.URL}/${id}`);
  }

  public create(ville: Ville): Observable<Ville> {
    return this.httpClient.post<Ville>(
      VilleService.URL,
      this.villeToJson(ville)
    );
  }

  public update(ville: Ville): Observable<Ville> {
    console.log(this.villeToJson(ville));
    return this.httpClient.put<Ville>(
      `${VilleService.URL}/${ville.id}`,
      this.villeToJson(ville)
    );
  }

  private villeToJson(ville: Ville): any {
    const obj = {
      id: ville.id,
      nom: ville.nom,
      pays: ville.pays,
      cp: ville.cp,
    };

    return obj;
  }
}
