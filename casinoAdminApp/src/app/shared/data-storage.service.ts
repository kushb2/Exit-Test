import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import {UserModel} from './user.model';
import 'rxjs/add/operator/toPromise';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {UserService} from './user.service';

const BASE_URL = 'http://localhost:8080/api/';
const header = {headers: new Headers({'Content-Type': 'application/json'})};

@Injectable()
export class DataStorageService {
  constructor(private http: Http, private userService: UserService) {
  }


  registerUser(user: any) {
    return this.http.post(BASE_URL + 'register/', user, header)
    .map(
      (responce: Response) => {
      const user: UserModel = responce.json();
        return user;
      }
      )
      .subscribe(
      (userr: UserModel) => {
        this.userService.addUser(userr);
        this.userService.addedUser = userr;
      }
    );
  }


  getAllUser() {
    return this.http.get(BASE_URL + 'getall/').map(
      (res) => res.json());
  }

  recharge(user: any) {
    const id: number = user.secretID;
    return this.http.put(BASE_URL + 'recharge/', user, header);
  }




}
