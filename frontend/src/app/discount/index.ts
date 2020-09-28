import { Offer } from '../offer';
import { Recipient } from '../recipient';

export * from './container';
export * from './service';
export * from './apply';
export * from './toggle-list';
export * from './pipes';
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

export interface ApplyDiscount {
  email: string;
  code: string;
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

export interface DiscountByRecipient {
  recipient: Recipient;
  nActive: number;
  nTotal: number;
  discounts: Array<Discount>;
}
