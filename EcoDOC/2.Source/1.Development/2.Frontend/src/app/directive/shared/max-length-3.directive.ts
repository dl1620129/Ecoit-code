import { Directive } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
  selector: '[appMaxLength3]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: MaxLength3Directive,
    multi: true
  }]
})
export class MaxLength3Directive implements Validator {
  constructor() {}

  validate(control: AbstractControl) {
    if (control.value && this.isLengthMoreThan3(control.value)) {
      return {'maxLength3': true}
    } else {
      return null;
    }
  }

  isLengthMoreThan3(number: string) {
    if (number.toString().length > 3) {
      return true
    }
    return false;
  }
}
