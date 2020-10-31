import { Directive, HostListener } from '@angular/core';
import { Component, EventEmitter, OnInit, Input, Output } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
  selector: '[onlyNumber]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: OnlyNumber,
    multi: true
  }]
})
export class OnlyNumber implements Validator {
  
  constructor() {}

  @HostListener('keydown', ['$event']) onKeyDown(event) {
    let e = <KeyboardEvent> event;
    
      if ([46, 8, 9, 27, 13, 110, 190].indexOf(e.keyCode) !== -1 ||
        // Allow: Ctrl+A
        (e.keyCode === 65 && (e.ctrlKey || e.metaKey)) ||
        // Allow: Ctrl+C
        (e.keyCode === 67 && (e.ctrlKey || e.metaKey)) ||
        // Allow: Ctrl+V
        (e.keyCode === 86 && (e.ctrlKey || e.metaKey)) ||
        // Allow: Ctrl+X
        (e.keyCode === 88 && (e.ctrlKey || e.metaKey)) ||
        // Allow: home, end, left, right
        (e.keyCode >= 35 && e.keyCode <= 39)) {
          // let it happen, don't do anything
          return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
      
  }
  
  validate(control: AbstractControl) {
    // if (!this.isOnlyNumber(control.value)) {
    //   console.log("only number false")
    //   return {'onlyNumber': true}
    // } else {
    //   return null;
    // }
    return null
  }

  // isOnlyNumber(name: string){
  //   // console.log("name2", name)
  //   let onlyNumberRegex = "[0-9]+"
  //   if (!name || name.toString().match(onlyNumberRegex)) {
  //     console.log("pass only", name)
  //     return true
  //   }
  //   return false;
  // }
}
