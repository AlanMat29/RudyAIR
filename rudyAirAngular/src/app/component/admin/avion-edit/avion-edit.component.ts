import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Avion } from 'src/app/model/vol/avion';
import { StatutAvion } from 'src/app/model/vol/statutAvion';
import { AvionService } from 'src/app/services/avion.service';

@Component({
  selector: 'app-avion-edit',
  templateUrl: './avion-edit.component.html',
  styleUrls: ['./avion-edit.component.css'],
})
export class AvionEditComponent implements OnInit {
  avion: Avion = new Avion();
  avionStatuts = StatutAvion;

  constructor(
    private activatedRoute: ActivatedRoute,
    private avionService: AvionService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.avionService.getById(params['id']).subscribe((result) => {
          this.avion = result;
        });
      }
    });
  }

  saveAvion() {
    if (this.avion.id) {
      this.avionService.update(this.avion).subscribe((ok) => {
        this.goToAvionList();
      });
    } else {
      this.avionService.create(this.avion).subscribe((ok) => {
        this.goToAvionList();
      });
    }
  }

  goToAvionList() {
    this.router.navigate(['/admin/avion']);
  }

  convertAvionStatutToString(enumStr: any) {
    console.log(enumStr);
    if (<string>enumStr == 'en Vol') {
      return 'En vol';
    } else if (<string>enumStr == 'au Sol') {
      return 'Au sol';
    }
    return 'En maintenance';
  }
}
