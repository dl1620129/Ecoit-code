import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {ApiHelper} from '../core/rest/api-helper';
import {Constant} from '../core/config/constant';

@Injectable({providedIn: 'root'})
export class PermissionService {

  constructor(private apiHelper: ApiHelper) {
  }

  getRole(): Observable<any[]> {
    return this.apiHelper.get(Constant.GET_ROLE).pipe(map(data => data.data));
  }

  getUserByRole(roleId): Observable<any[]> {
    return this.apiHelper.get(Constant.GET_USER_BY_ROLE + roleId).pipe(map(data => data.data));
  }

  doSaveRole(role) {
    if (role.id)
      return this.apiHelper.post(Constant.UPDATE_ROLE + role.id, role).pipe(map(data => data.data));
    else
      return this.apiHelper.post(Constant.ADD_ROLE, role).pipe(map(data => data.data));
  }

  doAssignUserToRole(userList, roleId) {
    return this.apiHelper.post(Constant.ADD_USER_ROLE_PATCH + roleId, userList).pipe(map(data => data.data));
  }

  doActiveUserToRole(userId, roleId) {
    return this.apiHelper.get(Constant.ACTIVE_USER_ROLE + roleId + "/" + userId).pipe(map(data => data.data));
  }

  doSaveModuleToRole(moduleList, roleId) {
    return this.apiHelper.post(Constant.ADD_PERMISSION + roleId, moduleList).pipe(map(data => data.data))
  }
  doActiveOrDeactiveRole(role) {
    if (role.active === true) {
      return this.apiHelper.get(Constant.DEACTIVE_ROLE + role.id);
    } else {
      return this.apiHelper.get(Constant.ACTIVE_ROLE + role.id);
    }
  }
  doDeleteRole(id) {
    return this.apiHelper.post(Constant.DELETE_ROLE + id, id);
  }

  getPositionByRole(roleId): Observable<any[]> {
    return this.apiHelper.get(Constant.GET_POSITION_BY_ROLE + roleId).pipe(map(data => data.data));
  }
  doAssignPositionToRole(posList, roleId) {
    return this.apiHelper.post(Constant.ADD_POSITION_ROLE_PATCH + roleId, posList).pipe(map(data => data.data));
  }
  doActivePositionToRole(posId, roleId) {
    return this.apiHelper.get(Constant.ACTIVE_POSITION_ROLE + roleId + "/" + posId).pipe(map(data => data.data));
  }

}
