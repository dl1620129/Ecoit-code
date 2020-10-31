import {Injectable} from '@angular/core';
import {ApiHelper} from '../core/rest/api-helper';
import {Constant} from '../core/config/constant';
import {map} from 'rxjs/operators';
import {DocumentBook} from '../core/model/domain/document-book';
import {HttpClient, HttpParams} from '@angular/common/http';
import {toString} from '@ng-bootstrap/ng-bootstrap/util/util';
import {TokenService} from '../core/authen/token.service';

@Injectable({
  providedIn: 'root'
})
export class CalendarService {

  constructor(private apiHelper: ApiHelper, private tokenService: TokenService) {
  }

  getCalendar(month: number, year: number) {
    let param = new HttpParams().set('month', month.toString()).set('year', year.toString());
    return this.apiHelper.post(Constant.CALENDAR.GET, param).pipe(map(data => data.data));
  }

  addCalendar(calendar: any) {
    return this.apiHelper.post(Constant.CALENDAR.ADD, calendar).pipe(map(data => data.data));
  }

  addCalendarJoin(calendarJoins: any, calendarId: string) {
    return this.apiHelper.post(Constant.CALENDAR.ADD_JOIN + calendarId, calendarJoins).pipe(map(data => data.data));
  }

  getCalendarJoin(calendarId) {
    return this.apiHelper.get(Constant.CALENDAR.GET_USER_JOIN + calendarId).pipe(map(data => data.data));
  }

  finByBookBy(status: number) {
    if (this.tokenService.getUserInfo()) {
      let userLogin = JSON.parse(this.tokenService.getUserInfo());
      if (userLogin) {
        let params = new HttpParams().set("bookBy", userLogin.id).set('status', String(status));
        console.log(params);
        return this.apiHelper.post(Constant.CALENDAR.FIND_BY_BOOK_BY, params).pipe(map(data => data.data));
      }
    }
  }

  finByName(status: number, title: string) {
    if (this.tokenService.getUserInfo()) {
      let userLogin = JSON.parse(this.tokenService.getUserInfo());
      if (userLogin) {
        let params = new HttpParams().set("bookBy", userLogin.id).set('status', String(status)).set("title", title);
        console.log(params);
        return this.apiHelper.post(Constant.CALENDAR.FIND_BY_TITLE, params).pipe(map(data => data.data));
      }
    }
  }
}
