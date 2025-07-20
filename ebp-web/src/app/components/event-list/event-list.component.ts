import { Component, OnInit } from '@angular/core';
import { EventService } from '../../services/event.service';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { BookingService } from '../../services/booking.service';

@Component({
  selector: 'app-event-list',
  imports: [CommonModule],
  templateUrl: './event-list.component.html',
  styleUrl: './event-list.component.css'
})
export class EventListComponent implements OnInit {
  
  events: any[] = [];
  bookings: any[] = [];
  bookedEventIds: number[] = [];
  eventsBaseUrl = 'http://localhost:8080/api/events'; 
  bookingBaseUrl = 'http://localhost:8080/api/bookings'; 
  message = '';

  constructor(private eventService: EventService, private bookingService: BookingService, private http: HttpClient) {}

  ngOnInit(): void {
    this.eventService.getEvents().subscribe(data => this.events = data as any[]);
    this.bookingService.getBookedEvents().subscribe(bookings => {
      this.bookings = bookings;
    this.bookedEventIds = bookings.map(b => b.id); 
  });
  }

  bookEvent(event: any): void {
    const token = localStorage.getItem('jwt_token');
    if (!token) {
      alert('You must be logged in!');
      return;
    }

    const payload = { eventId: event.id };

    this.http.post(`${this.bookingBaseUrl}`, payload, {
      headers: {
        Authorization: token,
        'Content-Type': 'application/json'
      }
    }).subscribe({
      next: () => alert(`✅ Event "${event.name}" booked!`),
      error: () => alert(`❌ Failed to book event: "${event.name}"`)
    });
  }
}
