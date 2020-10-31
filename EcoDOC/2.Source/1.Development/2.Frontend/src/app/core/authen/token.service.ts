import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Constant} from "../config/constant";
import {Router, Routes} from "@angular/router";
import { ApiHelper } from '../rest/api-helper';
import { map } from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class TokenService {
  public userAvatar = JSON.parse(this.getUserInfo());
  public currentRoleName;
  public subModulePath = [];
  constructor(
    private http: HttpClient,
    private router: Router,
    private apiHelper: ApiHelper
    ) {
  }

  moduleParent = [];

  getModules() {
    return localStorage.getItem('modules');
  }

  getModuleAll() {
    return localStorage.getItem('moduleAll');
  }

  setModule(modulesOfUser: string, moduleAll: any[]) {
    this.moduleParent = [];
    if (modulesOfUser) {
      // moduleAll.forEach(element => {
      //   if (element.isParent) {
      //     element.isChecked = false;
      //     this.moduleParent.push(element)
      //   }
      // })
      localStorage.setItem('moduleAll', JSON.stringify(moduleAll));
      localStorage.setItem('modules', modulesOfUser);
      console.log(JSON.parse(modulesOfUser));
      this.getAllCurrentRouterPath(JSON.parse(modulesOfUser));
    }
  }

  setAuthorize(modulesOfUser) {
    let info = JSON.parse(this.getUserInfo());
    info.authorize = modulesOfUser;
    this.setUserInfo(JSON.stringify(info));
  }

  getUserInfo() {
    return localStorage.getItem('userInfo');
  }

  setUserInfo(userInfo: string) {
    localStorage.setItem('userInfo', userInfo);
  }

  getToken() {
    return localStorage.getItem('token');
  }

  getTickets() {
    return localStorage.getItem('tickets');
  }

  setToken(tokenValue: string) {
    localStorage.setItem('token', tokenValue);
  }

  setTickets(ticketsValue: string) {
    localStorage.setItem('tickets', ticketsValue);
  }

  isClericalRole() {
    const roles = JSON.parse(this.getUserInfo()).roles;
    return roles.some(role => role.name === Constant.ROLES.CLERICAL);
  }

  isClericalDocumenOut() {
    const modules = JSON.parse(this.getModules());
    const docIn = modules.find(x => x.code == 'DOCUMENT_IN');
    if(docIn && docIn != null) {
      const ddocInSub = docIn.subModule;
      const temp = ddocInSub.find(x => x.code == 'DRAFT_ISSUED');
      if(temp && temp != null) {
        console.log('isClericalDocumenOut TRUE')
        return true;
      }
    }
    console.log('isClericalDocumenOut FALSE')
    return false;
  }

  removetoken(tokenValue: string) {
    localStorage.removeItem('token');
  }

  removeTickets() {
    localStorage.removeItem('tickets');
  }

  checkAuthentication() {
    if (!this.getToken()) {
      console.log('checkAuthentication : Failed', this.getToken());
      return false;
    }
    console.log('checkAuthentication : OK', this.getToken());
    return true;
  }

  requestToken(name: string, password: string) {
    const params = new HttpParams().set('userName', name).set('password', password);
    return this.http.post<any>(Constant.API_AUTHEN, params); 
  }

  requestTickets(){
    return this.apiHelper.get(Constant.ALFRESCO.GET_TICKET).pipe(map(res => res.data.entry));
  }
  requestLoginInfo(token: string){
    const params = new HttpParams().set('token', token);
    return this.http.post<any>(Constant.API_AUTHEN_CAS, params);
  }

  initiateRouter() {
    const routerConfig: Routes = [{
      path: '',
      loadChildren: './component/dashboard/dashboard.module#DashboardModule'
    }];
    if (this.getModules()) {
      const menus = JSON.parse(this.getModules());
      menus.forEach(element => {
        if (element.isParent) {
          return routerConfig.push({
            path: '',
            loadChildren: element.componentName
          });
        }
        routerConfig.push({
          path: element.routerPath,
          component: Constant.COMPONENT_CODE[element.componentName]
        });
      });
      console.log('EcoDOC: Router info after login: ', routerConfig);
      return routerConfig;
    }
  }

  logout() {
    this.setToken(null);
    this.removetoken('token');
    localStorage.removeItem('modules');
    localStorage.removeItem('moduleParent');
    localStorage.removeItem('menuSideBar');
    this.removeTickets()
    localStorage.clear();
    if (Constant.AUTHEN_CAS)
      window.location.href = Constant.LOGOUT;
    else
      this.router.navigateByUrl("/login")
  }

  getAuthorizeByRole(id){
    // return this.apiHelper.get('/module/getModules/' + id).pipe(map(res => res.data));
    return this.apiHelper.get('/users/switchRole/' + id).pipe(map(res => res.data));
  }
  updateDefaultRole(id) {
    let params = new HttpParams();
    params = params.set('roleId', id);
    return this.apiHelper.post('/users/updateDefaultRole?', params).pipe(map(res => res.data));
  }
  setLocalDefaultRole(roleId) {
    let info = JSON.parse(this.getUserInfo());
    info.defaultRole = roleId;
    this.setUserInfo(JSON.stringify(info));
  }
  getLocalDefaultRole() {
    let info = JSON.parse(this.getUserInfo());
    return info.defaultRole;
  }
  getAllCurrentRouterPath(modules) {
    this.subModulePath = [];
    this.getRouterPath(modules);
    this.setLocalSubModulePath(this.subModulePath);
  }
  getRouterPath(modules){
    modules.forEach(
      x => {
        if(x.parentId != null) {
          if(x.routerPath != "") {
            this.subModulePath.push(x.routerPath);
          }
        }
        if(x.subModule && x.subModule.length > 0) {
          this.getRouterPath(x.subModule);
        }
      }
    );

  }
  getLocalSubModulePath() {
    return localStorage.getItem('subModulePath');
  }
  setLocalSubModulePath(path) {
    return localStorage.setItem('subModulePath', JSON.stringify(path));
  }
  getCurrentRoleName(roleId){
    let roles = JSON.parse(this.getUserInfo()).roles;
    let obj;
    if(roles) {
      obj = roles.find( x => x.id == roleId);
    }
    this.currentRoleName = obj ? obj.name : '';
  }
  setLocalCurrentRole(roleId) {
    let info = JSON.parse(this.getUserInfo());
    info.currentRole = roleId;
    this.setUserInfo(JSON.stringify(info));
  }
  getLocalCurrentRole() {
    let info = JSON.parse(this.getUserInfo());
    return info && info.currentRole ? info.currentRole : null;
  }
}
