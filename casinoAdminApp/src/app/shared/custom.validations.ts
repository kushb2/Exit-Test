import { AbstractControl, ValidationErrors} from '@angular/forms';
import {isUndefined} from 'util';


export  class CustomValidations {
  static validateDate(control: AbstractControl): null | ValidationErrors {
    console.log(typeof control.value)
    if ( !isUndefined(control.value)) {

      const val = 2017 - control.value.substr(0, 4);
      // const  res = val./substr(0,/4) ;
      console.log(val);
      if (val < 18) {
        // return {validateDate: true};
        return null;
      }
      return  {validateDate: true};
    }
  }
}





