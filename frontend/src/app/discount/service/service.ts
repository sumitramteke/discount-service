import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Discount, DiscountPayload } from '..';

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

  update(discount: DiscountPayload): Observable<Discount> {
    return this.http.put<Discount>(`${DiscountService.uri}/${discount.id}`, discount);
  }

  delete(id: String): Observable<Discount> {
    return this.http.delete<Discount>(`${DiscountService.uri}/${id}`);
  }
}
