import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private baseUrl = 'http://localhost:8080/api/events';

  constructor(private http: HttpClient) {}

  getHeaders() {
    const token = localStorage.getItem('jwt_token');
    return {
      headers: new HttpHeaders().set('Authorization', token || '')
    };
  }

  getEvents() {
    return this.http.get(`${this.baseUrl}`, this.getHeaders());
  }
}
