import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ApplyDiscount, Discount } from '..';
import { DiscountService } from '../service';

@Component({
  selector: 'discount-apply',
  templateUrl: './apply.component.html',
  styleUrls: ['./apply.component.scss']
})
export class DiscountApplyComponent {

  rForm: FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    code: new FormControl('', Validators.required),
  });

  @Output() onDiscountApply = new EventEmitter<Discount>();

  constructor(
    private service: DiscountService,
    private snackBar: MatSnackBar
  ) { }



  saveOrUpdate() {
    if (this.rForm.valid) {
      const payload: ApplyDiscount = this.rForm.getRawValue();
      this.rForm.disable();
      this.service.applyDiscount(payload).subscribe({
        next: (result: Discount) => {
          this.snackBar.open(
            `Discount applied successfully for ${result.recipient.name}`,
            null,
            { duration: 3000, panelClass: 'notify-success' }
          );
          this.onDiscountApply.emit(result);
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
