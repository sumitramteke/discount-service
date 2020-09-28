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
import { Recipient } from '..';
import { RecipientService } from '../service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'recipient-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.scss'],
})
export class RecipientInfoComponent implements OnInit, OnChanges {
  @Input() recipient: Recipient;
  rForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
  });

  @Output() onRecipientApply = new EventEmitter<Recipient>();

  constructor(
    private service: RecipientService,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {}

  ngOnChanges({ recipient }: SimpleChanges): void {
    if (recipient && recipient.currentValue) {
      const curr: Recipient = recipient.currentValue;
      this.rForm.setValue(recipient.currentValue);
      if (!!curr.id) {
        this.rForm.get('email').disable();
      }
    }
  }

  saveOrUpdate() {
    if (this.rForm.valid) {
      const recipient: Recipient = this.rForm.getRawValue();
      this.rForm.disable();
      const apiObservable: Observable<Recipient> = !!recipient.id
        ? this.service.update(recipient)
        : this.service.save(recipient);
      apiObservable.subscribe({
        next: (result) => {
          this.snackBar.open(
            `Recipient ${!!recipient.id ? 'updated' : 'added'} successfully`,
            null,
            { duration: 3000, panelClass: 'notify-success' }
          );
          this.onRecipientApply.emit(result);
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
