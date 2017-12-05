

import {Pipe, PipeTransform} from '@angular/core';
import {UserModel} from './user.model';

@Pipe({
  name: 'filterByContact'
})
export class ContactFilterPipe  implements PipeTransform{
  transform(items: UserModel[], searchText: number): any[] {
    if (!items) {
      return [];
    }
    if (!searchText){
      return items;
    }

    return items.filter( it => {
      return it.contactNo.toString().toLowerCase().includes(searchText.toLocaleString());
    });
  }
}


