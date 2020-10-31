import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';
import { Field } from './field';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})export class ArticleService {
    constructor(private http: HttpClient) {}

    public moveDataFromList(dataList: any, sourceList: any, destinationList: any) {
      if (dataList !== 'undefined') {
        dataList.forEach((value) => {
            let index = sourceList.indexOf(value);
            sourceList.splice(index, 1);
            destinationList.push(value);
        });
        dataList.length = 0;
      }
    }


    public getFakeField() : Observable<Field[]> {
      return this.http.get<Field[]>('https://my-json-server.typicode.com/TheUnlikeable/demo/fields').pipe();
    }

    public getFakePeople() : Observable<User[]> {
      return this.http.get<User[]>('https://my-json-server.typicode.com/TheUnlikeable/demo/people').pipe();
    }
}