import { Directive } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
  selector: '[atLeastOneWord]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: AtLeastOneWord,
    multi: true
  }]
})
export class AtLeastOneWord implements Validator {
  constructor() {}

  validate(control: AbstractControl) {
    if (control.value && this.isAtLeastOneWord(control.value)) {
      return null;
    } else {
      return {'atLeastOneWord': true}
    }
  }

  isAtLeastOneWord(number: string) {
    if (+(number.toString().trim().length) > 0 && isNaN(+(number.toString()))) {
      return true
    }
    return false;
  }
}
