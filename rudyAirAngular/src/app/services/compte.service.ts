import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Compte } from '../model/compte/compte';

@Injectable({
  providedIn: 'root',
})
export class CompteService {
  private static URL = 'http://localhost:8080/rudyair/api/compte';

  constructor(private httpClient: HttpClient) {}

  private compteToJson(compte: Compte): any {
    const compteJson = {
      id: compte.id,
      nom: compte.nom,
      prenom: compte.prenom,
      dateNaissance: compte.dateNaissance,
      email: compte.email,
      password: compte.password,
    };
    return compteJson;
  }

  public getAll(): Observable<Compte[]> {
    return this.httpClient.get<Compte[]>(CompteService.URL);
  }

  public getById(id: number): Observable<Compte[]> {
    return this.httpClient.get<Compte[]>(`${CompteService.URL}/${id}`);
  }

  public create(compte: Compte): Observable<Compte> {
    return this.httpClient.post<Compte>(
      CompteService.URL,
      this.compteToJson(compte)
    );
  }

  public update(compte: Compte): Observable<Compte> {
    return this.httpClient.put<Compte>(
      `${CompteService.URL}/${compte.id}`,
      this.compteToJson(compte)
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${CompteService.URL}/${id}`);
  }
}
