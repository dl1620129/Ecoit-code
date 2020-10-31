import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiHelper } from '../core/rest/api-helper';
import { Constant } from '../core/config/constant';
import { map } from "rxjs/operators";
import { Folder } from '../core/model/doucment/folder';
@Injectable({
    providedIn: 'root'
})
export class DocumentService {
    constructor(private apiHelper: ApiHelper) { }

    public createFolder(folder: Folder, ticKet: string, nodeId: string) {
        let body = {
            "name": folder.name,
            "ticKet": ticKet,
            "nodeId": nodeId
        }
        return this.apiHelper.post(Constant.ALFRESCO.CREAT_FOLDER, body);
    }
    public updateFolder(folder: Folder, ticKet: string, nodeId: string) {
        let body = {
            "name": folder.name,
            "ticKet": ticKet,
            "nodeId": nodeId
        }
        return this.apiHelper.post(Constant.ALFRESCO.UPDATE_FOLDER, body);
    }
    public createFile(files: File[], ticKet: string, nodeId: string) {
        if (nodeId == null || nodeId == undefined) {
            nodeId = "";
        }
        let body = new FormData()
        for (let index = 0; index < files.length; index++) {
            body.append("filedata", files[index])
        }
        body.append("ticKet", ticKet)
        body.append("nodeId", nodeId)
        return this.apiHelper.post(Constant.ALFRESCO.CREAT_FILE, body);
    }
    public getTicket() {
        return this.apiHelper.get(Constant.ALFRESCO.GET_TICKET);
    }
    public getFolder(ticKet: string, nodeId: string) {
        return this.apiHelper.get(Constant.ALFRESCO.GET_FOLDER + '?ticKet=' + ticKet + '&nodeId=' + nodeId);
    }
    public downLoad(nodeId: string, ticKet: string) {
        return this.apiHelper.get(Constant.ALFRESCO.DOWNLOAD + '?ticKet=' + ticKet + '&nodeId=' + nodeId);
    }
    public getAllFolder(ticKet: String, nodeId: String, type: number, orderBy: number, name: string, start: number, pageSize: number) {
        if (nodeId == null) {
            nodeId = '';
        }
        return this.apiHelper.get(Constant.ALFRESCO.GET_ALL + '?ticKet=' + ticKet + '&nodeId=' + nodeId + '&type=' + type + '&orderBy=' + orderBy + '&name=' + name 
        + '&start=' + start + '&pageSize=' + pageSize);
    }
    public deleteFolder(ticKet: String, nodeIds: String[]) {
        return this.apiHelper.get(Constant.ALFRESCO.DELETE + '?ticKet=' + ticKet + '&nodeId=' + nodeIds);
    }
    public asZip(ticKet: String, nodeId: String) {
        let body = {
            "ticKet": ticKet,
            "nodeId": nodeId
        }
        return this.apiHelper.post(Constant.ALFRESCO.AS_ZIP, body);

    }
    public getAsZipFile(ticKet: String, nodeId: String) {
        return this.apiHelper.get(Constant.ALFRESCO.GET_AS_ZIP + '?ticKet=' + ticKet + '&downloadId=' + nodeId);
    }
    public downloadAsZipFile(ticKet: String, nodeId: String) {
        return this.apiHelper.get(Constant.ALFRESCO.DOWNLOAD_AS_ZIP + '?ticKet=' + ticKet + '&downloadId=' + nodeId, { responseType: 'blob' });
    }
    public getAllFile(ticKet: String, nodeId: String, type: number, orderBy: number, name: string) {
        if (nodeId == null) {
            nodeId = '';
        }
        return this.apiHelper.get(Constant.ALFRESCO.GET_ALL + '?ticKet=' + ticKet + '&nodeId=' + nodeId + '&type=' + type + '&orderBy=' + orderBy + '&name=' + name);
    }
    public getIdFile(ticKet: String, nodeId: String) {
        return this.apiHelper.get(Constant.ALFRESCO.GET_IDFILE + '?ticKet=' + ticKet + '&nodeId=' + nodeId);
    }

    public createFileDb(name: string, fileId: String, folderId: string, luongId: number) {
        if (folderId == '' || folderId == null) folderId = '-root-';
        let body = {
            "name": name,
            "active": true,
            "fileId": fileId,
            "folderId": folderId,
            "luongId" : luongId
        }
        return this.apiHelper.post(Constant.FILE.CREATE, body);
    }
    public updateFileDb(folder: Folder, fileId: string, folderId: string) {
        if (folderId == '' || folderId == null) folderId = '-root-';
        let body = {
            "name": folder.name,
            "active": true,
            "fileId": fileId,
            "folderId": folderId
        }
        console.log(body);

        return this.apiHelper.post(Constant.FILE.UPDATE + 1, body);
    }
    public createFolderDb(folder: Folder, nodeId: String, parentNodeId: string) {
        if (parentNodeId == '' || parentNodeId == null) parentNodeId = '-root-';
        let body = {
            "name": folder.name,
            "nodeId": nodeId,
            "parentNodeId": parentNodeId
        }

        return this.apiHelper.post(Constant.FOLDER.CREATE, body);
    }
    public updateFolderDb(folder: Folder, nodeId: String, parentNodeId: string) {
        if (parentNodeId == '' || parentNodeId == null) parentNodeId = '-root-';
        let body = {
            "name": folder.name,
            "nodeId": nodeId,
            "parentNodeId": parentNodeId
        }
        return this.apiHelper.post(Constant.FOLDER.UPDATE + 1, body);
    }
    public getLuong(){
        return this.apiHelper.get(Constant.PROCESS.SEARCH);
    }
    deActiveFile(id:string){
        return this.apiHelper.get(Constant.FILE.DEACTIVE+'/'+id);
    }
    deActiveFolder(id:string){
        return this.apiHelper.get(Constant.FOLDER.DEACTIVE+'/'+id);
    }
    public getview(ticKet:String,nodeId:String){
        return this.apiHelper.get(Constant.ALFRESCO.DOWNLOAD_AS_ZIP+'?ticKet='+ticKet+'&downloadId='+nodeId,{responseType: 'image'});
    }
    public img(ticKet:String,nodeId:String){
        return this.apiHelper.get(Constant.ALFRESCO.DOWNLOAD_AS_ZIP+'?ticKet='+ticKet+'&downloadId='+nodeId,{responseType: 'blob'});
    }
    public previewDocument(ticKet: String, nodeId: String, type: String){
        return this.apiHelper.get(Constant.ALFRESCO.PREVIEW_DOCUMENT+'?ticKet='+ticKet+'&nodeId='+nodeId+'&type='+type,{responseType: 'blob'});
    }
    public addDecen(nodeId: string, idPermission: number, role: string){
        let body = {
            "species": 0,
            "nodeId": nodeId,
            "position": 1,
            "role": role,
            "idPermission": idPermission,
        }
        return this.apiHelper.post(Constant.DECENTRALIZATION.ADDDECEN, body);
    }
}