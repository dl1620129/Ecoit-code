import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, ValidatorFn, Validator, FormControl } from '@angular/forms';

//validation function
function maxLengthValidation(maxLength: number) : ValidatorFn {
    return (control: FormControl) : { [key: string]: boolean } | null => {
        let value = control.value;
        if (value && value.length > maxLength && value != null) {
            return {'cusMaxLength': true};
        }
    
        return null;
    }
}

@Directive({
    selector: '[cusMaxLength]',
    providers: [
      { provide: NG_VALIDATORS, useExisting: MaxLengthValidator, multi: true }
    ]
  })
  export class MaxLengthValidator implements Validator {
    validator: ValidatorFn;
    @Input('cusMaxLength') maxLength:number;
    constructor() {
    }
    
    validate(c: FormControl) {
      return maxLengthValidation(this.maxLength)(c);
    }
    
}