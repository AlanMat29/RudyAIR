import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Vol } from '../model/vol/vol';

@Injectable({
  providedIn: 'root',
})
export class VolService {
  private static URL = 'http://localhost:8080/boot/api/vol';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Vol[]> {
    return this.httpClient.get<Vol[]>(VolService.URL);
  }

  public get(id: number): Observable<Vol> {
    return this.httpClient.get<Vol>(`${VolService.URL}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${VolService.URL}/${id}`);
  }

  public create(vol: Vol): Observable<Vol> {
    return this.httpClient.post<Vol>(VolService.URL, this.volToJson(vol));
  }

  public update(vol: Vol): Observable<Vol> {
    console.log(this.volToJson(vol));
    return this.httpClient.put<Vol>(
      `${VolService.URL}/${vol.id}`,
      this.volToJson(vol)
    );
  }

  private volToJson(vol: Vol): any {
    const obj = {
      id: vol.id,
      numeroVol: vol.numeroVol,
      dateDepart: vol.dateDepart,
      dateArrivee: vol.dateArrivee,
      statutVol: vol.statutVol,
    };

    if (vol.volGenerique) {
      Object.assign(obj, { volGenerique: { id: vol.volGenerique.id } });
    }

    if (vol.avion) {
      Object.assign(obj, { avion: { id: vol.avion.id } });
    }

    return obj;
  }
}
