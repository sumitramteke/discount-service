import { Offer } from '../offer';
import { Recipient } from '../recipient';

export * from './container';
export * from './service';

export interface DiscountPayload {
  id: string;
  code: string;
  recipientId: string;
  offerId: string;
  applied: boolean;
  appliedDt: string;
  expiryDt: string;
  createdDt: string;
}

export interface Discount {
  id: string;
  code: string;
  recipient: Recipient;
  offer: Offer;
  applied: boolean;
  appliedDt: string;
  expiryDt: string;
  createdDt: string;
}
