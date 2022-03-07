import { Routes } from '@angular/router';
import { HomeComponent } from './app/component/home/home.component';
import { PageNotFoundComponent } from './app/component/page-not-found/page-not-found.component';

export const routes: Routes = [
  { path: 'acceuil', component: HomeComponent },
  { path: '', redirectTo: 'acceuil', pathMatch: 'full' },
  {
    path: '**',
    component: PageNotFoundComponent,
  },
];
