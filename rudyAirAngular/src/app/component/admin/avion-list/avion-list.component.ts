import { Component, HostListener, OnInit } from '@angular/core';
import { Avion } from 'src/app/model/vol/avion';
import { AvionService } from 'src/app/services/avion.service';

@Component({
  selector: 'app-avion-list',
  templateUrl: './avion-list.component.html',
  styleUrls: ['./avion-list.component.css'],
})
export class AvionListComponent implements OnInit {
  avions: Avion[] = [];

  constructor(private avionService: AvionService) {}

  ngOnInit(): void {
    this.listAllAvion();
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
}
