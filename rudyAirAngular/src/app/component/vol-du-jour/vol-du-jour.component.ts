import { VolGenerique } from 'src/app/model/vol/volGenerique';
import { Component, OnInit } from '@angular/core';
import { Vol } from 'src/app/model/vol/vol';
import { VolService } from 'src/app/services/vol.service';
import { VolGeneriqueService } from 'src/app/services/volGenerique.service';

@Component({
  selector: 'app-vol-du-jour',
  templateUrl: './vol-du-jour.component.html',
  styleUrls: ['./vol-du-jour.component.css'],
})
export class VolDuJourComponent implements OnInit {
  vols: Vol[] = [];
  volGeneriques: VolGenerique[] = [];
  currentDate: Date = new Date();
  filtVols: Vol[] = [];

  constructor(
    private volGeneriqueService: VolGeneriqueService,
    private volService: VolService
  ) {}

  ngOnInit(): void {
    this.listAllVolGenerique();
    this.filterVolDuJour();
  }

  listAllVolGenerique() {
    this.volGeneriqueService.getAll().subscribe((result) => {
      this.volGeneriques = result;
    });
  }

  listAllVol() {
    this.volService.getAll().subscribe((result) => {
      this.vols = result;
    });
  }

  filterVolDuJour() {
    this.volService.getAll().subscribe((result) => {
      this.vols = result;
      this.filtVols = result.filter(
        (c) => this.formatBis(c.dateDepart!) == this.formatBis(this.currentDate)
      );
    });
  }

  format(date: Date) {
    date = new Date(date);
    var day = ('0' + date.getDate()).slice(-2);
    var month = ('0' + (date.getMonth() + 1)).slice(-2);
    var year = date.getFullYear();

    return day + '/' + month + '/' + year;
  }

  formatBis(date: Date) {
    date = new Date(date);

    var day = ('0' + date.getDate()).slice(-2);
    var month = ('0' + (date.getMonth() + 1)).slice(-2);
    var year = date.getFullYear();

    return year + '-' + month + '-' + day;
  }
}
