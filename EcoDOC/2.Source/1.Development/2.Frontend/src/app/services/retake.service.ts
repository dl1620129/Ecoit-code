import { Injectable } from '@angular/core';
import { ApiHelper } from '../core/rest/api-helper';
import { Constant } from '../core/config/constant';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { IProcess } from '../core/model/domain/process';
import { Comments } from '../core/model/domain/comments';

@Injectable({
  providedIn: 'root'
})
export class RetakeService {

  constructor(private apiHelper: ApiHelper) { }

  getDocumentOut(params=''): Observable<any> {
    return this.apiHelper.get('/document/list-retake?' + params)
                          .pipe(map(res => res.data));
  }

  doAdvancedSearchDocumentOut(param): Observable<any> {
    return this.apiHelper.get('/document/search-retake?' + param)
                        .pipe(map(res => res.data));
  }

  doBasicSearchDocumentOut(param): Observable<any> {
    return this.apiHelper.get('/document/quick-retake?' + param)
                        .pipe(map(res => res.data));
  }

  doRetakeDocumentOut(documentId, retakeComment: Comments, files=[]): Observable<any> {
    let formData: FormData = new FormData();

    files = retakeComment.attachments || []

    for (let i = 0; i < files.length; i++) {
      formData.append('files', files[i])
    }
    formData.append("comment", retakeComment.comment);
    
    return this.apiHelper.post('/document/force-retake/' + documentId, formData);
  }

  doUnretakeDocumentOut(documentId, retakeComment: Comments, files=[]): Observable<any> {
    let formData: FormData = new FormData();

    files = retakeComment.attachments || []

    for (let i = 0; i < files.length; i++) {
      formData.append('files', files[i])
    }
    formData.append("comment", retakeComment.comment);
    
    return this.apiHelper.post('/document/restore/' + documentId, formData);
  }

  getRetookDocumentOut(params) {
    return this.apiHelper.get('/document/list-retaken' + '?' + params)
                          .pipe(map(res => res.data));
  }

  doBasicSearchRetookDocumentOut(param): Observable<any> {
    return this.apiHelper.get('/document/quick-retaken?' + param)
                        .pipe(map(res => res.data));
  }

  doAdvancedSearchRetookDocumentOut(params): Observable<any> {
    return this.apiHelper.get('/document/search-retaken' + '?' + params)
                          .pipe(map(res => res.data));
  }


  getRetookDocumentIn(params) {
    return this.apiHelper.get('/document_out/searchListIssued?retaked=true&' + params)
                          .pipe(map(res => res.data));
  }

  doBasicSearchRetookDocumentIn(params): Observable<any> {
    return this.apiHelper.get('/document_out/searchBasicIssued?retaked=true&' + params)
                        .pipe(map(res => res.data));
  }

  doAdvancedSearchReTookDocumentIn(params): Observable<any> {
    return this.apiHelper.get('/document_out/searchListIssued?retaked=true&' + params)
                        .pipe(map(res => res.data));
  }


  getDocumentIn(params): Observable<any> {
    return this.apiHelper.get(Constant.RETAKE.GET_DOCUMENT_IN + '?' + params)
                          .pipe(map(res => res.data));
  }

  doAdvancedSearchDocumentIn(param): Observable<any> {
    return this.apiHelper.get('/document_out/searchListIssued?' + param)
                        .pipe(map(res => res.data));
  }

  doBasicSearchDocumentIn(param): Observable<any> {
    return this.apiHelper.get('/document_out/searchBasicIssued?' + param)
                        .pipe(map(res => res.data));
  }

  doUnretakeDraft(docId, comment): Observable<any> {
    const params = {
      docId: docId,
      comment: comment
    }
    return this.apiHelper.post("/document_out/restore", null, {params: params})
  }
}
