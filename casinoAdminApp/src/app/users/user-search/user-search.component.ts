import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared/user.service';
import {DataStorageService} from '../../shared/data-storage.service';
import {UserModel} from '../../shared/user.model';

@Component({
  selector: 'app-user-search',
  templateUrl: './user-search.component.html',
  styleUrls: ['./user-search.component.css']
})
export class UserSearchComponent implements OnInit {
   searchName: string;
   searchEmail: string;
   searchContact: number;
  users;
  slectedUser: UserModel;
  showMsg: Boolean = false;
  rechargeAmount: number;
  constructor(private dataService: DataStorageService) {
  this.slectedUser = new UserModel();
  }

  ngOnInit() {
   this.dataService.getAllUser().subscribe(
     (res) => {
       this.users = res;
       console.log(this.users);
     }
   );
   }

  clearSearch(f) {
    f.reset();
  }

  recharge(id: number) {
    console.log(id);
    console.log(this.users[id]);
    this.slectedUser = this.users[id];
    this.showMsg = true;
  }

  performRecharge() {
    console.log('performRecharge');
    this.slectedUser.accountBal += this.rechargeAmount;
    const body =  JSON.stringify(this.slectedUser);
    this.dataService.recharge(this.slectedUser).subscribe(
      (res) => {
        this.showMsg = false;
        // location.reload();
      }
    );
  }

}
