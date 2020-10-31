import {Injectable} from '@angular/core';
import {ApiHelper} from "../core/rest/api-helper";
import {Constant} from "../core/config/constant";
import {map} from "rxjs/operators";
import {HttpClient, HttpParams} from "@angular/common/http";
import {toString} from "@ng-bootstrap/ng-bootstrap/util/util";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ModuleAdminService {

  constructor(private apiHelper: ApiHelper, private http: HttpClient) {
  }

  getAllModuleAdmin() {
    return this.apiHelper.get(Constant.MODULE_ADMIN.GETALL).pipe(map(data => data.data));
  }

  doSaveModuleAdmin(moduleadmin, moduleadminId) {
    console.log("moduleadmin")
    console.log(moduleadmin)
    console.log("moduleadminId")
    console.log(moduleadminId)
    return this.apiHelper.post(Constant.MODULE_ADMIN.UPDATE + moduleadminId, moduleadmin).pipe(map(res => res.data));
  }

  doSaveNewModuleAdmin(moduleadmin): Observable<any> {
    console.log(moduleadmin)
    return this.apiHelper.post(Constant.MODULE_ADMIN.CREATE, moduleadmin).pipe(map(res => res.data));
  }

  activeModuleAdmin(moduleadminId): Observable<any> {
    return this.apiHelper.get(Constant.MODULE_ADMIN.ACTIVE + moduleadminId).pipe(map(res => {
        console.log(res)
    }));
  }

  deactiveModuleAdmin(moduleadminId): Observable<any> {
    return this.apiHelper.get(Constant.MODULE_ADMIN.DEACTIVE + moduleadminId).pipe(map(res => {
        console.log(res)
    }));
  }

  public searchModuleAdmin(params): Observable<any> {
    return this.apiHelper.post(Constant.MODULE_ADMIN.SEARCH, params).pipe(map(data => data.data));
  }

}
