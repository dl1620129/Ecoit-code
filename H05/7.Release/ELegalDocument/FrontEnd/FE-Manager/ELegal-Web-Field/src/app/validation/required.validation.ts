import { Directive } from '@angular/core';
import { NG_VALIDATORS, ValidatorFn, Validator, FormControl } from '@angular/forms';

//validation function
function emptyStringValidation(control: FormControl) :  { [key: string]: boolean } | null {
    let value = control.value;
    if (value && value != null && value.trim() == '') {
        return {'emptyString': true};
    }

    return null;
}

@Directive({
    selector: '[emptyString]',
    providers: [
      { provide: NG_VALIDATORS, useExisting: EmptyStringValidator, multi: true }
    ]
  })
  export class EmptyStringValidator implements Validator {
    validator: ValidatorFn;
    constructor() {
    }
    
    validate(c: FormControl) {
      return emptyStringValidation(c);
    }
    
  }