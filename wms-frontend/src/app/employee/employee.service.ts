import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map'

import { AuthService } from '../auth/auth.service';
import { Employee } from './employee';

@Injectable()
export class EmployeeService {
    constructor(
        private http: Http,
        private authService: AuthService) {
    }

    getEmployees(): Observable<Employee[]> {
        let headers = new Headers();
        headers.append('Authorization', this.authService.token);
        headers.append('withCredentials', 'true');
        return this.http.get('http://localhost:8080/employees', { headers: headers })
            .map((response: Response) => response.json());
    }
}