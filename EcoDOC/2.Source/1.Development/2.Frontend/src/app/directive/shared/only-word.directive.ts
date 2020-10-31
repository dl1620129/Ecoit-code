import { Directive } from '@angular/core';
import { Component, EventEmitter, OnInit, Input, Output } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
  selector: '[onlyWord]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: OnlyWord,
    multi: true
  }]
})
export class OnlyWord implements Validator {
  constructor() {}

  validate(control: AbstractControl) {
    if (!this.isAlphanumeric(control.value)) {
      return {'onlyWord': true}
    } else {
      return null;
    }
  }

  isAlphanumeric(name: string){
    let specialChars = "<>@!#$%^&*()_+[]{}?:;|'\"\\,./~`-=0123456789"
    for(let i = 0; i < specialChars.length;i++) {
        if(name && name.includes(specialChars[i])) {
            return false
        }
    }
    return true;
  }
}
