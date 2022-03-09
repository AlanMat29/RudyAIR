import { Component, OnInit } from '@angular/core';
import { Vol } from 'src/app/model/vol/vol';
import { VolGenerique } from 'src/app/model/vol/volGenerique';
import { VolService } from 'src/app/services/vol.service';
import { VolGeneriqueService } from 'src/app/services/volGenerique.service';

@Component({
  selector: 'app-vol-generique-list',
  templateUrl: './vol-generique-list.component.html',
  styleUrls: ['./vol-generique-list.component.css'],
})
export class VolGeneriqueListComponent implements OnInit {
  volGeneriques: VolGenerique[] = [];
  vols: Vol[] = [];

  constructor(
    private volGeneriqueService: VolGeneriqueService,
    private volService: VolService
  ) {}

  ngOnInit(): void {
    this.listAllVolGenerique();
    this.listAllVol();
  }

  listAllVolGenerique() {
    this.volGeneriqueService.getAll().subscribe((result) => {
      this.volGeneriques = result;
    });
  }

  deleteVolGeneriqueById(id: number) {
    this.volGeneriqueService.deleteById(id).subscribe((ok) => {
      this.listAllVolGenerique();
    });
  }

  listAllVol() {
    this.volService.getAll().subscribe((result) => {
      this.vols = result;
    });
  }
  canBeDelete(id: number) {
    for (let v in this.vols) {
      if (this.vols[v].volGenerique!.id == id) {
        return false;
      }
    }
    return true;
  }
}
