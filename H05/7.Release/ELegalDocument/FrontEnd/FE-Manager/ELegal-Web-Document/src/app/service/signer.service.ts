import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';
import { CommonService } from './common.service';

@Injectable({
    providedIn: 'root'
})export class SignerService {

    constructor(private http: HttpClient) { };
    
    public getSignersList(start: number, pageSize: number, searchKey: string) {
        let url = Constants.baseUrl + '/o/legalsigner/app/getall/' + Constants.scopeGroupId + '/' + Constants.companyId + '?start=' + start + '&limit=' + pageSize + '&q=' + searchKey;
        return this.http.get(url).pipe(catchError(CommonService.handleError));
    }
}
