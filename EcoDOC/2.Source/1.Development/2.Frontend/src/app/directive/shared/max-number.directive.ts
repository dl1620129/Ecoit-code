import { Directive, Input } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
  selector: '[appMaxNumber][formControlName],[appMaxNumber][formControl],[appMaxNumber][ngModel]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: MaxNumber,
    multi: true
  }]
})
export class MaxNumber implements Validator {
  @Input() maxNumber: string;
  constructor() {}

  validate(control: AbstractControl) {
    if (control.value && this.isOverMaxNumber(control.value)) {
      control.setValue(this.maxNumber.toString())
      // return {'maxNumber': true}
      return null
    } else {
      return null;
    }
  }

  isOverMaxNumber(number: string) {
    console.log(+number > +this.maxNumber, +number, +this.maxNumber)
    if (+number > +this.maxNumber) {
      return true
    }
    return false;
  }
}
