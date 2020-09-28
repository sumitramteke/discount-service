import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApplyDiscount, Discount, DiscountPayload } from '..';

@Injectable({
  providedIn: 'root'
})
export class DiscountService {

  private static uri = 'discounts';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Array<Discount>> {
    return this.http.get<Array<Discount>>(DiscountService.uri);
  }

  saveAll(discounts: Array<DiscountPayload>): Observable<Array<Discount>> {
    return this.http.post<Array<Discount>>(DiscountService.uri, discounts);
  }

  applyDiscount(payload: ApplyDiscount): Observable<Discount> {
    return this.http.put<Discount>(`${DiscountService.uri}`, payload);
  }

  delete(id: String): Observable<Discount> {
    return this.http.delete<Discount>(`${DiscountService.uri}/${id}`);
  }
}
