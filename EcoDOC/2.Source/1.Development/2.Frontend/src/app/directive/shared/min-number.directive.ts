import { Directive } from '@angular/core';
import { Component, EventEmitter, OnInit, Input, Output } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
  selector: '[minNumber]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: MinNumber,
    multi: true
  }]
})
export class MinNumber implements Validator {
  @Input() minNumberValue: number

  constructor() {}

  validate(control: AbstractControl) {
    if (control && control.value && !this.isGreaterThanMinNumber(control.value, this.minNumberValue)) {
      // console.log('control.value', control.value)
      return {'minNumber': true}
    } else {
      return null;
    }
  }

  isGreaterThanMinNumber(inputedNumber: number, minNumber: number){
    if (inputedNumber >= minNumber) {
      return true
    }
    return false;
  }
}
