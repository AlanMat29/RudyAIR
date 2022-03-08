import { HistoriqueComponent } from './component/client/historique/historique.component';
import { ReservationClientComponent } from './component/client/reservation-client/reservation-client.component';
import { InformationsClientComponent } from './component/client/informations-client/informations-client.component';
import { PayerBilletComponent } from './component/client/payer-billet/payer-billet.component';
import { EnregistrerReservationComponent } from './component/client/enregistrer-reservation/enregistrer-reservation.component';
import { CarrouselComponent } from './component/catalogue/carrousel/carrousel.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { PubliciteComponent } from './component/publicite/publicite.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { DeconnexionComponent } from './component/deconnexion/deconnexion.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { Routes } from '@angular/router';
import { TopDestinationComponent } from './component/catalogue/top-destination/top-destination.component';
import { HomeComponent } from './component/home/home.component';
import { OffresComponent } from './component/catalogue/offres/offres.component';
import { RechercheVolComponent } from './component/trouverVol/recherche-vol/recherche-vol.component';
import { ListeRechercheVolComponent } from './component/trouverVol/liste-recherche-vol/liste-recherche-vol.component';
import { ReservationListComponent } from './component/admin/reservation-list/reservation-list.component';
import { ReservationEditComponent } from './component/admin/reservation-edit/reservation-edit.component';
import { ReservationBilletComponent } from './component/trouverVol/reservation-billet/reservation-billet.component';

export const routes: Routes = [
  { path: 'accueil', component: HomeComponent },
  { path: 'header', component: HeaderComponent },
  { path: 'footer', component: FooterComponent },
  { path: 'header-admin', component: HeaderComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'deconnexion', component: DeconnexionComponent },
  { path: 'top-destination', component: TopDestinationComponent },
  { path: 'publicite', component: PubliciteComponent },
  { path: 'offres', component: OffresComponent },
  { path: 'recherche-vol', component: RechercheVolComponent },
  { path: 'liste-recherche-vol', component: ListeRechercheVolComponent },
  { path: 'carrousel', component: CarrouselComponent },
  { path: 'reservation/billet', component: ReservationBilletComponent },
  { path: 'reservation/passager', component: ReservationClientComponent },
  { path: 'reservation/payement', component: PayerBilletComponent },
  {
    path: 'reservation/enregister',
    component: EnregistrerReservationComponent,
  },
  { path: 'client/information', component: InformationsClientComponent },
  { path: 'client/historique', component: HistoriqueComponent },
  { path: 'admin/reservation', component: ReservationListComponent },
  { path: 'admin/reservation/edit', component: ReservationEditComponent },
  { path: 'admin/reservation/edit/:id', component: ReservationEditComponent },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
];
