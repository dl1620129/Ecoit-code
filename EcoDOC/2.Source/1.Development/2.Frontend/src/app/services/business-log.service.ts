import { Injectable } from '@angular/core';
import { ApiHelper } from '../core/rest/api-helper';
import { Constant } from '../core/config/constant';
import { map } from 'rxjs/operators';
import { IBusinessLog } from '../core/model/domain/business-log';
import { Observable } from 'rxjs';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BusinessLogService {

  constructor(private apiHelper: ApiHelper) { }
  searchBusinessLog(params): Observable<any> {
    return this.apiHelper.get(Constant.BUSINESS_LOG.SEARCH, { params: params })
                          .pipe(map(res => res.data));
  }
  exportBusinessLog(params): Observable<any> {
    return this.apiHelper.get(Constant.BUSINESS_LOG.EXPORT, { params: params })
                          .pipe(map(res => res.data));
  }
}
