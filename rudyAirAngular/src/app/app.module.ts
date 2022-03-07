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
import { HeaderAdminComponent } from './component/admin/header-admin/header-admin.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { ListeRechercheVolComponent } from './component/trouverVol/liste-recherche-vol/liste-recherche-vol.component';
import { InformarionBilletComponent } from './component/trouverVol/informarion-billet/informarion-billet.component';
import { PayerBilletComponent } from './component/trouverVol/payer-billet/payer-billet.component';
import { ReservationBilletComponent } from './component/trouverVol/reservation-billet/reservation-billet.component';
import { EnregistrerReservationComponent } from './component/trouverVol/enregistrer-reservation/enregistrer-reservation.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { routes } from 'src/routes';
import { AuthInterceptor } from './interceptor/auth-interceptor';

@NgModule({
  declarations: [
    AppComponent,
    ReservationComponent,
    HeaderComponent,
    FooterComponent,
    ConnexionComponent,
    DeconnexionComponent,
    HomeComponent,
    HeaderAdminComponent,
    PageNotFoundComponent,
    InscriptionComponent,
    ListeRechercheVolComponent,
    InformarionBilletComponent,
    PayerBilletComponent,
    ReservationBilletComponent,
    EnregistrerReservationComponent,
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
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
