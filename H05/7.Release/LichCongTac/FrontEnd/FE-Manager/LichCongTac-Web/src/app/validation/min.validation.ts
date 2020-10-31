import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, ValidatorFn, Validator, FormControl } from '@angular/forms';

//max validation function
function minValueValidation(min: number) : ValidatorFn {
    return (control: FormControl) : { [key: string]: boolean } | null => {
        let value = control.value;
        if (!isNaN(value) && (value < min) && value != null) {
            return {'cusMin': true};
        }
    
        return null;
    }
}

@Directive({
    selector: '[cusMin]',
    providers: [
      { provide: NG_VALIDATORS, useExisting: MinValueValidator, multi: true }
    ]
  })
  export class MinValueValidator implements Validator {
    validator: ValidatorFn;
    @Input('cusMin') min:number;
    constructor() {
    }
    
    validate(c: FormControl) {
      return minValueValidation(this.min)(c);
    }
    
}