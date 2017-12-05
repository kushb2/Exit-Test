import { Component, OnInit } from '@angular/core';
import {Form, NgForm} from '@angular/forms';
import {UserModel} from '../shared/user.model';
import {DataStorageService} from '../shared/data-storage.service';
import {FormBuilder, FormGroup, Validators, FormControl} from '@angular/forms';
import {UserService} from '../shared/user.service';
import {CustomValidations} from '../shared/custom.validations';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  // formCheck: Boolean = false;
  // form = new FormGroup({
  //   name: new FormControl('', [
  //     Validators.required,
  //     Validators.pattern('[a-zA-Z ]*')
  //   ]),
  //   dob: new FormControl('', [
  //     Validators.required
  //     // ,
  //     // CustomValidations.validateDate
  //   ]),
  //   contact: new FormControl('', [
  //     Validators.required,
  //     Validators.pattern('\d{10}'),
  //     Validators.max(1234567890)
  //     ]),
  //   email: new FormControl('', [
  //     Validators.required,
  //     Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$')
  //   ]),
  //   identityFilePath: new FormControl('', [
  //     Validators.required
  //   ])
  // });


  // get identityFilePath() {
  //   return this.form.get('identityFilePath');
  // }
  //
  // get email() {
  //   return this.form.get('email');
  // }
  //
  // get contact() {
  //   return this.form.get('contact');
  // }
  //
  // get dob() {
  //   return this.form.get('dob');
  // }
  //
  // get name () {
  //   return this.form.get('name');
  // }
  //




  public model: UserModel;
  // rForm: FormGroup;
  isImage: Boolean = false;
  constructor( private  userService: UserService, private dataStoreService: DataStorageService) {
    this.model = new UserModel();
  }

  ngOnInit() {
  }
    abc() {
    console.log('sds');
    this.isImage = true;
  }

  getFiles(event) {
    console.log('dsds');
    this.model.identityFilePath = event.target.files[0].name;
    if ( this.model.identityFilePath.length > 0) {
    this.isImage = false;
    }
  }

  checkDob() {
   const no: any = this.model.dob.substr(0, 4);

    const val: number = 2017 - no ;
    if (val < 18) {
      return 'Date of Birth must be 18+';
    }
    return '';
  }



  onRegister() {
   const res: string =  this.checkDob();
   if (res.length > 0) {
     alert(res);
     return;
   }
     this.model.blockedAmount = 0;
     this.model.accountBal = 500;
     const body =  JSON.stringify(this.model);
     this.dataStoreService.registerUser(body);
  }
}



