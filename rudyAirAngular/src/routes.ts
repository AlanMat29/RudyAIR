import { InformationsClientComponent } from './app/component/client/informations-client/informations-client.component';

import { Routes } from '@angular/router';
import { ReservationEditComponent } from './app/component/admin/reservation-edit/reservation-edit.component';
import { ReservationListComponent } from './app/component/admin/reservation-list/reservation-list.component';
import { HomeComponent } from './app/component/home/home.component';
import { PageNotFoundComponent } from './app/component/page-not-found/page-not-found.component';
import { AvionListComponent } from './app/component/admin/avion-list/avion-list.component';
import { AvionEditComponent } from './app/component/admin/avion-edit/avion-edit.component';

export const routes: Routes = [
  { path: 'accueil', component: HomeComponent },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
  { path: 'client/informations', component: InformationsClientComponent },
  // Admin routes
  //  Reservation
  { path: 'admin/reservation', component: ReservationListComponent },
  { path: 'admin/reservation/edit', component: ReservationEditComponent },
  { path: 'admin/reservation/edit/:id', component: ReservationEditComponent },
  //  Avion
  { path: 'admin/avion', component: AvionListComponent },
  { path: 'admin/avion/edit', component: AvionEditComponent },
  { path: 'admin/avion/edit/:id', component: AvionEditComponent },

  //Other
  { path: '**', component: PageNotFoundComponent },
];
