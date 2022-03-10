import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Avion } from 'src/app/model/vol/avion';
import { StatutVol } from 'src/app/model/vol/statutVol';
import { Vol } from 'src/app/model/vol/vol';
import { VolGenerique } from 'src/app/model/vol/volGenerique';
import { AvionService } from 'src/app/services/avion.service';
import { VolService } from 'src/app/services/vol.service';
import { VolGeneriqueService } from 'src/app/services/volGenerique.service';

@Component({
  selector: 'app-vol-edit',
  templateUrl: './vol-edit.component.html',
  styleUrls: ['./vol-edit.component.css'],
})
export class VolEditComponent implements OnInit {
  vol: Vol = new Vol();
  volGeneriques: VolGenerique[] = [];
  avions: Avion[] = [];
  currentDate: Date = new Date();
  statutVol = StatutVol;

  constructor(
    private activatedRoute: ActivatedRoute,
    private volService: VolService,
    private router: Router,
    private avionService: AvionService,
    private volGeneriqueService: VolGeneriqueService
  ) {
    this.vol.volGenerique = new VolGenerique();
    this.vol.avion = new Avion();
    this.vol.dateDepart = new Date();
    this.vol.dateArrivee = new Date();
    this.vol.statutVol = StatutVol.onTime;
  }

  ngOnInit(): void {
    this.listAllAvion();
    this.listAllVolGenerique();

    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.volService.getById(params['id']).subscribe((result) => {
          this.vol = result;
        });
      }
    });
  }

  saveVol() {
    if (this.vol.id) {
      this.volService.update(this.vol).subscribe((ok) => {
        this.goToVolList();
      });
    } else {
      this.volService.create(this.vol).subscribe((ok) => {
        this.goToVolList();
      });
    }
  }

  goToVolList() {
    this.router.navigate(['/admin/vol']);
  }

  listAllAvion() {
    this.avionService.getAll().subscribe((result) => {
      this.avions = result;
    });
  }

  listAllVolGenerique() {
    this.volGeneriqueService.getAll().subscribe((result) => {
      this.volGeneriques = result;
    });
  }
}
