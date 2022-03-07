import { HttpClient } from '@angular/common/http';
import { Aeroport } from '../model/vol/aeroport';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { VolGenerique } from '../model/vol/volGeneriques';

@Injectable({
  providedIn: 'root',
})
export class VolGeneriqueService {
  private static URL = 'http://localhost:8888/rudyAir/api/volgen';
  constructor(private httpClient: HttpClient) {}

  private volGeneriqueToJson(volGenerique: VolGenerique): any {
    const volGeneriqueJson = {
      id: volGenerique.id,
      prix: volGenerique.prix,
      numVolGen: volGenerique.numVolGen,
    };

    if (volGenerique.horaire) {
      Object.assign(volGeneriqueJson, {
        horaire: {
          heureDepart: volGenerique.horaire.heureDepart,
          heureArrivee: volGenerique.horaire.heureArrivee,
        },
      });
    }
    if (volGenerique.aeroportArrivee) {
      Object.assign(volGeneriqueJson, {
        aeroportDepart: { id: volGenerique.aeroportArrivee.id },
      });
    }
    if (volGenerique.aeroportDepart) {
      Object.assign(volGeneriqueJson, {
        aeroportDepart: { id: volGenerique.aeroportDepart.id },
      });
    }
    return volGeneriqueJson;
  }

  public getAll(): Observable<VolGenerique[]> {
    return this.httpClient.get<VolGenerique[]>(VolGeneriqueService.URL);
  }

  public getById(id: number): Observable<VolGenerique[]> {
    return this.httpClient.get<VolGenerique[]>(
      `${VolGeneriqueService.URL}/${id}`
    );
  }

  public create(VolGenerique: VolGenerique): Observable<VolGenerique> {
    return this.httpClient.post<VolGenerique>(
      VolGeneriqueService.URL,
      this.volGeneriqueToJson(VolGenerique)
    );
  }

  public update(VolGenerique: VolGenerique): Observable<VolGenerique> {
    return this.httpClient.put<VolGenerique>(
      `${VolGeneriqueService.URL}/${VolGenerique.id}`,
      this.volGeneriqueToJson(VolGenerique)
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${VolGeneriqueService.URL}/${id}`);
  }
}
