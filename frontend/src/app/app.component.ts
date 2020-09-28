import { Component } from '@angular/core';
import { Offer } from './offer';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'discount';

  offer: Offer;
  reloadOfferList: boolean;

  activeOffer(offer: Offer) {
    this.offer = offer;
  }

  onApplyOffer() {
    this.reloadOfferList = true;
  }
}
