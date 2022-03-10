import { CarrouselComponent } from './component/catalogue/carrousel/carrousel.component';
import { TopDestinationComponent } from './component/catalogue/top-destination/top-destination.component';
import { ReservationEditComponent } from './component/admin/reservation-edit/reservation-edit.component';
import { MainAdminComponent } from './component/admin/main-admin/main-admin.component';
import { OffresComponent } from './component/catalogue/offres/offres.component';
import { RechercheVolComponent } from './component/trouverVol/recherche-vol/recherche-vol.component';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { DeconnexionComponent } from './component/deconnexion/deconnexion.component';
import { HomeComponent } from './component/home/home.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { ListeRechercheVolComponent } from './component/trouverVol/liste-recherche-vol/liste-recherche-vol.component';
import {
  HttpClientModule,
  HTTP_INTERCEPTORS,
  HttpHeaders,
} from '@angular/common/http';
import { AuthInterceptor } from './interceptor/auth-interceptor';
import { PubliciteComponent } from './component/publicite/publicite.component';
import { ReservationListComponent } from './component/admin/reservation-list/reservation-list.component';
import { APP_BASE_HREF } from '@angular/common';
import { InformationsClientComponent } from './component/client/informations-client/informations-client.component';
import { ReservationPassagerComponent } from './component/client/reservation-passager/reservation-passager.component';
import { PaiementBilletComponent } from './component/client/paiement-billet/paiement-billet.component';
import { AvionListComponent } from './component/admin/avion-list/avion-list.component';
import { AvionEditComponent } from './component/admin/avion-edit/avion-edit.component';
import { routes } from './routes';
import { FooterAdminComponent } from './component/admin/footer-admin/footer-admin.component';
import { ReservationBilletComponent } from './component/client/reservation-billet/reservation-billet.component';
import { HistoriqueComponent } from './component/client/historique/historique.component';
import { EnregistrerReservationComponent } from './component/client/enregistrer-reservation/enregistrer-reservation.component';
import { CompteListComponent } from './component/admin/compte-list/compte-list.component';
import { CompteEditComponent } from './component/admin/compte-edit/compte-edit.component';
import { AeroportListComponent } from './component/admin/aeroport-list/aeroport-list.component';
import { AeroportEditComponent } from './component/admin/aeroport-edit/aeroport-edit.component';
import { VilleListComponent } from './component/admin/ville-list/ville-list.component';
import { VilleEditComponent } from './component/admin/ville-edit/ville-edit.component';
import { VolGeneriqueListComponent } from './component/admin/vol-generique-list/vol-generique-list.component';
import { VolGeneriqueEditComponent } from './component/admin/vol-generique-edit/vol-generique-edit.component';
import { VolListComponent } from './component/admin/vol-list/vol-list.component';
import { VolEditComponent } from './component/admin/vol-edit/vol-edit.component';
import { VolDuJourComponent } from './component/vol-du-jour/vol-du-jour.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    InscriptionComponent,
    ConnexionComponent,
    DeconnexionComponent,
    PageNotFoundComponent,
    TopDestinationComponent,
    CarrouselComponent,
    OffresComponent,
    PubliciteComponent,
    //partie trouver vol
    RechercheVolComponent,
    ListeRechercheVolComponent,
    ReservationBilletComponent,
    ReservationPassagerComponent,
    PaiementBilletComponent,
    EnregistrerReservationComponent,
    //partie admin
    HistoriqueComponent,
    InformationsClientComponent,
    //partie admin
    MainAdminComponent,
    ReservationEditComponent,
    ReservationListComponent,
    FooterAdminComponent,
    AvionListComponent,
    AvionEditComponent,
    ReservationPassagerComponent,
    PaiementBilletComponent,
    CompteListComponent,
    CompteEditComponent,
    AeroportListComponent,
    AeroportEditComponent,
    VilleListComponent,
    VilleEditComponent,
    VolGeneriqueListComponent,
    VolGeneriqueEditComponent,
    VolListComponent,
    VolEditComponent,
    VolDuJourComponent,
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
