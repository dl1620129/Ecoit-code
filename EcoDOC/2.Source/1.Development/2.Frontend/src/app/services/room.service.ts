import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Constant} from '../core/config/constant';
import {map} from 'rxjs/operators';
import {ApiHelper} from '../core/rest/api-helper';
import {Room} from '../core/model/domain/room';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private apiHelper: ApiHelper) {
  }

  getAllRoom() {
    return this.apiHelper.get(Constant.ROOM.GET_ALL).pipe(map(data => data.data));
  }

  addRoom(room: Room): Observable<any> {
    return this.apiHelper.post(Constant.ROOM.ADD_ROOM, room);
  }

  UpdateRoom(room: Room, id: number) {
    return this.apiHelper.post(Constant.ROOM.UPDATE_ROOM + id, room);
  }

  findBYId(id: number) {
    return this.apiHelper.get(Constant.ROOM.findById + id).pipe(map(data => data.data));
  }

  findByName(name: string) {
    console.log(name);
    let param = new HttpParams().set('name', name);
    return this.apiHelper.post(Constant.ROOM.findByName, param).pipe(map(data => data.data));
  }

  getByOrg(org): Observable<any[]> {
    return this.apiHelper.get(Constant.ROOM.GET_BY_ORG + org).pipe(map(data => data.data));
  }
}

