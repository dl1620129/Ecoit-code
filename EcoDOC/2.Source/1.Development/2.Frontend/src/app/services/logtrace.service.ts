import { Injectable } from '@angular/core';
import { ApiHelper } from 'src/app/core/rest/api-helper';
import { Logtrace } from 'src/app/core/model/domain/logtrace';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LogtraceService {
  logtraces: Logtrace[];
  logtrace: Logtrace;
  constructor(
    private apihelper: ApiHelper,
  ) { }

  // Param : startDate=2019-05-07&endDate=2021-05-07&page=1&quarterly=2&month=5&year=2020&idCat=1
  searchAdmin(params: string): Observable<any> {
    return this.apihelper.get('/log/searchAdmin?' + params).pipe(map(data => data.data));
  }
  searchDoc(params: string): Observable<any> {
    return this.apihelper.get('/log/searchDoc?' + params).pipe(map(data => data.data));
  }

}
