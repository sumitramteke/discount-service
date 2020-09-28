import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Recipient } from '..';

@Injectable({
  providedIn: 'root',
})
export class RecipientService {
  private static uri = 'recipients';

  constructor(private http: HttpClient) {}

  findAll(): Observable<Array<Recipient>> {
    return this.http.get<Array<Recipient>>(RecipientService.uri);
  }

  save(recipient: Recipient): Observable<Recipient> {
    return this.http.post<Recipient>(RecipientService.uri, recipient);
  }

  update(recipient: Recipient): Observable<Recipient> {
    return this.http.put<Recipient>(`${RecipientService.uri}/${recipient.id}`, recipient);
  }

  delete(id: String): Observable<Recipient> {
    return this.http.delete<Recipient>(`${RecipientService.uri}/${id}`);
  }
}
