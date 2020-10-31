import { Directive } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
  selector: '[atLeastOneCharacter]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: AtLeastOneCharacter,
    multi: true
  }]
})
export class AtLeastOneCharacter implements Validator {
  constructor() {}

  validate(control: AbstractControl) {
    if (control.value && this.isAtLeastOneCharacter(control.value)) {
      return null;
    } else {
      return {'atLeastOneCharacter': true}
    }
  }

  isAtLeastOneCharacter(str: string) {
    if (str && str.toString().trim().length > 0) {
      return true
    }
    return false;
  }
}
