import { Component, HostListener, OnInit } from '@angular/core';
import { Avion } from 'src/app/model/vol/avion';
import { Vol } from 'src/app/model/vol/vol';
import { VolService } from 'src/app/services/vol.service';
import { AvionService } from 'src/app/services/avion.service';

@Component({
  selector: 'app-avion-list',
  templateUrl: './avion-list.component.html',
  styleUrls: ['./avion-list.component.css'],
})
export class AvionListComponent implements OnInit {
  avions: Avion[] = [];
  vols: Vol[] = [];

  constructor(
    private volService: VolService,
    private avionService: AvionService
  ) {}

  ngOnInit(): void {
    this.listAllAvion();
    this.listAllVol();
  }

  listAllAvion() {
    this.avionService.getAllByOrderByRefAsc().subscribe((result) => {
      this.avions = result;
    });
  }

  deleteAvionById(id: number) {
    this.avionService.deleteById(id).subscribe((ok) => {
      this.listAllAvion();
    });
  }

  convertAvionStatutToString(enumStr: any) {
    if (<string>enumStr == 'enVol') {
      return 'En vol';
    } else if (<string>enumStr == 'auSol') {
      return 'Au sol';
    }
    return 'En maintenance';
  }

  listAllVol() {
    this.volService.getAll().subscribe((result) => {
      this.vols = result;
    });
  }

  canBeDelete(id: number) {
    for (let a in this.vols) {
      if (this.vols[a].avion!.id == id) {
        return false;
      }
    }
    return true;
  }
}
