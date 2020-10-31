import { Injectable } from '@angular/core';
import { ApiHelper } from '../core/rest/api-helper';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  public countUnReadNotification;
  constructor(
    private apiHelper: ApiHelper
  ) { }

  getAllNotification(): Observable<any> {
    return this.apiHelper.get('/notification/get').pipe(map(res => res.data));
  }
  deleteNotById(not) {
    return this.apiHelper.post('/notification/delete/' + not.id, null).pipe(map(res => res.data));
  }
  updateStatus(not) {
    return this.apiHelper.post('/notification/setRead/' + not.id, null).pipe(map(res => res.data));
  }
  deleteAll() {
    return this.apiHelper.post('/notification/deleteAll', null).pipe(map(res => res.data));
  }
  checkRoleInNotification(notiId) {
    return this.apiHelper.post('/notification/checkModule/' + notiId, null).pipe(map(res => res.data));
  }
  countUnreadNotification() {
    this.apiHelper.get('/notification/countUnread').subscribe(
      res => {
        this.countUnReadNotification = res.data;
        console.log('this.countUnReadNotification : ', this.countUnReadNotification);
      }
    );
  }
}
