import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/model/compte/client';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-compte-list',
  templateUrl: './compte-list.component.html',
  styleUrls: ['./compte-list.component.css'],
})
export class CompteListComponent implements OnInit {
  comptesClient: Client[] = [];

  constructor(private compteService: CompteService) {}

  ngOnInit(): void {
    this.listAllCompteClient();
  }

  listAllCompteClient() {
    this.compteService.getAllClient().subscribe((result) => {
      this.comptesClient = result;
    });
  }

  deleteCompteById(id: number) {
    this.compteService.deleteById(id).subscribe((ok) => {
      this.listAllCompteClient();
    });
  }

  convertClientAboToString(enumStr: any) {
    if (<string>enumStr == 'abonnementConfort') {
      return 'Confort';
    } else if (<string>enumStr == 'abonnementPremium') {
      return 'Premium';
    }
    return 'Aucun';
  }
}
