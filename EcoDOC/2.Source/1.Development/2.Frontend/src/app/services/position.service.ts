import { Injectable } from '@angular/core';
import { ApiHelper } from '../core/rest/api-helper';
import { Constant } from '../core/config/constant';
import { map } from 'rxjs/operators';
import { Position } from '../core/model/domain/position';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PositionService {
  positions: Position[];

  constructor(
    private apiHelper: ApiHelper,
  ) { }

  // Start service for category type
  getWithPaginations(id: number, urlQuery): Observable<any> {
    return this.apiHelper.get(Constant.POSITION.PAGINATED + id, { params: urlQuery })
              .pipe(map(res => res.data));
  }
}
