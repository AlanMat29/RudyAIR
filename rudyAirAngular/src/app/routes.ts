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
import { AvionListComponent } from './component/admin/avion-list/avion-list.component';
import { AvionEditComponent } from './component/admin/avion-edit/avion-edit.component';
import { AeroportListComponent } from './component/admin/aeroport-list/aeroport-list.component';
import { AeroportEditComponent } from './component/admin/aeroport-edit/aeroport-edit.component';
import { CompteEditComponent } from './component/admin/compte-edit/compte-edit.component';
import { CompteListComponent } from './component/admin/compte-list/compte-list.component';
import { VilleListComponent } from './component/admin/ville-list/ville-list.component';
import { VilleEditComponent } from './component/admin/ville-edit/ville-edit.component';

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
  //  Reservation
  { path: 'admin/reservation', component: ReservationListComponent },
  { path: 'admin/reservation/edit', component: ReservationEditComponent },
  { path: 'admin/reservation/edit/:id', component: ReservationEditComponent },
  //  Avion
  { path: 'admin/avion', component: AvionListComponent },
  { path: 'admin/avion/edit', component: AvionEditComponent },
  { path: 'admin/avion/edit/:id', component: AvionEditComponent },
  //  Compte
  { path: 'admin/compteClient', component: CompteListComponent },
  { path: 'admin/compteClient/edit', component: CompteEditComponent },
  { path: 'admin/compteClient/edit/:id', component: CompteEditComponent },
  //  Aeroport
  { path: 'admin/aeroport', component: AeroportListComponent },
  { path: 'admin/aeroport/edit', component: AeroportEditComponent },
  { path: 'admin/aeroport/edit/:id', component: AeroportEditComponent },
  //  Ville
  { path: 'admin/ville', component: VilleListComponent },
  { path: 'admin/ville/edit', component: VilleEditComponent },
  { path: 'admin/ville/edit/:id', component: VilleEditComponent },

  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
];
