import { Directive, Input } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
  selector: '[maxLength]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: MaxLengthDirective,
    multi: true
  }]
})
export class MaxLengthDirective implements Validator {
  @Input() maxLengthNumber: string;

  constructor() {}

  validate(control: AbstractControl) {
    if (control.value && this.isLengthMoreThan(control.value)) {
      return {'maxLength': true}
    } else {
      return null;
    }
  }

  isLengthMoreThan(number: string) {
    if (number.toString().length > +this.maxLengthNumber) {
      return true
    }
    return false;
  }
}
