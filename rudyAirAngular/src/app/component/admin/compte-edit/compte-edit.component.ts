import { Adresse } from 'src/app/model/compte/adresse';
import { Abonnement } from './../../../model/compte/abonnement';
import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/model/compte/client';
import { ActivatedRoute, Router } from '@angular/router';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-compte-edit',
  templateUrl: './compte-edit.component.html',
  styleUrls: ['./compte-edit.component.css'],
})
export class CompteEditComponent implements OnInit {
  client: Client = new Client();
  abonnementClient = Abonnement;
  currentDate: Date = new Date();

  constructor(
    private activatedRoute: ActivatedRoute,
    private compteService: CompteService,
    private router: Router
  ) {
    this.client.adresse = new Adresse();
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.compteService.getClientById(params['id']).subscribe((result) => {
          this.client = result;
        });
      }
    });
  }
  saveClient() {
    if (this.client.id) {
      this.compteService.updateClient(this.client).subscribe((ok) => {
        this.goToClientList();
      });
    } else {
      this.compteService.createClient(this.client).subscribe((ok) => {
        this.goToClientList();
      });
    }
  }

  goToClientList() {
    this.router.navigate(['/admin/compteClient']);
  }

  convertClientAboToString(enumStr: any) {
    if (<string>enumStr == '105') {
      return 'Confort';
    } else if (<string>enumStr == '210.9') {
      return 'Premium';
    }
    return 'Aucun';
  }
}
