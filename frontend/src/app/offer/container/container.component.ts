import { Component } from '@angular/core';
import { Offer } from '..';

@Component({
  selector: 'offer-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.scss'],
})
export class OfferContainerComponent {
  offer: Offer;
  reloadOfferList: boolean;

  activeOffer(offer: Offer) {
    this.offer = offer;
  }

  onApplyOffer() {
    this.reloadOfferList = true;
    setTimeout(() => this.reloadOfferList = false, 1000);
  }
}
