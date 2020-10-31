import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { CommonService } from './common.service';
import { Constants } from '../common/constants';
import { Organization } from '../model/organization.model';

declare const Liferay: any;

@Injectable({
  providedIn: 'root'
})export class PhoneBookService {
    constructor(private http: HttpClient) {}

    public getFilteredUsers(searchForm: any) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let body = {
            'organizationId': searchForm.get('organizationId').value,
            'searchKey': searchForm.get('searchKey').value
        };
        console.log(body);

        let createUrl = Constants.baseUrl + '/o/phonebook/app/search-user/' + Constants.userId;
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(CommonService.handleError));
    }

    public getAllOrganization(){
        let getUrl = Constants.baseUrl + '/o/phonebook/app/get/' + Constants.scopeGroupId + '/all-org';
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public getUser(id: any){
        let getUrl = Constants.baseUrl + '/o/phonebook/app/get/item/' + id;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    //delete user
    public deleteUser(id: number) {
        let url = Constants.baseUrl + '/o/phonebook/app/delete/' + Constants.userId + '/' + id;
        return this.http.delete(url).pipe(catchError(CommonService.handleError));
    }

    public submitUser(userForm: any, id: any) {
        let body = {
            "firstName": userForm.get("firstName").value,
            "middleName": userForm.get("middleName").value,
            "lastName": userForm.get("lastName").value,
            "birthDate": userForm.get("birthDate").value,
            "gender": userForm.get("gender").value,
            "screenName": userForm.getRawValue().screenName,
            "email": userForm.get("email").value,
            "password": userForm.get("password").value,
            "passwordReset": userForm.get("passwordReset").value,
            "organizationId": userForm.get("organizationId").value,
            "jobTitle": userForm.get("jobTitle").value,
            "phoneNumber": userForm.get("phoneNumber").value
        }
        console.log(body);

        if (id && id > 0) {
            let updateUrl = Constants.baseUrl + '/o/phonebook/app/update/' + Constants.languageId + '/' + Constants.userId + '/' + Constants.companyId + '/' + id;
            return this.http.put(updateUrl, body).pipe(catchError(CommonService.handleError));
        }

        let createUrl = Constants.baseUrl + '/o/phonebook/app/create/' + Constants.languageId + '/' + Constants.userId + '/' + Constants.companyId;
        return this.http.post(createUrl, body).pipe(catchError(CommonService.handleError));
    }

    convertTreeList(treeList: Organization[], level: number) {
        let listOfOrganizations = new Array<Organization>();
        treeList.forEach((element: Organization) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element['name'];
            let newElement = element;
            newElement.name = newTitle;
            listOfOrganizations.push(newElement);
            let childList = this.convertTreeList(element.child, level+1);
            childList.forEach((childElement: Organization) => {
                listOfOrganizations.push(childElement);
            });
        });
        return listOfOrganizations;
    }
}