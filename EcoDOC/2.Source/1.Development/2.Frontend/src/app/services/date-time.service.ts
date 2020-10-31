import { Injectable, Inject, LOCALE_ID } from '@angular/core';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import { ApiHelper } from '../core/rest/api-helper';
import { Constant } from '../core/config/constant';
import { NgbDate } from '@ng-bootstrap/ng-bootstrap';
import { DatePipe } from '@angular/common';
import { formatDate } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class DateTimeService {

  datePlaceholderFormat = 'dd/mm/yyyy';

  constructor(
    private apiHelper: ApiHelper,
    @Inject(LOCALE_ID) private locale: string
  ) { }

  getDateCalendar(date: NgbDate) : string {
    if (date && date.year && date.month && date.day) {
      return (`${date.year}-${this.getMonth(date.month)}-${this.getDate(date.day)} `)
    }
    
    return ''
  }

  getTodayCalender() : string {
    let currentDate = new Date()
    return (`${currentDate.getFullYear()}-${currentDate.getMonth() + 1}-${currentDate.getDate()} `)
  }

  getTodayNgbDate() : NgbDate {
    let currentDate = new Date()

    return new NgbDate(+currentDate.getFullYear(), +currentDate.getMonth() + 1, +currentDate.getDate())
  }

  convertStringDateToNgbDate(date: string, needTransform = false) : NgbDate {
    if(date) {
      if(needTransform) {
        date = this.transformDate(date);
      }
      
      let dateElements = date.split('-')
      return new NgbDate(+dateElements[0], +dateElements[1], +dateElements[2])
    }
    else {
      return new NgbDate(null, null, null)
    }
  }

  transformDate(date) {
    return formatDate(date, 'yyyy-MM-dd', this.locale);
  }

  isBookWarning(bookYear: number) : boolean {
    let currentDate = new Date();
    let maxBookDate = new Date(bookYear, 11, 31);
    console.log('bookYear', bookYear)
    // maxBookDate.setFullYear(bookYear,31,12)
    console.log('maxBookDate', maxBookDate)
    let numberOfDayLeft = Math.floor((maxBookDate.getTime()
                        - currentDate.getTime())/(1000 * 3600 * 24))
    console.log("numberOfDayLeft", numberOfDayLeft)
    if (numberOfDayLeft < 15 && numberOfDayLeft > 0) {
      return true
    }
    return false
  }

  getRemainedDays(date: NgbDate, needTransform = false) {
    if (date && this.getDateCalendar(date) !== '') {
      let currentDate = new Date();
      console.log('new Date(this.getDateCalendar(date))', new Date(this.getDateCalendar(date)))
      let remainedNumber = Math.floor((new Date(this.getDateCalendar(date)).getTime()
                        - currentDate.getTime())/(1000 * 3600 * 24)) + 2;
      if(remainedNumber < 0) {
        return 0
      }
      else return remainedNumber
    }
    return ''
  }
  
  private 
    getDate(dateNumber: number) : string {
      // if(dateNumber < 10) {
      //   dateNumber = +('0' + dateNumber.toString())
      // }
      return (('0' + dateNumber).slice(-2))
    }

    getMonth(monthNumber: number) : string {
      // if(monthNumber < 10) {
      //   console.log('monthNumber', monthNumber)
      //   monthNumber = +('0' + monthNumber.toString())
      //   console.log('monthNumber1', monthNumber)
      // }
      console.log('monthNumber', (('0' + monthNumber).slice(-2)))
      return (('0' + monthNumber).slice(-2))
    }
}
