import { Injectable } from '@angular/core';
import { ApiHelper } from '../core/rest/api-helper';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Constant } from '../core/config/constant';

@Injectable({
  providedIn: 'root'
})
export class OrganizationService {

  constructor(
    private apiHelper: ApiHelper
  ) { }

  getOrganizations(params={}): Observable<any[]> {
    return this.apiHelper.get(Constant.ORGANIZATION.GET_ALL + Constant.DIRECTION.ASC + "/name", {params: params}).pipe(map(res => res.data));
  }

  searchRootOrganizations(params={}): Observable<any[]> {
    return this.apiHelper.get(Constant.ORGANIZATION.GET_LIST_ROOT, {params: params})
                          .pipe(map(res => res.data));
  }

  getRootOrganizations(params={}): Observable<any[]> {
    return this.apiHelper.get(Constant.ORGANIZATION.GET_ALL + Constant.DIRECTION.ASC + "/id").pipe(map(res => res.data));
  }

  doSaveOrganization(organization, organizationId): Observable<any> {
    return this.apiHelper.post(Constant.ORGANIZATION.UPDATE + organizationId, organization).pipe(map(res => res.data));
  }

  doSaveNewOrganization(organization): Observable<any> {
    return this.apiHelper.post(Constant.ORGANIZATION.ADD, organization).pipe(map(res => res.data));
  }

  activeOrganization(organizationId): Observable<any> {
    return this.apiHelper.get(Constant.ORGANIZATION.ACTIVE + organizationId).pipe(map(res => res.data));
  }

  deactiveOrganization(organizationId): Observable<any> {
    return this.apiHelper.get(Constant.ORGANIZATION.DEACTIVE + organizationId).pipe(map(res => res.data));
  }

  searchOrganization(page, data) {
    return this.apiHelper.post(Constant.ORGANIZATION.SEARCH + page, data).pipe(map(res => res.data));
  }
}
