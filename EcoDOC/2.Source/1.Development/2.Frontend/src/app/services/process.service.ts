import { Injectable } from '@angular/core';
import { ApiHelper } from '../core/rest/api-helper';
import { Constant } from '../core/config/constant';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { IProcess } from '../core/model/domain/process';

@Injectable({
  providedIn: 'root'
})
export class ProcessService {

  constructor(private apiHelper: ApiHelper) { }

  search(params={}): Observable<any> {
    return this.apiHelper.get(Constant.PROCESS.SEARCH, { params: params })
                          .pipe(map(res => res.data));
  }

  getAll(params): Observable<any> {
    return this.apiHelper.get(Constant.PROCESS.GET_ALL, { params: params })
                          .pipe(map(res => res.data));
  }

  getById(id): Observable<IProcess> {
    return this.apiHelper.get(Constant.PROCESS.GET_BY_ID + id)
                          .pipe(map(res => res.data));
  }

  doDeleteProcess(id): Observable<any> {
    return this.apiHelper.post(Constant.PROCESS.DELETE + id, {}).pipe(map(res => res.data));
  }

  activeProcess(process: IProcess): Observable<any> {
    return this.apiHelper.post(Constant.PROCESS.ACTIVE + process.id, process).pipe(map(res => res.data));
  }

  deactiveProcess(process: IProcess): Observable<any> {
    return this.apiHelper.post(Constant.PROCESS.DEACTIVE + process.id, process).pipe(map(res => res.data));
  }

  doSaveProcess(process, id): Observable<any> {
    return this.apiHelper.post(Constant.PROCESS.UPDATE + id, process).pipe(map(res => res.data));
  }

  doSaveNewProcess(process): Observable<any> {
    return this.apiHelper.post(Constant.PROCESS.ADD, process).pipe(map(res => res.data));
  }
}
