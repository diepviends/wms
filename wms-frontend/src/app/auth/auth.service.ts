import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthService {
  public token: string;
  constructor(private http: Http) {
    this.token = localStorage.getItem('userToken');
  }
  login(username: string, password: string): Observable<boolean> {
    return this.http.post(`http://localhost:8080/login`, JSON.stringify({ username: username, password: password }))
      .map((response: Response) => {
        let token = response.headers.get('Authorization');
        if (token) {
          this.token = token;
          localStorage.setItem('userToken', token);
          return true;
        }
        else return false;
      })
  }

  logout(): void {
    this.token = null;
    localStorage.removeItem("userToken");
  }

}
