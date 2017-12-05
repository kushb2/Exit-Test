

import {Injectable} from '@angular/core';
import {UserModel} from './user.model';


@Injectable()
export class UserService {

  public users: UserModel[];
  public searchText: string;
  public searchEmail: string;
  public searchContact: number;
  public rechargeAmount: number;
  public addedUser: UserModel;

  getUsers() {
    return this.users;
  }

  getRecipe(index: number) {
    return this.users[index];
  }

  setusers(user : UserModel[]) {
    this.users = user;
  }

  addUser(user: UserModel) {
    console.log('hello');
    console.log(user);
    this.users.push(user);
  }


}
