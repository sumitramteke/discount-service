import { Component } from '@angular/core';
import { Recipient } from '..';

@Component({
  selector: 'recipient-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.scss'],
})
export class RecipientContainerComponent {
  recipient: Recipient;
  reloadRecipientList: boolean;

  activeRecipient(recipient: Recipient) {
    this.recipient = recipient;
  }

  onApplyRecipient() {
    this.reloadRecipientList = true;
    setTimeout(() => this.reloadRecipientList = false, 1000);
  }
}
