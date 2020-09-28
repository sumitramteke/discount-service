import { AfterViewInit, Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges, ViewChild } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Recipient } from '..';
import { RecipientService } from '../service';

@Component({
  selector: 'recipient-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
})
export class RecipientListComponent implements OnInit, OnChanges {
  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['name', 'email', 'id'];
  $data: Observable<Array<Recipient>>;
  @Output() activeRecipient = new EventEmitter<Recipient>();
  @Input() reload: boolean;

  constructor(private service: RecipientService) {}

  ngOnInit() {
    this.loadRecipients();
  }

  ngOnChanges({ reload }: SimpleChanges): void {
    if (reload.currentValue) {
      this.loadRecipients();
    }
  }

  loadRecipients() {
    this.$data = this.service.findAll().pipe(tap(data => this.reload = false));
  }

  showInfo(recipient: Recipient) {
    this.activeRecipient.emit(recipient);
  }
}
