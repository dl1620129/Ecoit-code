import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { ApiHelper } from '../core/rest/api-helper';
import { HttpClient } from '@angular/common/http';
import { Constant } from '../core/config/constant';
// import { ApiHelper } from '../core/rest/api-helper';
// import { map } from 'rxjs/operators';
import { Delegate } from '../core/model/domain/delegate';
import { Observable } from 'rxjs';

enum DraftTabNames {
  CHOXULY = 'waitHandleTab',
  // CHOCHOYKIEN = 'waitCommentTab',
  DAXULY = 'handledTab',
}

@Injectable({
  providedIn: 'root'
})
export class DelegateService {

  constructor(private apiHelper: ApiHelper, private http: HttpClient) { }

  getDocumentByHandleTypeAndStatus(handleType: number, status: number, params={}) {
    return this.apiHelper.get('/document/getListDelegatedDocs/'
                               + handleType + '/' + status + '?' + params
                               ).pipe(map(res => res.data));
  }

  getDraftList(tab): Observable<any> {
    let api = ''

    if (tab == DraftTabNames.CHOXULY) {
      api = '/delegate/handling'
    }
    else if (tab == DraftTabNames.DAXULY) {
      api = '/doc_out_process/handling/delegate-handled'
    }

    return this.apiHelper.get(api).pipe(map(res => res.data));
  }

  searchBasicDraft(tab, params): Observable<any> {
    let api = ''

    if (tab == DraftTabNames.CHOXULY) {
      api = '/delegate/handling/search'
    }
    else if (tab == DraftTabNames.DAXULY) {
      api = '/doc_out_process/handling/delegate-handled/search-advance'
    }

    return this.apiHelper.get(api + '?' + params).pipe(map(res => res.data));
  }

  searchAnvancedDraft(tab, params): Observable<any> {
    let api = ''

    if (tab == DraftTabNames.CHOXULY) {
      api = '/delegate/handling/search-advance'
    }
    else if (tab == DraftTabNames.DAXULY) {
      api = '/doc_out_process/handling/delegate-handled/search-advance'
    }

    return this.apiHelper.get(api + '?' + params).pipe(map(res => res.data));
  }

  addDelegate(params) {
    return this.apiHelper.post('/delegate/add', params).pipe(map(data => data.data));
  }
  updateDelegate(params) {
    return this.apiHelper.post('/delegate/update', params).pipe(map(data => data.data));
  }
  getDelegateList(param) {
    return this.apiHelper.get('/delegate/list?' + param).pipe(map(res => res.data));
  }
  searchBasicDelegate(param) {
    return this.apiHelper.get('/delegate/quick-search?' + param).pipe(map(res => res.data));
  }
  searchAdvanceDelegate(param) {
    return this.apiHelper.get('/delegate/search?' + param).pipe(map(res => res.data));
  }

  docOutTransfer(){}
  docOutTransferDone(){}
  docOutReject(){}

  docInTransfer(docList, transferComment, main, supports, shows, org_main, org_support, org_show, node,  files): Observable<any> {
    let formData  = new FormData();
    // formData.append('docIds', docList);
    formData.append('files', files);
    formData.append('comment', transferComment);
    // formData.append('main', main);
    // formData.append('supports', supports);
    // formData.append('shows', shows);
    formData.append('node', node);

    main = main || []
    for (let i = 0; i < main.length; i++) {
      formData.append('main', main[i]);
    }

    supports = supports || []
    for (let i = 0; i < supports.length; i++) {
      formData.append('support', supports[i]);
    }

    shows = shows || []
    for (let i = 0; i < shows.length; i++) {
      formData.append('show', shows[i]);
    }

    org_main = org_main || []
    for (let i = 0; i < org_main.length; i++) {
      formData.append('org_main', org_main[i]);
    }

    org_support = org_support || []
    for (let i = 0; i < org_support.length; i++) {
      formData.append('org_support', org_support[i]);
    }

    org_show = org_show || []
    for (let i = 0; i < org_show.length; i++) {
      formData.append('org_show', org_show[i]);
    }

    return this.apiHelper.post(Constant.DELEGATE.IN_TRANSFER + docList, formData);
  }
  docInTransferDone(documentId, doneComment, files, tab=''): Observable<any> {
    let formData  = new FormData();
    if (files && files.length > 0) {
      for (let file of files) {
          formData.append('files', file);
      }
    }

    formData.append('comment', doneComment);
    if (!tab) {
      return this.apiHelper.post(Constant.DELEGATE.IN_TRANSFER_DONE + documentId, formData);
    }
    else {
      return this.apiHelper.post(Constant.DELEGATE.IN_TRANSFER_DONE + documentId + '?' + 'tab=' + tab, formData);
    }
  }
  docInReject(documentId, rejectComment, files): Observable<any> {
    const formData  = new FormData();
    if (files && files.length > 0) {
      for (let file of files) {
          formData.append('files', file);
      }
    }
    formData.append('comment', rejectComment);
    return this.apiHelper.post(Constant.DELEGATE.IN_REJECT + documentId, formData);
  }
  getDelegateToUserList(fromUserId) {
    return this.apiHelper.get('/users/findListDelegateUser/' + fromUserId).pipe(map(res => res.data));
  }
  getDelegateFromUserList() {
    return this.apiHelper.get('/users/getListNguoiUyQuyen').pipe(map(res => res.data));
  }
}
