import { Injectable } from '@angular/core';
import { ApiHelper } from 'src/app/core/rest/api-helper';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ValueService {

  constructor(
    private apihelper: ApiHelper,
  ) { }
  addValues(values) {
    return this.apihelper.post('/values/addValues', values);
  }
  updateValues(values) {
    let head = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.apihelper.post('/values/updateValues', values, { headers: head});
  }
  loadValues(catid, docid) {
    return this.apihelper.get('/values/getValues/' + catid + '/' + docid).pipe(map(res => res.data));
  }
}
