import {Pipe, PipeTransform} from '@angular/core';
import {UserModel} from './user.model';

@Pipe({
  name: 'filterByEmail'
})
export class EmailFilterPipe implements PipeTransform{
  transform(items: UserModel[], searchEmail: string): any[] {
    if (!items) {
      return [];
    }
    if (!searchEmail){
      return items;
    }

    return items.filter( it => {
      return it.emailId.toString().toLowerCase().includes(searchEmail.toLocaleString());
    });
  }
}
