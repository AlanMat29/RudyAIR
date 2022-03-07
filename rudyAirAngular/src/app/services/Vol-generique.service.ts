import { HttpClient } from '@angular/common/http';
import { VolGenerique } from './../model/Vol-generique/volGenerique';
import { Aeroport } from './../model/Vol-generique/aeroport';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VolGeneriqueService {
  private static URL = 'http://localhost:8888/rudyAir/api/volgen';
  constructor(private httpVolGenerique: HttpClient)  { }

  private volGeneriqueToJson(volGenerique: VolGenerique): any {
    const obj = {
      id: volGenerique.id,
      prix: volGenerique.prix,
      numVolGen: volGenerique.numVolGen,
      horaire: volGenerique.horaire,
      aeroportDepart: volGenerique.aeroportDepart,
      aeroportArrivee: volGenerique.aeroportArrivee,
    };
  }
  public getAll(): Observable<VolGenerique[]> {
    return this.httpVolGenerique.get<VolGenerique[]>(VolGeneriqueService.URL);
  }

  public getById(id: number): Observable<VolGenerique[]> {
    return this.httpVolGenerique.get<VolGenerique[]>(`${VolGeneriqueService.URL}/${id}`);
  }

  public create(VolGenerique: VolGenerique): Observable<VolGenerique> {
    return this.httpVolGenerique.post<VolGenerique>(
      VolGeneriqueService.URL,
      this.volGeneriqueToJson(VolGenerique)
    );
  }

  public update(VolGenerique: VolGenerique): Observable<VolGenerique> {
    console.log(this.volGeneriqueToJson(VolGenerique));
    return this.httpVolGenerique.put<VolGenerique>(
      `${VolGeneriqueService.URL}/${VolGenerique.id}`,
      this.volGeneriqueToJson(VolGenerique)
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpVolGenerique.delete<void>(`${VolGeneriqueService.URL}/${id}`);
  }
}
