import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { UsersModel } from '../model/user.model';
import { OrganizationModel } from '../model/organization.model';


@Injectable({ providedIn: 'root' })
export class UsersService {
    constructor(private httpClient: HttpClient) { }
    roleId: any = [];
    siteId: any = [];
    public getAllOrgan() {
        let url = Constants.baseUrl + '/o/ldap/app/get-organization-portal-all/'+Constants.groupId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public updateUser(usermodel: UsersModel) {
        console.log(usermodel)
        let url = Constants.baseUrl + Constants.detailUrl + 'update-user/'+Constants.userId;
        let form= new FormData();
        form.append("fullName", usermodel.displayName.trim());
        form.append("phone", usermodel.mobile.toString());
        if(usermodel.password.trim()!=''&&usermodel.rePassword.trim()!=''){
            form.append("password", usermodel.password.trim());
            form.append("rePassword", usermodel.rePassword.trim());
        }
        // form.append("capBac", usermodel.urankId.toString());
        // form.append("chucVuDang", usermodel.positionDangId.toString());
        // form.append("chucVu", usermodel.positionId.toString());
        return this.httpClient.post(url,form).pipe(catchError(CommonService.handleError));
    }
    public getUserByMailParams() {
        let url = Constants.baseUrl + Constants.detailUrl + 'get-user-by-cn/2?cn=' + Constants.userMail;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getChucVuDang() {
        let url = Constants.baseUrl + '/o/user/app/dang/poisition/getall/' + Constants.groupId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getChucVu() {
        let url = Constants.baseUrl + '/o/user/app/position/getall/' + Constants.groupId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getCapBac() {
        let url = Constants.baseUrl + '/o/user/app/rank/getall/' + Constants.groupId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getDetailUserRank(id: number) {
        let url = Constants.baseUrl + '/o/user/app/user-rank-position/getdetail/' + Constants.groupId + '/' + id;
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
}