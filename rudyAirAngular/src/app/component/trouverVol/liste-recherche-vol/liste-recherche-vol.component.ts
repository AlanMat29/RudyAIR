import { Vol } from './../../../model/vol/vol';
import { VolGeneriqueService } from './../../../services/volGenerique.service';
import { VolService } from './../../../services/vol.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, Input, OnInit, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-liste-recherche-vol',
  templateUrl: './liste-recherche-vol.component.html',
  styleUrls: ['./liste-recherche-vol.component.css'],
})
export class ListeRechercheVolComponent implements OnInit {
  villeDepart: string = '';
  villeArrivee: string = '';
  heureDepart: any;
  heureArrivee: any;
  dateDepart: Date = new Date();
  prixVol: any;

  recherches: Vol[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private volService: VolService,
    private volgenService: VolGeneriqueService
  ) {}

  ngOnInit(): void {
    this.volService
      .getVolByRecherche(this.villeDepart, this.villeArrivee, this.dateDepart)
      .subscribe((results) => {
        this.recherches = results;
      });
  }

  // pagePrecedente() {
  //   this.retour.emit({
  //     vd: this.villeDepart,
  //     va: this.villeArrivee,
  //     dd: this.dateDepart,
  //   });
  // }
}
