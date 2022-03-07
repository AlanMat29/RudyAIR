import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from '../model/compte/admin';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  private static URL = 'http://localhost:8888/rudyAir/api/admin';

  constructor(private httpClient: HttpClient) {}

  private adminToJson(admin: Admin): any {
    const adminJson = {
      id: admin.id,
      nom: admin.nom,
      prenom: admin.prenom,
      dateNaissance: admin.dateNaissance,
      email: admin.email,
      password: admin.password,
    };
    return adminJson;
  }

  public getAll(): Observable<Admin[]> {
    return this.httpClient.get<Admin[]>(AdminService.URL);
  }

  public getById(id: number): Observable<Admin[]> {
    return this.httpClient.get<Admin[]>(`${AdminService.URL}/${id}`);
  }

  public create(admin: Admin): Observable<Admin> {
    return this.httpClient.post<Admin>(
      AdminService.URL,
      this.adminToJson(admin)
    );
  }

  public update(admin: Admin): Observable<Admin> {
    console.log(this.adminToJson(admin));
    return this.httpClient.put<Admin>(
      `${AdminService.URL}/${admin.id}`,
      this.adminToJson(admin)
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${AdminService.URL}/${id}`);
  }
}
