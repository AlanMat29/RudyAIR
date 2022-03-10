import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Ville } from 'src/app/model/vol/ville';
import { VilleService } from 'src/app/services/ville.service';

@Component({
  selector: 'app-ville-edit',
  templateUrl: './ville-edit.component.html',
  styleUrls: ['./ville-edit.component.css'],
})
export class VilleEditComponent implements OnInit {
  ville: Ville = new Ville();

  constructor(
    private activatedRoute: ActivatedRoute,
    private villeService: VilleService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.villeService.getById(params['id']).subscribe((result) => {
          this.ville = result;
        });
      }
    });
  }

  saveVille() {
    console.log(this.ville);
    if (this.ville.id) {
      this.villeService.update(this.ville).subscribe((ok) => {
        this.goToVilleList();
      });
    } else {
      this.villeService.create(this.ville).subscribe((ok) => {
        this.goToVilleList();
      });
    }
  }

  goToVilleList() {
    this.router.navigate(['/admin/ville']);
  }

  convertVilleStatutToString(enumStr: any) {
    if (<string>enumStr == 'en Vol') {
      return 'En vol';
    } else if (<string>enumStr == 'au Sol') {
      return 'Au sol';
    }
    return 'En maintenance';
  }
}
