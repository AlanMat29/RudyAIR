import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Avion } from '../model/vol/avion';

@Injectable({
  providedIn: 'root',
})
export class AvionService {
  static URL: string = 'http://localhost:8080/rudyair/api/avion';

  constructor(private httpClient: HttpClient) {}

  private avionToJson(avion: Avion): any {
    const avionJson = {
      id: avion.id,
      ref: avion.ref,
      statutAvion: avion.statutAvion,
    };
    return avionJson;
  }
  public getAll(): Observable<Avion[]> {
    return this.httpClient.get<Avion[]>(AvionService.URL);
  }

  public getById(id: number): Observable<Avion> {
    return this.httpClient.get<Avion>(`${AvionService.URL}/${id}`);
  }

  public create(avion: Avion): Observable<Avion> {
    return this.httpClient.post<Avion>(
      AvionService.URL,
      this.avionToJson(avion)
    );
  }

  public update(avion: Avion): Observable<Avion> {
    console.log(this.avionToJson(avion));
    return this.httpClient.put<Avion>(
      `${AvionService.URL}/${avion.id}`,
      this.avionToJson(avion)
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${AvionService.URL}/${id}`);
  }
}
