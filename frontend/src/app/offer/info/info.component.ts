import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Offer } from '..';
import { OfferService } from '../service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'offer-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.scss'],
})
export class OfferInfoComponent implements OnInit, OnChanges {
  @Input() offer: Offer;
  rForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl('', Validators.required),
    percent: new FormControl('', [Validators.required]),
  });

  @Output() onOfferApply = new EventEmitter<Offer>();

  constructor(
    private service: OfferService,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {}

  ngOnChanges({ offer }: SimpleChanges): void {
    if (offer && offer.currentValue) {
      const curr: Offer = offer.currentValue;
      this.rForm.setValue(offer.currentValue);
    }
  }

  saveOrUpdate() {
    if (this.rForm.valid) {
      const offer: Offer = this.rForm.getRawValue();
      this.rForm.disable();
      const apiObservable: Observable<Offer> = !!offer.id
        ? this.service.update(offer)
        : this.service.save(offer);
      apiObservable.subscribe({
        next: (result) => {
          this.snackBar.open(
            `Offer ${!!offer.id ? 'updated' : 'added'} successfully`,
            null,
            { duration: 3000, panelClass: 'notify-success' }
          );
          this.onOfferApply.emit(result);
        },
        error: (err) => {
          this.rForm.enable();
          this.rForm.reset();
        },
        complete: () => {
          this.rForm.enable();
          this.rForm.reset();
        },
      });
    }
  }
}
