import { Injectable } from '@angular/core';
import { ApiHelper } from '../core/rest/api-helper';
import { Constant } from '../core/config/constant';
import {map} from "rxjs/operators";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PreferencesService {

  constructor(private apiHelper: ApiHelper, private http: HttpClient) { 

  }

  getAllPreferences() {
    return this.apiHelper.get(Constant.PREFERENCES.GETALL);
  }

  doSavePreferences(preferences, preferencesId) {
    console.log("moduleadmin")
    console.log(preferences)
    console.log("moduleadminId")
    console.log(preferencesId)
    return this.apiHelper.post(Constant.PREFERENCES.UPDATE + preferencesId, preferences).pipe(map(res => res.data));
  }

  doSaveNewPreferences(preferences): Observable<any> {
    console.log(preferences)
    return this.apiHelper.post(Constant.PREFERENCES.CREATE, preferences).pipe(map(res => res.data));
  }

  activePreferences(preferencesId): Observable<any> {
    return this.apiHelper.get(Constant.PREFERENCES.ACTIVE + preferencesId).pipe(map(res => {
        console.log(res)
    }));
  }

  deactivePreferences(preferencesId): Observable<any> {
    return this.apiHelper.get(Constant.PREFERENCES.DEACTIVE + preferencesId).pipe(map(res => {
        console.log(res)
    }));
  }

  public searchPreferences(params): Observable<any> {
    return this.apiHelper.post(Constant.PREFERENCES.SEARCH, params).pipe(map(data => data.data));
  }

}
