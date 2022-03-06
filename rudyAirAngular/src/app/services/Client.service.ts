import { Observable } from 'rxjs';
import { Client } from '../model/compte/client';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  private static URL = 'http://localhost:8888/rudyAir/api/client';

  constructor(private httpClient: HttpClient) {}

  private clientToJson(client: Client): any {
    const obj = {
      id: client.id,
      nom: client.nom,
      prenom: client.prenom,
      dateNaissance: client.dateNaissance,
      email: client.email,
      password: client.password,
      adresse: client.adresse,
      abonnement: client.abonnement,
    };
  }

  public getAll(): Observable<Client[]> {
    return this.httpClient.get<Client[]>(ClientService.URL);
  }

  public getById(id: number): Observable<Client[]> {
    return this.httpClient.get<Client[]>(`${ClientService.URL}/${id}`);
  }

  public create(client: Client): Observable<Client> {
    return this.httpClient.post<Client>(
      ClientService.URL,
      this.clientToJson(client)
    );
  }

  public update(client: Client): Observable<Client> {
    console.log(this.clientToJson(client));
    return this.httpClient.put<Client>(
      `${ClientService.URL}/${client.id}`,
      this.clientToJson(client)
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ClientService.URL}/${id}`);
  }
}
