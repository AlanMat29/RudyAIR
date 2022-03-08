import { Client } from './model/compte/client';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTooltipModule } from '@angular/material/tooltip';

import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { DeconnexionComponent } from './component/deconnexion/deconnexion.component';
import { HomeComponent } from './component/home/home.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { ListeRechercheVolComponent } from './component/trouverVol/liste-recherche-vol/liste-recherche-vol.component';
import { InformarionBilletComponent } from './component/trouverVol/informarion-billet/informarion-billet.component';
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
import { ReservationEditComponent } from './component/admin/reservation-edit/reservation-edit.component';
import { ReservationListComponent } from './component/admin/reservation-list/reservation-list.component';
import { MainAdminComponent } from './component/admin/main-admin/main-admin.component';

import { ReservationClientComponent } from './component/client/reservation-client/reservation-client.component';
import { APP_BASE_HREF } from '@angular/common';
import { InformationsClientComponent } from './component/client/informations-client/informations-client.component';
import { AvionListComponent } from './component/admin/avion-list/avion-list.component';
import { AvionEditComponent } from './component/admin/avion-edit/avion-edit.component';

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
    InformarionBilletComponent,
    PayerBilletComponent,
    ReservationBilletComponent,
    EnregistrerReservationComponent,
    ReservationClientComponent,
    InformationsClientComponent,
    ReservationEditComponent,
    ReservationListComponent,
    MainAdminComponent,
    AvionListComponent,
    AvionEditComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTooltipModule,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    { provide: APP_BASE_HREF, useValue: '/' },
  ],

  bootstrap: [AppComponent],
})
export class AppModule {}
