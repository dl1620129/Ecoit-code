import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { UsersModel } from '../model/user.model';
import { userInfo } from 'os';
import { OrganizationModel } from '../model/organization.model';
import { Observable } from 'rxjs';
import { Body } from '@angular/http/src/body';

@Injectable({ providedIn: 'root' })
export class UsersService {
    constructor(private httpClient: HttpClient) { }
    roleId: any = [];
    siteId: any = [];
    public getAllusers(orgId:number) {
        console.log(orgId);
        let url = Constants.baseUrl + Constants.detailUrl + 'get-list-user'+'/'+orgId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getOrgCha() {
        let url = Constants.baseUrl + Constants.detailUrl + 'get-organization-parent-group/'+Constants.groupId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public searchUser(searchKey: any) {
        let url = Constants.baseUrl + Constants.detailUrl + 'search-list-user?q=' + searchKey;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getUserByCnParams(screenName: any) {
        let url = Constants.baseUrl + Constants.detailUrl + 'get-user-by-cn/1?cn=' + screenName;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getUserByMailParams(mail: any) {
        let url = Constants.baseUrl + Constants.detailUrl + 'get-user-by-cn/2?cn=' + mail;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public deleteUsers(cn: string) {
        let url = Constants.baseUrl + Constants.detailUrl + 'deleteUser?cn=' + cn;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
    public getAllOrgan() {
        let url = Constants.baseUrl + '/o/ldap/app/get-organization-portal-all/'+Constants.groupId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getChucVuDang() {
        let url = Constants.baseUrl + '/o/user/app/dang/poisition/getall/' + Constants.groupId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getCapBac() {
        let url = Constants.baseUrl + '/o/user/app/rank/getall/' + Constants.groupId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getUserRole() {
        let url = Constants.baseUrl + Constants.detailUrl + 'get-role-all/' + Constants.langugeId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getUSerSiteSearch(text: string) {
        let url = Constants.baseUrl + Constants.detailUrl + 'get-site-group-all/' + Constants.langugeId + '?q=' + text;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getUSerSite() {
        let url = Constants.baseUrl + Constants.detailUrl + 'get-site-group-all/' + Constants.langugeId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getChucVu() {
        let url = Constants.baseUrl + '/o/user/app/position/getall/' + Constants.groupId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public createusers(usermodel: UsersModel, listRoleId: any[], listSiteId: any[]) {
        if (usermodel.mobile == undefined) {
            usermodel.mobile = 0;
        }
        if (usermodel.mail == undefined) {
            usermodel.mail = '';
        }
        usermodel.birthday = null;
        usermodel.sex = true;
        let form = new FormData();
        console.log(usermodel.uid);
        form.append("fullName", usermodel.displayName.trim());
        form.append("phone", usermodel.mobile.toString());
        form.append("email", usermodel.mail.trim());
        form.append("birthDay", JSON.stringify(usermodel.birthday));
        form.append("sex", JSON.stringify(usermodel.sex));
        form.append("screenName", usermodel.uid.trim());
        form.append("password", usermodel.password.trim());
        form.append("rePassword", usermodel.rePassword.trim());
        // form.append("chucVu", usermodel.title);
        form.append("organizationId", usermodel.organizationId.toString());
        if (usermodel.RoleIds!=null) {
            usermodel.RoleIds.forEach((element: any) => {
                form.append("RoleIds", element.ID.toString());
            });
        }
        if (usermodel.SiteIds!=null) {
            usermodel.SiteIds.forEach((element: any) => {
                form.append("GroupIds", element.ID.toString());
            });
        }

        let url = Constants.baseUrl + Constants.detailUrl + 'create-user/1';
        return this.httpClient.post(url, form).pipe(catchError(CommonService.handleError));

    }
    public getChucVuDetail(id:number) {
        if(id==undefined || id==null){
            id=-1;
        } 
        console.log('---'+id);
            let url = Constants.baseUrl + '/o/user/app/position/getdetail/' + Constants.groupId+'/'+id;
            return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getDonViDetail(id:number) {
        let ids=-1;
        if(id==undefined || id==null){
            ids=-1;
        }else{
            let ids=id.toString().replace('[','');
            ids=ids.toString().replace(']','');
            parseFloat(ids.trim());
        }
        console.log(ids);
        let url = Constants.baseUrl + '/o/ldap/app/get-organization-by-id/'+ids+'/1';
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public updateUser(usermodel: UsersModel, listRoleId: any[], listSiteId: any[]) {

        usermodel.birthday = null;
        usermodel.sex = true;
        if (usermodel.mobile == undefined) {
            usermodel.mobile = 0;
        }
        if (usermodel.mail == undefined) {
            usermodel.mail = null;
        }
        let form = new FormData();
        console.log(usermodel.uid);
        form.append("fullName", usermodel.displayName.trim());
        form.append("phone", usermodel.mobile.toString());
        form.append("email", usermodel.mail.trim());
        form.append("birthDay", JSON.stringify(usermodel.birthday));
        form.append("sex", JSON.stringify(usermodel.sex));
        form.append("screenName", usermodel.uid.trim());
        console.log(usermodel.password);
        if (usermodel.password != '' && usermodel.rePassword != '') {
            form.append("password", usermodel.password.trim());
            form.append("rePassword", usermodel.rePassword.trim());
        }

        // form.append("chucVu", usermodel.title);
        form.append("organizationId", usermodel.organizationId.toString());
        form.append("userId", usermodel.userId.toString());
        let url = Constants.baseUrl + Constants.detailUrl + 'create-user/2';
        if (usermodel.RoleIds!=null) {
            usermodel.RoleIds.forEach((element: any) => {
                form.append("RoleIds", element.ID.toString());
            });
        }
        if (usermodel.SiteIds!=null) {
            usermodel.SiteIds.forEach((element: any) => {
                form.append("GroupIds", element.ID.toString());
            });
        }

        return this.httpClient.post(url, form).pipe(catchError(CommonService.handleError));

    }
    public createUserRankPosition(userModel: UsersModel, userId: number) {
        let form = new FormData();
        // console.log('userId:'+userId);
        // console.log(JSON.stringify(userModel));
        form.append("userId", userId.toString());
        form.append("positionId", userModel.positionId.toString());
        form.append("urankId", userModel.urankId.toString());
        form.append("positionDangId", userModel.positionDangId.toString());
        let url = Constants.baseUrl + '/o/user/app/user-rank-position/create/' + Constants.groupId;
        return this.httpClient.post(url, form).pipe(catchError(CommonService.handleError));
    }
    public updateUserRankPoisition(userModel: UsersModel, userId: number) {
        let form = new FormData();
        // console.log('userId:'+userId);
        // console.log(JSON.stringify(userModel));
        // form.append("userId", userId.toString());
        form.append("positionId", userModel.positionId.toString());
        form.append("urankId", userModel.urankId.toString());
        form.append("positionDangId", userModel.positionDangId.toString());
        let url = Constants.baseUrl + '/o/user/app/user-rank-position/update/' + Constants.groupId + '/' + userId;
        return this.httpClient.put(url, form).pipe(catchError(CommonService.handleError));
    }
    public deleteUserRank(id: number) {
        let url = Constants.baseUrl + '/o/user/app/user-rank-position/delete/' + Constants.groupId + '/' + id;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
    public getDetailUserRank(id: number) {
        let url = Constants.baseUrl + '/o/user/app/user-rank-position/getdetail/' + Constants.groupId + '/' + id;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    activeUser(type: any, cn: String) {
        let url = Constants.baseUrl + Constants.detailUrl + 'active-user/' + Constants.groupId + '/' + type + '/' + cn;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    convertTreeList(treeList: OrganizationModel[], level: number, listOfOrganizations: OrganizationModel[]) {
        treeList.forEach((element: OrganizationModel) => {
            let newTitle = '';
            for (let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element['name'];
            let newElement = new OrganizationModel(element.ID, newTitle, element.parentName, element.parentId, element.children);
            listOfOrganizations.push(newElement);

            this.convertTreeList(element['children'], level + 1, listOfOrganizations);
        });

    }
    addChungThuSo(userModel: UsersModel,createUserId:number,uid:string){
        let form = new FormData();
        if(createUserId==undefined){
            createUserId=0;
        }
        userModel.rawData='';
        form.append("rawData", userModel.rawData);
        form.append("screenName", uid);
        form.append("userName", userModel.CommonName);
        form.append("details",JSON.stringify(userModel.details));
        form.append("serialNumber", userModel.SerialNumber);
        form.append("organization", userModel.organization);
        form.append("createUserId", createUserId.toString());
        form.append("fromDate", userModel.ValidDate.toString());
        form.append("toDate", userModel.ValidDate.toString());
        
        let url ='/o/kyso/app/create/' + Constants.groupId+'/'+Constants.userId;
        return this.httpClient.post(url, form).pipe(catchError(CommonService.handleError));
    }
    updateChungThuSo(userModel: UsersModel,createUserId:number,uid:string){
        let form = new FormData();
        if(createUserId==undefined){
            createUserId=0;
        }
        userModel.rawData='';
        form.append("rawData", userModel.rawData);
        form.append("screenName", uid);
        form.append("userName", userModel.CommonName);
        form.append("details", JSON.stringify(userModel.details));
        form.append("serialNumber", userModel.SerialNumber);
        form.append("organization", userModel.organization);
        form.append("createUserId", createUserId.toString());
        form.append("fromDate", userModel.ValidDate.toString());
        form.append("toDate", userModel.ValidDate.toString());
        // let url = Constants.baseUrl + '/o/kyso/app/update/' + Constants.groupId+'/'+Constants.userId+'/'+uid;
        let url =Constants.baseUrl+'/o/kyso/app/update/' + Constants.groupId+'/'+Constants.userId+'/'+uid;
        return this.httpClient.put(url, form).pipe(catchError(CommonService.handleError));
    }
    getChungThuSoByScreenName(sn:string){
        // let url = Constants.baseUrl + '/o/kyso/app/getKyso/' + Constants.groupId+'/'+Constants.userId+'/'+sn;
        let url = Constants.baseUrl+'/o/kyso/app/getKyso/' + Constants.groupId+'/'+Constants.userId+'/'+sn;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    getChungThuSoBySerialNumber(sn:string){
        // let url = Constants.baseUrl + '/o/kyso/app/getKySoBySerialNumber/'+sn;
        let url = Constants.baseUrl+'/o/kyso/app/getKySoBySerialNumber/'+sn;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    deleteChungThuSo(sn:string){
         // let url = Constants.baseUrl + '/o/kyso/app/getKyso/'+sn;
         let url = Constants.baseUrl+'/o/kyso/app/delete/'+sn;
         return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
    getUserbyOrg(id:number){
        let url = Constants.baseUrl+'/o/ldap/app/get-user-org/'+id
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
}