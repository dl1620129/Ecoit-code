import {Injectable} from '@angular/core';
import {ApiHelper} from '../core/rest/api-helper';
import {Observable} from 'rxjs';
import {Constant} from '../core/config/constant';
import {map} from 'rxjs/operators';
import { CommonUtils } from '../core/common/common-utils';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PdfViewComponent } from '../shared/pdf-view/pdf-view.component';
import { TokenService } from '../core/authen/token.service';
import { TranslateService } from '@ngx-translate/core';
import { ViewFileService, VerifierPDF } from './signature.service';

@Injectable({
  providedIn: 'root'
})
export class UploadFileService {

  constructor(
    private apiHelper: ApiHelper,
    private modalService: NgbModal,
    private commomUtils: CommonUtils,
    private tokenService: TokenService,
    private translateService: TranslateService,
    private viewFileService: ViewFileService,
    private verifierService: VerifierPDF
  ) {
  }

  uploadFile(file: File): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('file', file);
    return this.apiHelper.post("/files/upload", formData).pipe(map(res => res.data));
  }

  deleteDocumentOutAttachment(attachmentId): Observable<any> {
    return this.apiHelper.post('/attachment/deleteById/' + attachmentId, {}).pipe(map(res => res.data));
  }

  getFile(name): Observable<any> {
    return this.apiHelper.get('/taskAtt/download/' + encodeURIComponent(name), {responseType: 'blob'});
  }

  getFileToView(name, type): Observable<any> {
    let url = this.getDownloadFileUrl(type);
    return this.getValidatedFile(name, url);
  }

  getValidatedFile(name, url=''): Observable<any> {
    return this.apiHelper.get(url + encodeURIComponent(name), {responseType: 'blob'});
  }

  viewFile(fileName, type) {
    if (fileName.indexOf(".pdf") > 0) {
      this.viewPdfFile(fileName, type);
    } else {
      this.viewDocFile(fileName, type);
    }
  }

  viewPdfFile(fileName, type) {
    const modalRef = this.modalService.open(PdfViewComponent, {centered: true, size: 'lg', windowClass: 'modal-full'});
    modalRef.componentInstance.fileName = fileName;
    modalRef.componentInstance.type = type;
  }

  viewDocFile(fileName, type) {
    let prms = {};
    let userInfo = JSON.parse(this.tokenService.getUserInfo());
    prms['fileName'] = fileName;
    prms['apiDownload'] = Constant.API_ENDPOINT + this.getDownloadFileUrl(type);
    prms['apiUpload'] = "";
    prms['token'] = this.tokenService.getToken();
    this.viewFileService.viewDocFile(prms, (data) => {
      console.log(data);
      if (data == "-1")
        this.commomUtils.showPopupOK(this.translateService.instant('file.download-error'));
      else if (data == "-2")
        this.commomUtils.showPopupOK(this.translateService.instant('file.open-word-error'));
      else if (data == "-100")
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-no-connect'));
    });
  }

  verifierPDF(fileName, type) {
    let prms = {};
    let userInfo = JSON.parse(this.tokenService.getUserInfo());
    prms['fileName'] = fileName;
    prms['apiDownload'] = Constant.API_ENDPOINT + this.getDownloadFileUrl(type);
    prms['apiUpload'] = "";
    prms['token'] = this.tokenService.getToken();
    this.verifierService.VerifierPDF(prms, (data) => {
      console.log(data);
      if (data == "-1")
        this.commomUtils.showPopupOK(this.translateService.instant('file.download-error'));
      else if (data == "-2")
        this.commomUtils.showPopupOK(this.translateService.instant('file.open-word-error'));
      else if (data == "-100")
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-no-connect'));
    });
  }

  getDownloadFileUrl(fileType) : string {
    switch (fileType) {
      case Constant.ATTACHMENT_DOWNLOAD_TYPE.DOCUMENT_IN:
        return '/doc_out_attach/download/'
      case Constant.ATTACHMENT_DOWNLOAD_TYPE.DOCUMENT_OUT:
        return '/attachment/download/'
      case Constant.ATTACHMENT_DOWNLOAD_TYPE.DOCUMENT_OUT_COMMENT:
        return '/attachment_comment/download/'
      case Constant.ATTACHMENT_DOWNLOAD_TYPE.DELEGATE:
        return '/delegate/download/'
      default:
        return '/files/'
    }
  }

  downloadFile(fileName, fileType='') {
    console.log('fileType', fileType)
    if(fileType) {
      let url = this.getDownloadFileUrl(fileType)
      this.downloadValidatedFile(fileName, url)
    }
    else {
      this.downloadNormalFile(fileName)
    }
  }

  downloadValidatedFile(fileName, url='') {
    this.getValidatedFile(fileName, url).subscribe(
      res => {
        fileName = fileName.replace(/__\d+$/, '');
        let dataType = res.type;
        let binaryData = [];
        binaryData.push(res);
        const blob = new Blob(binaryData, {type: dataType});
        if (window.navigator && window.navigator.msSaveOrOpenBlob) { // IE
          window.navigator.msSaveOrOpenBlob(blob, fileName);
        } else { //Chrome, Firefox
          const objectUrl: string = URL.createObjectURL(blob);
          let downloadLink = document.createElement('a');
          downloadLink.href = objectUrl;
          downloadLink.download = fileName;
          downloadLink.click();
          URL.revokeObjectURL(objectUrl);
        }
      }
    );
  }

  downloadNormalFile(fileName) {
    this.getFile(fileName).subscribe(
      res => {
        fileName = fileName.replace(/__\d+$/, '');
        let dataType = res.type;
        let binaryData = [];
        binaryData.push(res);
        const blob = new Blob(binaryData, {type: dataType});
        if (window.navigator && window.navigator.msSaveOrOpenBlob) { // IE
          window.navigator.msSaveOrOpenBlob(blob, fileName);
        } else { //Chrome, Firefox
          const objectUrl: string = URL.createObjectURL(blob);
          let downloadLink = document.createElement('a');
          downloadLink.href = objectUrl;
          downloadLink.download = fileName;
          downloadLink.click();
          URL.revokeObjectURL(objectUrl);
        }
      }
    );
  }

  validateNumberOfFileUpload(selectedFiles, currentUploadedFiles, isRemove): boolean {
    let selectedFilesSize
    if (selectedFiles == undefined) {
      selectedFilesSize = 0
    } else {
      selectedFilesSize = selectedFiles.length
    }

    if (!isRemove) {
      if ((selectedFilesSize + currentUploadedFiles.length) > Constant.MAX_FILES_UPLOAD) {
        return false
      }
    } else if ((selectedFiles.length) < Constant.MAX_FILES_UPLOAD) {
      return true
    }
    return true
  }

  doCheckFilesSize(files, selectedFiles): boolean {
    for (let file of files) {
      if (!this.doCheckFileSize(file)) {
        return false;
      }
    }
    return true;
  }

  doCheckFileSize(file): boolean {
    if (file && file.size <= Constant.MAX_SIZE_FILE_UPLOAD) return true;
    return false;
  }

  isExistFile(fileName, selectedFiles): boolean {
    for (let file of selectedFiles) {
      if (file.name == fileName) return true;
    }
    return false;
  }

  doCheckFileExtension(files): boolean {
    for (const file of files) {
      const extension = file.name.split('.')[file.name.split('.').length - 1]
      if (!Constant.ALLOWED_FILE_EXTENSION.includes('.' + extension)) {
        return false
      }
    }
    return true
  }

  doCheckFileExtensionImage(files): boolean {
    for (const file of files) {
      const extension = file.name.split('.')[file.name.split('.').length - 1]
      if (!Constant.ALLOWED_FILE_IMAGE.includes('.' + extension)) {
        return false
      }
    }
    return true
  }
}
