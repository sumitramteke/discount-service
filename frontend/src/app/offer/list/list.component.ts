import { AfterViewInit, Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges, ViewChild } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Offer } from '..';
import { OfferService } from '../service';

@Component({
  selector: 'offer-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
})
export class OfferListComponent implements OnInit, OnChanges {
  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['name', 'percent', 'id'];
  $data: Observable<Array<Offer>>;
  @Output() activeOffer = new EventEmitter<Offer>();
  @Input() reload: boolean;

  constructor(private service: OfferService) {}

  ngOnInit() {
    this.loadOffers();
  }

  ngOnChanges({ reload }: SimpleChanges): void {
    if (reload.currentValue) {
      this.loadOffers();
    }
  }

  loadOffers() {
    this.$data = this.service.findAll().pipe(tap(data => this.reload = false));
  }

  showInfo(offer: Offer) {
    this.activeOffer.emit(offer);
  }
}
