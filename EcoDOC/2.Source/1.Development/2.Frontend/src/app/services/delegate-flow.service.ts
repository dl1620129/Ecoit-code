import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { ApiHelper } from '../core/rest/api-helper';

@Injectable({
  providedIn: 'root'
})
export class DelegateFlowService {

  constructor(
    private apiHelper: ApiHelper,
  ) { }

  addDelegateFlow(body) {
    return this.apiHelper.post('/delegate_flow/add', body).pipe(map(data => data.data));
  }
  getDelegateFlowList(param) {
    return this.apiHelper.get('/delegate_flow/list?' + param).pipe(map(data => data.data));
  }
  deleteDelegateFlow(id) {
    return this.apiHelper.post('/delegate_flow/delete/' + id, null).pipe(map(data => data));
  }
}
