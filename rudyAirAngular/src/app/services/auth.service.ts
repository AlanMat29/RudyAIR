import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  public checkEmail(email: string): Observable<boolean> {
    return this.http.get<boolean>(
      'http://localhost:8080/rudyair/api/auth/search/' + email
    );
  }

  public inscription(user: any): Observable<any> {
    return this.http.post(
      'http://localhost:8080/rudyair/api/auth/inscription',
      user
    );
  }

  public authentication(login: string, password: string): Observable<void> {
    let headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(login + ':' + password),
    });
    return this.http.get<void>('http://localhost:8080/rudyair/api/auth', {
      headers: headers,
    });
  }

  public isAuthenticated(): string | null {
    console.log('HEY', localStorage.getItem('token'));
    return localStorage.getItem('token');
  }
}
