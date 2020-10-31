import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';
import { CommonService } from './common.service';

@Injectable({
    providedIn: 'root'
})export class UserService {

    constructor(private http: HttpClient) { };
    
    public getUsers(searchKey: any) {
        let url = Constants.baseUrl + '/o/article/app/get/user/' + Constants.scopeGroupId + '?q=' + searchKey + '&limit=5';
        return this.http.get(url).pipe(catchError(CommonService.handleError));
    }
}
