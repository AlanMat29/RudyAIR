import { Component, OnInit } from '@angular/core';
import { Vol } from 'src/app/model/vol/vol';
import { VolService } from 'src/app/services/vol.service';

@Component({
  selector: 'app-vol-list',
  templateUrl: './vol-list.component.html',
  styleUrls: ['./vol-list.component.css'],
})
export class VolListComponent implements OnInit {
  vols: Vol[] = [];

  constructor(private volService: VolService) {}

  ngOnInit(): void {
    this.listAllVol();
  }

  listAllVol() {
    this.volService.getAll().subscribe((result) => {
      this.vols = result;
    });
  }

  deleteVolById(id: number) {
    this.volService.deleteById(id).subscribe((ok) => {
      this.listAllVol();
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

  convertVolStatutToString(enumStr: any) {
    if (<string>enumStr == 'onTime') {
      return 'On time';
    } else if (<string>enumStr == 'delayed') {
      return 'Delay';
    }
    return 'Canceled';
  }
}
