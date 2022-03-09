import { PaiementBilletComponent } from './component/client/paiement-billet/paiement-billet.component';
import { ReservationPassagerComponent } from './component/client/reservation-passager/reservation-passager.component';
import { HistoriqueComponent } from './component/client/historique/historique.component';
import { InformationsClientComponent } from './component/client/informations-client/informations-client.component';
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
import { ReservationBilletComponent } from './component/client/reservation-billet/reservation-billet.component';

export const routes: Routes = [
  { path: 'accueil', component: HomeComponent },
  { path: 'header', component: HeaderComponent },
  { path: 'footer', component: FooterComponent },
  { path: 'header-admin', component: HeaderComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'deconnexion', component: DeconnexionComponent },
  { path: 'publicite', component: PubliciteComponent },
  { path: 'top-destination', component: TopDestinationComponent },
  { path: 'offres', component: OffresComponent },
  { path: 'carrousel', component: CarrouselComponent },
  //partie trouver vol
  { path: 'recherche-vol', component: RechercheVolComponent },
  { path: 'liste-recherche-vol', component: ListeRechercheVolComponent },
  { path: 'reservation/billet', component: ReservationBilletComponent },
  { path: 'reservation/passager', component: ReservationPassagerComponent },
  { path: 'reservation/paiement', component: PaiementBilletComponent },
  {
    path: 'reservation/enregister',
    component: EnregistrerReservationComponent,
  },
  //partie client
  { path: 'client/historique', component: HistoriqueComponent },
  { path: 'client/information', component: InformationsClientComponent },
  //partie admin
  { path: 'admin/reservation', component: ReservationListComponent },
  { path: 'admin/reservation/edit', component: ReservationEditComponent },
  { path: 'admin/reservation/edit/:id', component: ReservationEditComponent },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
];