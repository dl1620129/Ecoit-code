import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, ValidatorFn, Validator, FormControl } from '@angular/forms';

//max validation function
function maxValueValidation(max: number) : ValidatorFn {
    return (control: FormControl) : { [key: string]: boolean } | null => {
        let value = control.value;
        if (!isNaN(value) && value > max && value != null) {
            return {'cusMax': true};
        }
    
        return null;
    }
}

@Directive({
    selector: '[cusMax]',
    providers: [
      { provide: NG_VALIDATORS, useExisting: MaxValueValidator, multi: true }
    ]
  })
  export class MaxValueValidator implements Validator {
    validator: ValidatorFn;
    @Input('cusMax') max:number;
    constructor() {
    }
    
    validate(c: FormControl) {
      return maxValueValidation(this.max)(c);
    }
    
}