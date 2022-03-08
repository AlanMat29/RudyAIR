import { InformationsClientComponent } from './app/component/client/informations-client/informations-client.component';

import { Routes } from '@angular/router';
import { ReservationEditComponent } from './app/component/admin/reservation-edit/reservation-edit.component';
import { ReservationListComponent } from './app/component/admin/reservation-list/reservation-list.component';
import { HomeComponent } from './app/component/home/home.component';
import { PageNotFoundComponent } from './app/component/page-not-found/page-not-found.component';

export const routes: Routes = [
  { path: 'accueil', component: HomeComponent },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
  { path: 'client/informations', component: InformationsClientComponent },
  {
    path: '**',
    component: PageNotFoundComponent,
  },
  // Admin routes
  { path: 'admin/reservation', component: ReservationListComponent },
  { path: 'admin/reservation/edit', component: ReservationEditComponent },
  { path: 'admin/reservation/edit/:id', component: ReservationEditComponent },
  { path: '**', component: PageNotFoundComponent },
];
