import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { VolGenerique } from '../model/vol/volGenerique';

@Injectable({
  providedIn: 'root',
})
export class VolGeneriqueService {
  private static URL = 'http://localhost:8080/rudyair/api/volgen';
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
        aeroportArrivee: {
          id: volGenerique.aeroportArrivee.id,
          nom: volGenerique.aeroportArrivee.nom,
          ville: volGenerique.aeroportArrivee.ville,
        },
      });
    }
    if (volGenerique.aeroportDepart) {
      Object.assign(volGeneriqueJson, {
        aeroportDepart: {
          id: volGenerique.aeroportDepart.id,
          nom: volGenerique.aeroportDepart.nom,
          ville: volGenerique.aeroportDepart.ville,
        },
      });
    }
    return volGeneriqueJson;
  }

  public getAll(): Observable<VolGenerique[]> {
    return this.httpClient.get<VolGenerique[]>(VolGeneriqueService.URL);
  }

  public getById(id: number): Observable<VolGenerique> {
    return this.httpClient.get<VolGenerique>(
      `${VolGeneriqueService.URL}/${id}`
    );
  }

  public create(volGenerique: VolGenerique): Observable<VolGenerique> {
    return this.httpClient.post<VolGenerique>(
      VolGeneriqueService.URL,
      this.volGeneriqueToJson(volGenerique)
    );
  }

  public update(volGenerique: VolGenerique): Observable<VolGenerique> {
    return this.httpClient.put<VolGenerique>(
      `${VolGeneriqueService.URL}/${volGenerique.id}`,
      this.volGeneriqueToJson(volGenerique)
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${VolGeneriqueService.URL}/${id}`);
  }
}
