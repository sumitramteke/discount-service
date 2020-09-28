import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Offer } from '..';

@Injectable({
  providedIn: 'root',
})
export class OfferService {
  private static uri = 'offers';

  constructor(private http: HttpClient) {}

  findAll(): Observable<Array<Offer>> {
    return this.http.get<Array<Offer>>(OfferService.uri);
  }

  save(offer: Offer): Observable<Offer> {
    return this.http.post<Offer>(OfferService.uri, offer);
  }

  update(offer: Offer): Observable<Offer> {
    return this.http.put<Offer>(`${OfferService.uri}/${offer.id}`, offer);
  }

  delete(id: String): Observable<Offer> {
    return this.http.delete<Offer>(`${OfferService.uri}/${id}`);
  }
}
