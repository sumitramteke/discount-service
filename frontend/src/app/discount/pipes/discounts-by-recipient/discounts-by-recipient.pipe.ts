import { Pipe, PipeTransform } from '@angular/core';
import { groupBy } from 'lodash';
import { Discount, DiscountByRecipient } from '../..';

@Pipe({
  name: 'byRecipient'
})
export class DiscountsByRecipientPipe implements PipeTransform {

  transform(discounts: Array<Discount>): Array<DiscountByRecipient> {
    const recipientDiscountMap = groupBy(discounts, 'recipient.id');
    let result = Object.keys(recipientDiscountMap).map(key => {
      const rDiscounts = recipientDiscountMap[key];
      const item: DiscountByRecipient = {
        recipient: rDiscounts[0].recipient,
        nTotal: rDiscounts.length,
        nActive: rDiscounts.filter((rd) => !rd.applied).length,
        discounts: rDiscounts,
      };
      return item;
    });
    console.log(result);
    return result;
  }

}
