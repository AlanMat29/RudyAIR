import { Client } from './../model/compte/client';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  private clientToJson(client: Client): any {
    const clientJson = {
      id: client.id,
      nom: client.nom,
      prenom: client.prenom,
      dateNaissance: client.dateNaissance,
      email: client.email,
      password: client.password,
      abonnement: client.abonnement,
    };
    if (client.adresse) {
      Object.assign(clientJson, {
        adresse: {
          pays: client.adresse.pays,
          ville: client.adresse.ville,
          cp: client.adresse.cp,
          voie: client.adresse.voie,
          numero: client.adresse.numero,
        },
      });
    }
    return clientJson;
  }

  public getAll(): Observable<Compte[]> {
    return this.httpClient.get<Compte[]>(CompteService.URL);
  }

  public getById(id: number): Observable<Compte> {
    return this.httpClient.get<Compte>(`${CompteService.URL}/${id}`);
  }

  public create(compte: Compte): Observable<Compte> {
    let httpHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.post<Compte>(
      CompteService.URL,
      this.compteToJson(compte),
      { headers: httpHeader }
    );
  }

  public update(compte: Compte): Observable<Compte> {
    let httpHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.put<Compte>(
      `${CompteService.URL}/${compte.id}`,
      this.compteToJson(compte),
      { headers: httpHeader }
    );
  }

  //CLIENT
  public createClient(client: Client): Observable<Client> {
    let httpHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.post<Client>(
      CompteService.URL + '/createClient',
      this.clientToJson(client),
      { headers: httpHeader }
    );
  }

  public updateClient(client: Client): Observable<Client> {
    let httpHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.put<Client>(
      CompteService.URL + '/updateClient/' + client.id,
      this.clientToJson(client),
      { headers: httpHeader }
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${CompteService.URL}/${id}`);
  }

  public getAllClient(): Observable<Client[]> {
    return this.httpClient.get<Client[]>(CompteService.URL + '/client');
  }

  public getClientById(id: number): Observable<Client> {
    return this.httpClient.get<Client>(CompteService.URL + '/client/' + id);
  }
}
