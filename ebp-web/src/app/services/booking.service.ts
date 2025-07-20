import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private baseUrl = 'http://localhost:8080/api/bookings';

  constructor(private http: HttpClient) {}

  getHeaders() {
    const token = localStorage.getItem('jwt_token');
    return {
      headers: new HttpHeaders().set('Authorization', token || '')
    };
  }

  bookEvent(eventId: string) {
    return this.http.post(`${this.baseUrl}`, { eventId }, this.getHeaders())
  }

  getEvents() {
    return this.http.get(`${this.baseUrl}`, this.getHeaders());
  }
}
