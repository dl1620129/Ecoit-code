import { Injectable } from '@angular/core';
import { ApiHelper } from '../core/rest/api-helper';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Constant } from '../core/config/constant';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BpmnService {
  currentSelectedNodeID;
  currentNodeOrg: any[];
  currentNodeUser: any[];

  constructor(
    private apiHelper: ApiHelper,
  ) { }

  getStartNode(bpmnid) {
    return this.apiHelper.get('/bpmn2/' + bpmnid + '/start-node').pipe(map(data => data.data));
  }
  getNextNode(nodeid) {
    return this.apiHelper.get('/bpmn2/next-node/' + nodeid).pipe(map(data => data.data));
  }
  getListStartNode(type) {
    return this.apiHelper.get('/bpmn2/start-node/' + type).pipe(map(data => data.data));
  }

  getBPMNActive (type) {
    return this.apiHelper.get(Constant.THREAD.GET_BPMN_BY_TYPE + type).pipe(map(data => data.data));
  }
  getUsersByNode(nodeId) {
    return this.apiHelper.get('/bpmn2/node/' + nodeId + '/users').pipe(map(data => data.data));
  }
}
