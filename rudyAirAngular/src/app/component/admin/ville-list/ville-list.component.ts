import { Component, OnInit } from '@angular/core';
import { Aeroport } from 'src/app/model/vol/aeroport';
import { Ville } from 'src/app/model/vol/ville';
import { AeroportService } from 'src/app/services/aeroport.service';
import { VilleService } from 'src/app/services/ville.service';

@Component({
  selector: 'app-ville-list',
  templateUrl: './ville-list.component.html',
  styleUrls: ['./ville-list.component.css'],
})
export class VilleListComponent implements OnInit {
  villes: Ville[] = [];
  aeroport: Aeroport[] = [];

  constructor(
    private villeService: VilleService,
    private aeroportService: AeroportService
  ) {}

  ngOnInit(): void {
    this.listAllVille();
    this.listAllAeroport();
  }

  listAllVille() {
    this.villeService.getAll().subscribe((result) => {
      this.villes = result;
    });
  }

  deleteVilleById(id: number) {
    this.villeService.deleteById(id).subscribe((ok) => {
      this.listAllVille();
    });
  }

  listAllAeroport() {
    this.aeroportService.getAll().subscribe((result) => {
      this.aeroport = result;
    });
  }

  canBeDelete(id: number) {
    for (let a in this.aeroport) {
      if (this.aeroport[a].ville!.id == id) {
        return false;
      }
    }
    return true;
  }
}
