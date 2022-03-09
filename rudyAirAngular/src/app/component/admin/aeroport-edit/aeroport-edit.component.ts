import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Aeroport } from 'src/app/model/vol/aeroport';
import { Ville } from 'src/app/model/vol/ville';
import { AeroportService } from 'src/app/services/aeroport.service';
import { VilleService } from 'src/app/services/ville.service';

@Component({
  selector: 'app-aeroport-edit',
  templateUrl: './aeroport-edit.component.html',
  styleUrls: ['./aeroport-edit.component.css'],
})
export class AeroportEditComponent implements OnInit {
  aeroport: Aeroport = new Aeroport();
  villes: Ville[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private aeroportService: AeroportService,
    private router: Router,
    private villeService: VilleService
  ) {
    this.aeroport.ville = new Ville();
  }

  ngOnInit(): void {
    this.listAllVille();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.aeroportService.getById(params['id']).subscribe((result) => {
          this.aeroport = result;
        });
      }
    });
  }

  saveAeroport() {
    if (this.aeroport.ville!.id) {
      this.villeService
        .getById(this.aeroport.ville!.id)
        .subscribe((villeInBase) => {
          this.aeroport.ville = villeInBase;
        });
    }
    if (this.aeroport.id) {
      this.aeroportService.update(this.aeroport).subscribe((ok) => {
        this.goToAeroportList();
      });
    } else {
      this.aeroportService.create(this.aeroport).subscribe((ok) => {
        this.goToAeroportList();
      });
    }
  }

  listAllVille() {
    this.villeService.getAll().subscribe((result) => {
      this.villes = result;
    });
  }

  goToAeroportList() {
    this.router.navigate(['/admin/aeroport']);
  }
}
