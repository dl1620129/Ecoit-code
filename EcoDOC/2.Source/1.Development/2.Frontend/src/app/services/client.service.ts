import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import { ApiHelper } from '../core/rest/api-helper';
import { Constant } from '../core/config/constant';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private apiHelper: ApiHelper) { }
  getClients(): Observable<any[]> {
    return this.apiHelper.get(Constant.GET_CLIENTS).pipe(map(data => data.data));
  }
}
