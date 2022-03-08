import { ReservationEditComponent } from './component/admin/reservation-edit/reservation-edit.component';
import { MainAdminComponent } from './component/admin/main-admin/main-admin.component';
import { TopDestinationComponent } from './component/catalogue/top-destination/top-destination.component';
import { OffresComponent } from './component/catalogue/offres/offres.component';
import { RechercheVolComponent } from './component/trouverVol/recherche-vol/recherche-vol.component';
import { Client } from './model/compte/client';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { ReservationComponent } from './component/admin/reservation/reservation.component';

import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { DeconnexionComponent } from './component/deconnexion/deconnexion.component';
import { HomeComponent } from './component/home/home.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { ListeRechercheVolComponent } from './component/trouverVol/liste-recherche-vol/liste-recherche-vol.component';
import { PayerBilletComponent } from './component/trouverVol/payer-billet/payer-billet.component';
import { ReservationBilletComponent } from './component/trouverVol/reservation-billet/reservation-billet.component';
import { EnregistrerReservationComponent } from './component/trouverVol/enregistrer-reservation/enregistrer-reservation.component';
import {
  HttpClientModule,
  HTTP_INTERCEPTORS,
  HttpHeaders,
} from '@angular/common/http';
import { routes } from 'src/routes';
import { AuthInterceptor } from './interceptor/auth-interceptor';
import { PubliciteComponent } from './component/publicite/publicite.component';
import { CarrouselComponent } from './component/catalogue/carrousel/carrousel.component';
import { ReservationListComponent } from './component/admin/reservation-list/reservation-list.component';

import { ReservationClientComponent } from './component/client/reservation-client/reservation-client.component';
import { APP_BASE_HREF } from '@angular/common';
import { InformationsClientComponent } from './component/client/informations-client/informations-client.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ConnexionComponent,
    DeconnexionComponent,
    HomeComponent,
    PageNotFoundComponent,
    InscriptionComponent,
    ListeRechercheVolComponent,
    PayerBilletComponent,
    EnregistrerReservationComponent,
    PubliciteComponent,
    RechercheVolComponent,
    OffresComponent,
    TopDestinationComponent,
    CarrouselComponent,
    MainAdminComponent,
    ReservationClientComponent,
    InformationsClientComponent,
    ReservationEditComponent,
    ReservationListComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    { provide: APP_BASE_HREF, useValue: '/' },
  ],

  bootstrap: [AppComponent],
})
export class AppModule {}
