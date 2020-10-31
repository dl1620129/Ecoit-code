import {Injectable} from '@angular/core';
import {ApiHelper} from 'src/app/core/rest/api-helper';
// import { CategoryTypeResponse } from 'src/app/base/model/response/category-type-response';
import {Observable} from 'rxjs';
import {HttpClient, HttpParams} from '@angular/common/http';
// import { CategoryType } from 'src/app/base/model/domain/category-type';
import {map} from 'rxjs/operators';
import {User} from 'src/app/core/model/domain/user';
import {Constant} from "../core/config/constant";
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users: User[];

  constructor(
    private apiHelper: ApiHelper,
    private router: Router
  ) {
  }

  getUserList() {
    this.getAllUsers().subscribe(
      data => {
        console.log(data);
        if (data) {
          this.users = data;
        }
      }
    );
  }

  getAllUsers(params = {}): Observable<User[]> {
    return this.apiHelper.get('/users/getAllSort/ASC/id', {params: params}).pipe(map(data => data.data));
  }

  public addUser(user: User) {
    return this.apiHelper.post('/users/addUser', user).pipe(map(data => data.data));
  }

  public ActiveDeactiveUser(user: User) {
    console.log('user.id == ', user.id, user.email);
    if (user.active === true) {
      return this.apiHelper.get('/users/deactive/' + user.id);
    } else {
      return this.apiHelper.get('/users/active/' + user.id);
    }
  }

  public updateUser(user: User) {
    return this.apiHelper.post('/users/update/' + user.id, user);
  }

  public getUsersActive(): Observable<User[]> {
    return this.apiHelper.get('/users/getActive').pipe(map(data => data.data));
  }

  public searchUser(params): Observable<any> {
    return this.apiHelper.get('/users/findUser?' + params).pipe(map(data => data.data));
  }

  public searchUserActive(textSearch: string): Observable<any> {
    let params = new HttpParams().set("textSearch", textSearch);
    return this.apiHelper.post(Constant.USER.SEARCH_USER_ORG,params).pipe(map(data => data.data));
  }

  public searchUserActive1(textSearch: string): Observable<any> {
    let params = new HttpParams().set("textSearch", textSearch);
    return this.apiHelper.post(Constant.USER.SEARCH_USER_ACTIVE1,params).pipe(map(data => data.data));
  }

  getAllUserByLead(): Observable<any> {
    return this.apiHelper.get('/users/getAllUserByLead').pipe(map(data => data.data));
  }

  findByUserName(userName: string): Observable<any> {
    let params = new HttpParams().set("userName", userName);
    return this.apiHelper.post('/users/findByUserName', params);
  }

  getAllUsersOrderPosition(): Observable<User[]> {
    return this.apiHelper.get('/users/getAllOrder').pipe(map(data => data.data));
  }

  getAllUsersByOrg(orgId): Observable<any> {
    return this.apiHelper.get('/users/findListUserByOrg/' + orgId).pipe(map(data => data.data));
  }

  changePassword(currentPassword: String, newPassword: String) {
    return this.apiHelper.put(`/users/oauth/password?oPassword=${currentPassword}&nPassword=${newPassword}`, '');
  }

  goToEditPageInfo(userName: String, isAdmin=false ) {
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this.router.navigate([`/users/detail/${userName}`], { queryParams: { isAdmin: isAdmin } }));
  }
}
