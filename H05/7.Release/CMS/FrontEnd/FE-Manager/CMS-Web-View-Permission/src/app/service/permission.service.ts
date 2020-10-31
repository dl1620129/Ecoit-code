import { Injectable, ErrorHandler } from '@angular/core';
import { HttpClient,HttpHeaders, HttpClientModule, HttpParams } from '@angular/common/http';
import { Observable, from } from 'rxjs';
import { PermissionModel } from '../model/PermissionModel.model';
import { AxiosInstance } from 'axios';
import axios from "axios";
import { catchError } from 'rxjs/operators';
import { Constants } from '../common/Constants'
import { TokenParams } from '../model/Tokenparams.model';
import LiferayParams from '../../types/LiferayParams'
import { Category } from '../model/CategoryModel.model';
import { CommonService } from './common.service';

declare const Liferay: any;
@Injectable({
    providedIn: 'root',
})


export class PermissionService {
    // url: 'http://118.71.99.245:5000/o/permisstion/app';
    // tokenApi: 'http://118.71.99.245:5000/o/oauth2/token';
    
    tokenParams: TokenParams = new TokenParams();
    params: LiferayParams;
    labels: any;
    accessToken= '';

    constructor(private httpClient: HttpClient) {
     
     }
    getToken(){
        let url = Constants.baseUrl +'/o/oauth2/token';
        const headers = new HttpHeaders({
            'Content-Type': 'application/x-www-form-urlencoded'
            // ,'Access-Control-Allow-Origin' : '*'
          });
          const body = new HttpParams()
            .set('client_id', Constants.client_id)
            .set('grant_type', 'client_credentials')
            .set('client_secret',Constants.client_secret);
        console.log('body: '+body);
        return  this.httpClient.post(url, body.toString() , {headers: headers });
    }

    // getAllPermission(access_token_:String): Observable<PermissionModel[]>{
    //     let url = Constants.baseUrl+ '/o/permisstion/app/update/view/3/'+Constants.groupId;
    //     const headersForGetAll = new HttpHeaders();
    //     console.log(url);
    //     console.log(`Authorization`,  `Bearer ${access_token_}`)
    //     headersForGetAll.append(`Authorization`,  `Bearer ${access_token_}`);
    //     return this.httpClient.get<PermissionModel[]>(url,{headers : headersForGetAll
    //         });
    // }
    getAllPermission(start: number, pageSize:number, searchKey: string ){
        
        let url = Constants.baseUrl+ Constants.detailUrl+'getall/'+Constants.groupId+'/'+Constants.languageId+'?limit='+pageSize+'&start='+start+'&q='+searchKey;
        // const headersForGetAll = new HttpHeaders();
        // console.log(url);
        // console.log(`Authorization`,  `Bearer ${access_token_}`)
        // headersForGetAll.append(`Authorization`,  `Bearer ${access_token_}`);
        // console.log(url);
        return this.httpClient.get(url);
    }
    getRoleConstant(){
        let url = Constants.baseUrl+ '/o/permission/app/get/role-constant';
        return this.httpClient.get(url);
    }
    viewPermission(){
        let url = Constants.baseUrl+ Constants.detailUrl+'view/'+Constants.groupId+'/'+Constants.languageId+'/'+Constants.userId;
        return this.httpClient.get(url);
    }
    savePermission(groupName: String, description: String, users: any, permissions: any, categories: any){
        let url = Constants.baseUrl+ '/o/permission/app/create/'+Constants.groupId+'/'+Constants.languageId;
        const headers = new HttpHeaders({
            'Content-Type': 'application/json'
            ,'Access-Control-Allow-Origin' : '*'
          });
        let params = JSON.stringify({
            groupName: groupName,
            description: description,
            users: users,
            permissions: permissions,
            categories: categories
        })
        return this.httpClient.post<PermissionModel>(url,params,{headers: headers});
    }
    // getPermissionById(id: number): Observable<any>{
    //     let url = Constants.baseUrl+ '/o/permission/app/update/view/3/'+Constants.groupId+'/20130';
    //     return this.httpClient.get<any>(url+id);
    // }
    viewSearch(id: number){
        let url = Constants.baseUrl+ '/o/permission/app/view/'+Constants.groupId+'/'+id+'/'+Constants.languageId+'/users/search';
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    deletePermission(id: number){
        // console.log('id: '+JSON.stringify(permissionModel.groupUserId));
        let url = Constants.baseUrl+ Constants.detailUrl+'delete/'+id+'/'+Constants.groupId;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
    updatePermission(permistionId: number,groupName: String, description: String, users: any, permissions: any, categories: any) {
        let url = Constants.baseUrl+ '/o/permission/app/update/'+permistionId+'/'+Constants.groupId+'/'+Constants.languageId;
        const headers = new HttpHeaders({
            'Content-Type': 'application/json'
            ,'Access-Control-Allow-Origin' : '*'
          });
        let params = JSON.stringify({
            groupName: groupName,
            description: description,
            users: users,
            permissions: permissions,
            categories: categories
        })
        console.log("params: ", params);
        return this.httpClient.put(url, params, {headers: headers}).pipe(catchError(CommonService.handleError));

    }
    updateViewPermission(id: number): Observable<any>{
        let url = Constants.baseUrl+ '/o/permission/app/update/view/'+id+'/'+Constants.groupId+'/'+Constants.userId+'/'+Constants.languageId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    createViewSearchPermission() {
        let url = Constants.baseUrl+ '/o/permission/app/view/'+Constants.groupId+'/'+Constants.languageId + '/users/search';
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    getAllCategory(){
        let url = Constants.baseUrl+ '/o/category/app/getall/'+Constants.groupId+'/'+Constants.languageId+'/'+Constants.userId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    convertTreeList(treeList: Category[], level: number, listOfCategories: Category[]) {
        treeList.forEach((element: Category) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element['title'];
            let newElement = new Category(newTitle, element.cateId, element.parentId, element.orderNumber, element.createDate, element.child);
            listOfCategories.push(newElement);
            this.convertTreeList(element['child'], level+1, listOfCategories);
        });
    }
}