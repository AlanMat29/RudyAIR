import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Aeroport } from 'src/app/model/vol/aeroport';
import { Horaire } from 'src/app/model/vol/horaire';
import { VolGenerique } from 'src/app/model/vol/volGenerique';
import { AeroportService } from 'src/app/services/aeroport.service';
import { VolGeneriqueService } from 'src/app/services/volGenerique.service';

@Component({
  selector: 'app-vol-generique-edit',
  templateUrl: './vol-generique-edit.component.html',
  styleUrls: ['./vol-generique-edit.component.css'],
})
export class VolGeneriqueEditComponent implements OnInit {
  volGenerique: VolGenerique = new VolGenerique();
  aeroports: Aeroport[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private volGeneriqueService: VolGeneriqueService,
    private router: Router,
    private aeroportService: AeroportService
  ) {
    this.volGenerique.horaire = new Horaire(new Date(), new Date());
    this.volGenerique.aeroportArrivee = new Aeroport();
    this.volGenerique.aeroportDepart = new Aeroport();
  }

  ngOnInit(): void {
    this.listAllAeroport();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.volGeneriqueService.getById(params['id']).subscribe((result) => {
          this.volGenerique = result;
        });
      }
    });
  }

  saveVolGenerique() {
    if (this.volGenerique.id) {
      this.volGeneriqueService.update(this.volGenerique).subscribe((ok) => {
        this.goToVolGeneriqueList();
      });
    } else {
      this.volGeneriqueService.create(this.volGenerique).subscribe((ok) => {
        this.goToVolGeneriqueList();
      });
    }
  }

  goToVolGeneriqueList() {
    this.router.navigate(['/admin/volGenerique']);
  }

  listAllAeroport() {
    this.aeroportService.getAll().subscribe((result) => {
      this.aeroports = result;
    });
  }
}
