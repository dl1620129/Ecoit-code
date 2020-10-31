import { Injectable } from '@angular/core';
import { ApiHelper } from 'src/app/core/rest/api-helper';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { NgbDateStruct, NgbDate } from '@ng-bootstrap/ng-bootstrap';
import { NgForm, NgModel } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ValidationService {
  constructor(
    private apihelper: ApiHelper,
  ) { }

  // if max date null, then set max day is today
  getMaxDay(maxDate: NgbDate = null) : NgbDate {
    let currentDate = new Date()
    let today = new NgbDate(currentDate.getFullYear(), currentDate.getMonth() + 1, currentDate.getDate())
    if (!maxDate) {
      return today
    }

    return maxDate 
  }
  
  getMinDay(minDate: NgbDate = null) : NgbDate {
    let currentDate = new Date()
    let today = new NgbDate(currentDate.getFullYear(), currentDate.getMonth() + 1, currentDate.getDate())
    if (!minDate) {
      return today
    }

    return minDate 
  }
  // today = new NgbDate(2020, 7, 10)
  // disableGreaterDayThanToday=(date:NgbDateStruct,current: {month: number,year:number})=> {
  //   let currentDate = new Date()

  //   console.log('what date', current)

    // let today:NgbDateStruct[] = [
    //   {
    //    year: currentDate.getFullYear(),
    //    month: currentDate.getMonth() + 1,
    //    day: currentDate.getDate()
    //   }
    // ]

  //   return today.find(x=>new NgbDate(x.year,x.month,x.day).before(date))?
  //        true:false;
  // }

  isValid(form: NgForm, input: NgModel) {
    return input.invalid && (form.submitted)
  }

  
}
