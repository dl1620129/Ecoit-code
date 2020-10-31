import { Directive } from '@angular/core';
import { Component, EventEmitter, OnInit, Input, Output } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
  selector: '[mustBeAlphanumeric]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: MustBeAlphanumeric,
    multi: true
  }]
})
export class MustBeAlphanumeric implements Validator {
  
  constructor() {}

  validate(control: AbstractControl) {
    if (!this.isAlphanumeric(control.value)) {
      return {'mustBeAlphanumeric': true}
    } else {
      return null;
    }
  }

  isAlphanumeric(name: string){
    // console.log("name2", name)
    let specialChars = "<>@!#$%^&*()_+[]{}?:;|'\"\\,./~`-="
    for(let i = 0; i < specialChars.length;i++){
        if(name && name.includes(specialChars[i])){
            return false
        }
    }
    return true;
  }
}         
