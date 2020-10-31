import { Directive, Input } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
  selector: '[unique]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: Unique,
    multi: true
  }]
})
export class Unique implements Validator {
  @Input() isUnique: string;

  constructor() {}

  validate(control: AbstractControl) {
    if (!(this.isUnique =='true')) {
      return {'unique': true}
    } else {
      return null;
    }
  }
}
