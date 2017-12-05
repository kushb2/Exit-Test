import {Pipe, PipeTransform} from '@angular/core';
import {UserModel} from './user.model';




@Pipe({
  name: 'filterByName'
})
export class NameFilterPipe implements PipeTransform {
  transform(items: UserModel[], searchName: string): any[] {
    if (!items) {
      return [];
    }
    if (!searchName){
      return items;
    }

    return items.filter( it => {
      return it.name.toString().toLowerCase().includes(searchName.toLocaleString());
    });
  }
}
