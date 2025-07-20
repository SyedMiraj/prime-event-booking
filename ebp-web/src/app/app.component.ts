import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  get isLoggedIn(): boolean {
    return localStorage.getItem('jwt_token') !== null;
  }

  logout(): void {
    localStorage.removeItem('jwt_token');
    window.location.href = '/login'; 
    }
}