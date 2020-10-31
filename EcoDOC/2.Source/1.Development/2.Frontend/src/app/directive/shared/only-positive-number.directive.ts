import { Directive } from '@angular/core';
import { Component, EventEmitter, OnInit, Input, Output } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
  selector: '[onlyPositiveNumber]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: OnlyPositiveNumber,
    multi: true
  }]
})
export class OnlyPositiveNumber implements Validator {

  constructor() {}

  validate(control: AbstractControl) {
    if (control && !this.isPositiveNumber(control.value)) {
      return {'onlyPositiveNumber': true}
    } else {
      return null;
    }
  }

  isPositiveNumber(number: number){
    if (number >= 0) {
      return true
    }
    return false;
  }
}
