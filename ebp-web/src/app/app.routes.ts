import { Routes } from '@angular/router';
import { EventListComponent } from './components/event-list/event-list.component';
import { LoginComponent } from './components/login/login.component';
import { MyBookingsComponent } from './components/my-bookings/my-bookings.component';

export const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'events', component: EventListComponent },
    { path: 'my-bookings', component: MyBookingsComponent },
    { path: '**', redirectTo: 'login' }
];
