import { Vol } from './../../../model/vol/vol';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { VolService } from './../../../services/vol.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recherche-vol',
  templateUrl: './recherche-vol.component.html',
  styleUrls: ['./recherche-vol.component.css'],
})
export class RechercheVolComponent implements OnInit {
  rechercheForm!: FormGroup;

  vols: Vol[] = [];
  // vols: Vol[] = [];

  villeDepart: any;
  villeArrivee: any;
  dateDepart: any;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private volService: VolService
  ) {}

  ngOnInit(): void {
    this.rechercheForm = new FormGroup({
      departCtrl: new FormControl('', [
        Validators.minLength(1),
        Validators.pattern('^[a-zA-Z-]+$'),
      ]),
      arriveeCtrl: new FormControl('', [
        Validators.minLength(1),
        Validators.pattern('^[a-zA-Z-]+$'),
      ]),
    });

    // localStorage.setItem('villeDepart', JSON.stringify(this.villeDepart));
    // // localStorage.setItem('villeArrivee', this.villeArrivee);
    // // localStorage.setItem('dateDepart', this.dateDepart);

    // this.villeDepart = JSON.parse(localStorage.getItem('villeDepart'));

    this.activatedRoute.params.subscribe((recherches) => {
      console.log('fuck' + recherches);
      this.volService.getVolByRecherche(
        this.villeDepart,
        this.villeArrivee,
        this.dateDepart
      );
    });
  }

  rechercher() {
    if (this.villeDepart) {
      this.volService
        .getVolByAeroportDepart(this.villeDepart)
        .subscribe((recherches) => {
          console.log(recherches);
          this.goList();
        });
    } //if(this.villeArrivee){
    //   this.volService.getVolByAeroportArrivee(this.villeArrivee).subscribe(recherches) => {
    //     this.goList();
    //   }
    // };if(this.dateDepart) {
    //   this.volService.getVolByDateDepart(this.dateDepart).subscribe(recherches) => {
    //     this.goList();
    //   }

    console.log(this.rechercheForm);
  }
  goList() {
    this.router.navigate(['/liste-recherche-vol']);
  }
}
