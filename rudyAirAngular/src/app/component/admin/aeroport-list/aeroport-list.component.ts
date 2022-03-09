import { Aeroport } from './../../../model/vol/aeroport';
import { Component, OnInit } from '@angular/core';
import { AeroportService } from 'src/app/services/aeroport.service';
import { VolGenerique } from 'src/app/model/vol/volGenerique';
import { VolGeneriqueService } from 'src/app/services/volGenerique.service';

@Component({
  selector: 'app-aeroport-list',
  templateUrl: './aeroport-list.component.html',
  styleUrls: ['./aeroport-list.component.css'],
})
export class AeroportListComponent implements OnInit {
  aeroports: Aeroport[] = [];
  volGeneriques: VolGenerique[] = [];

  constructor(
    private aeroportService: AeroportService,
    private volGenService: VolGeneriqueService
  ) {}

  ngOnInit(): void {
    this.listAllAeroport();
    this.listAllVolGen();
  }

  listAllAeroport() {
    this.aeroportService.getAll().subscribe((result) => {
      this.aeroports = result;
    });
  }

  deleteAeroportById(id: number) {
    this.aeroportService.deleteById(id).subscribe((ok) => {
      this.listAllAeroport();
    });
  }

  listAllVolGen() {
    this.volGenService.getAll().subscribe((result) => {
      this.volGeneriques = result;
    });
  }
  canBeDelete(id: number) {
    for (let vg in this.volGeneriques) {
      if (
        this.volGeneriques[vg].aeroportDepart!!.id == id ||
        this.volGeneriques[vg].aeroportArrivee!.id == id
      ) {
        return false;
      }
    }
    return true;
  }
}
