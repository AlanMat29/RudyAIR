import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Siege } from '../model/vol/siege';

@Injectable({
  providedIn: 'root',
})
export class SiegeService {
  static URL: string = 'http://localhost:8080/rudyair/api/siege';
  constructor(private http: HttpClient) {}

  private siegeToJson(siege: Siege): any {
    const siegeJson = {
      id: siege.id,
      nom: siege.numero,
    };

    //If class avion in siege attributs we create an avionJSON object for siegeJSON
    if (siege.avion) {
      Object.assign(siegeJson, {
        siege: {
          id: siege.avion.id,
          numero: siege.avion.ref,
          statutAvion: siege.avion.statutAvion,
        },
      });
    }
    return siegeJson;
  }

  getAll(): Observable<Siege[]> {
    return this.http.get<Siege[]>(SiegeService.URL);
  }

  getById(id: number): Observable<Siege> {
    return this.http.get<Siege>(SiegeService.URL + '/' + id);
  }

  create(siege: Siege): Observable<Siege> {
    return this.http.post<Siege>(SiegeService.URL, this.siegeToJson(siege));
  }

  update(siege: Siege): Observable<Siege> {
    return this.http.put<Siege>(SiegeService.URL + '/' + siege.id, siege);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(SiegeService.URL + '/' + id);
  }
}
