import {
  AfterViewInit,
  Component,
  Input,
  OnChanges,
  OnInit,
  SimpleChanges,
} from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { DiscountByRecipient, Discount } from '..';
import { DiscountService } from '../service';

@Component({
  selector: 'discount-toggle-list',
  templateUrl: './toggle-list.component.html',
  styleUrls: ['./toggle-list.component.scss'],
})
export class DiscountToggleListComponent implements OnChanges, AfterViewInit {
  displayedByRecipientColumns = ['recipient', 'discounts'];
  displayedColumns = [];
  $data: Observable<Array<Discount>>;
  @Input() reload: boolean;

  constructor(private service: DiscountService) {}

  ngOnChanges({ reload }: SimpleChanges): void {
    if (reload.currentValue) {
      this.loadRecipients();
    }
  }

  ngAfterViewInit() {
    this.loadRecipients();
  }

  loadRecipients() {
    this.$data = this.service
      .findAll()
      .pipe(tap((data) => (this.reload = false)));
  }

  showInfo(input: DiscountByRecipient) {
    console.log('Hello World ', input);
  }
}
