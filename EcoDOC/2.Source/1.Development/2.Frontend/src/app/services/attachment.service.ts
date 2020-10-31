import { Injectable } from "@angular/core";
import { ApiHelper } from "../core/rest/api-helper";
import { Constant } from "../core/config/constant";
import { map } from "rxjs/operators";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class AttachmentService {
    constructor(
        private apiHelper: ApiHelper,
    ) { }

    doSaveAttachment(attachment, attachmentId): Observable<any> {
        return this.apiHelper.post(Constant.ATTACHMENT.ADD + attachmentId, attachment).pipe(map(res => res.data));
    }

    doSaveNewAttachment(type, documentId, files: File[]): Observable<any> {
      const formData: FormData = new FormData();
      console.log("files", files)
      files = files || []
      for (let i = 0; i < files.length; i++) {
        formData.append('files', files[i])
      }
  
      return this.apiHelper.post(`/attachment/addAttachment/${documentId}`, formData);
    }

    doActiveAttachment(attachmentId): Observable<any> {
        return this.apiHelper.get(Constant.ATTACHMENT.ACTIVE + attachmentId).pipe(map(res => res.data));
    }

    doDeactiveAttachment(attachmentId): Observable<any> {
        return this.apiHelper.get(Constant.ATTACHMENT.DEACTIVE + attachmentId).pipe(map(res => res.data));
    }

    doDeleteAttachment(attachmentId): Observable<any> {
        return this.apiHelper.get(Constant.ATTACHMENT.DELETE + attachmentId).pipe(map(res => res.data));
    }

    doDeleteAttachmentByDocId(documentId): Observable<any> {
        return this.apiHelper.post(Constant.ATTACHMENT.DELETE_BY_DOC + documentId, null);
    }

    doSaveNewAttachmentInDraft(attachment, type, typeId): Observable<any> {
        if (type=='document') {
        return this.apiHelper.post(`/doc_out_attach/add/relate/${typeId}`, attachment).pipe(map(res => res.data));
        }
        return this.apiHelper.post(`/doc_out_attach/add/draft/${typeId}`, attachment).pipe(map(res => res.data));
    }
}