import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiHelper } from '../core/rest/api-helper';
import { Constant } from '../core/config/constant';
import { map } from "rxjs/operators";
import { Folder } from '../core/model/doucment/folder';
import { Decentralization } from '../core/model/decentralization/decentralization';
import { Rule } from '../core/model/domain/Rules';
import { HttpParams } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { AlfrescoDocumentModel } from '../core/model/domain/alfresco_document';



@Injectable({
    providedIn: 'root'
})
export class DocumentService {
    constructor(private apiHelper: ApiHelper) { }

    public createFolder(folder: Folder, ticKet: string, nodeId: string) {
        let body = {
            "name": folder.name,
            "ticKet": ticKet,
            "nodeId": nodeId,
            "title": folder.title,
            "description": folder.description
        }
        return this.apiHelper.post(Constant.ALFRESCO.CREAT_FOLDER, body);
    }
    public updateFolder(folder: Folder, ticKet: string, nodeId: string) {
        let body = {
            "prop_cm_name": folder.name,
            "ticKet": ticKet,
            "nodeId": nodeId,
            "prop_cm_title": folder.title,
            "prop_cm_description": folder.description,
            "prop_cm_taggable": "",
            "prop_cm_taggable_isCategory": "true"
        }
        return this.apiHelper.post(Constant.ALFRESCO_DOCUMENT.UPDATE, body);
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
    public deactiveFolderDB(ticKet: String, nodeIds: String[]){
        return this.apiHelper.get(Constant.FOLDER.DEACTIVE + '?ticKet=' + ticKet + '&nodeId=' + nodeIds);
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

    public createFileDb(name: string, title: string, description: string, fileId: string, folderId: string, luongId: number) {
        if (folderId == '' || folderId == null) folderId = '-root-';
        let body = {
            "name": name,
            "title": title,
            "description": description,
            "active": true,
            "fileId": fileId,
            "folderId": folderId,
            "luongId": luongId
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
            "description": folder.description,
            "title": folder.title,
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
        return this.apiHelper.post(Constant.FOLDER.UPDATE + nodeId, body);
    }
    public getLuong() {
        return this.apiHelper.get(Constant.PROCESS.SEARCH);
    }
    deActiveFile(id: string) {
        return this.apiHelper.get(Constant.FILE.DEACTIVE + '/' + id);
    }
    deActiveFolder(id: string) {
        return this.apiHelper.get(Constant.FOLDER.DEACTIVE + '/' + id);
    }
    public getview(ticKet: String, nodeId: String) {
        return this.apiHelper.get(Constant.ALFRESCO.DOWNLOAD_AS_ZIP + '?ticKet=' + ticKet + '&downloadId=' + nodeId, { responseType: 'image' });
    }
    public img(ticKet: String, nodeId: String) {
        return this.apiHelper.get(Constant.ALFRESCO.DOWNLOAD_AS_ZIP + '?ticKet=' + ticKet + '&downloadId=' + nodeId, { responseType: 'blob' });
    }
    public previewDocument(ticKet: String, nodeId: String, type: String) {
        return this.apiHelper.get(Constant.ALFRESCO.PREVIEW_DOCUMENT + '?ticKet=' + ticKet + '&nodeId=' + nodeId + '&type=' + type, { responseType: 'blob' });
    }
    public addDecen(decen: Decentralization, nodeId: String, nodeType: number, type: number, idPermission: number) {
        let body = {
            "role": decen.role,
            "nodeType": nodeType,
            "nodeId": nodeId,
            "type": type,
            "idPermission": idPermission,
        }
        return this.apiHelper.post(Constant.DECENTRALIZATION.ADDDECEN, body).pipe(map(data => data.data));
    }

    public getAllComment(ticKet: String, nodeId: String, skipCount: number, maxItems: number) {

        return this.apiHelper.get(Constant.ALFRESCO.GET_ALL_COMMENT + '?ticKet=' + ticKet + '&nodeId=' + nodeId + '&skipCount=' + skipCount + '&maxItems=' + maxItems);
    }
    public deleteComment(ticKet: String, nodeId: String, id: string) {
        console.log(Constant.ALFRESCO.DELETE_COMMENT + '?ticKet=' + ticKet + '&nodeId=' + nodeId + '&id=' + id)
        return this.apiHelper.post(Constant.ALFRESCO.DELETE_COMMENT + '?ticKet=' + ticKet + '&nodeId=' + nodeId + '&id=' + id, null);
    }
    public getProperties(ticKet: String, nodeId: String) {
        console.log(Constant.ALFRESCO.GET_PROPERTIES + '?ticKet=' + ticKet + '&nodeId=' + nodeId)
        return this.apiHelper.get(Constant.ALFRESCO.GET_PROPERTIES + '?ticKet=' + ticKet + '&nodeId=' + nodeId);
    }


    public updateDecen(decen: Decentralization) {
        let body = {
            "id": decen.id,
            "role": decen.role,
        }
        return this.apiHelper.post(Constant.DECENTRALIZATION.UPDATEDECEN, body);
    }
    public creatComment(ticKet: string, nodeId: String, comment: string) {

        return this.apiHelper.post(Constant.ALFRESCO.CREATE_COMMENT + '?ticKet=' + ticKet + '&nodeId=' + nodeId + '&comment=' + comment, null);
    }
    public liveSearch(ticKet: String, t: String, startIndex: number, totalRecords: number) {
        console.log(Constant.ALFRESCO.LIVE_SEARCH + '?ticKet=' + ticKet + '&t=' + t + '&startIndex=' + startIndex + '&totalRecords=' + totalRecords);
        return this.apiHelper.get(Constant.ALFRESCO.LIVE_SEARCH + '?ticKet=' + ticKet + '&t=' + t + '&startIndex=' + startIndex + '&totalRecords=' + totalRecords);
    }
    public getAllRules(nodeId, ticKet) {
        return this.apiHelper.get(Constant.ALFRESCO_RULES.GET_ALL + '?ticKet=' + ticKet + '&nodeId=' + nodeId);
    }
    public deleteRules(nodeId, ticKet, ruleId) {
        return this.apiHelper.get(Constant.ALFRESCO_RULES.DELETE + nodeId + '?ticKet=' + ticKet + '&ruleId=' + ruleId);
    }
    public createRulesAlfresco(ticket: string, nodeId: String, rulesModel: Rule) {
        console.log(rulesModel);
        let body = {
            "ticKet": ticket,
            "nodeId": nodeId,
            "title": rulesModel.title,
            "disabled": rulesModel.disabled,
            "applyToChildren": rulesModel.applyToChildren,
            "executeAsynchronously": rulesModel.executeAsynchronously,
            "description": rulesModel.description,
            "actionDefinitionName": rulesModel.actionDefinitionName,
            "conditionDefinitionName": rulesModel.conditionDefinitionName,
            "actionsDefinitionName": rulesModel.actionsDefinitionName,
            "typeName": rulesModel.typeName,
            "ruleType": rulesModel.ruleType,
            "actionDefinitionNameCha": rulesModel.actionDefinitionNameCha,

        }
        return this.apiHelper.post(Constant.ALFRESCO_RULES.ADD, body);
    }
    public copyFile(ticKet: string, nodeId: string, targetParentId: string) {
        return this.apiHelper.post(Constant.ALFRESCO.COPY_FILE + '?ticKet=' + ticKet + '&nodeId=' + nodeId + '&targetParentId=' + targetParentId, null);
    }
    public createDocument(alfrescoDocument: AlfrescoDocumentModel, ticKet: string, nodeId: string) {
        let body = {
            'nodeId': nodeId,
            'name': alfrescoDocument.name,
            'content': alfrescoDocument.content,
            'title': alfrescoDocument.title,
            'description': alfrescoDocument.description,
            'mimetype': 'text/html',
            'editInline': 'true',
            'ticKet': ticKet
        }
        return this.apiHelper.post(Constant.ALFRESCO_DOCUMENT.CREATE, body);
    }
    public updateDocument(alfrescoDocument: AlfrescoDocumentModel, ticKet: string, nodeId: string) {
        let body = {
            'nodeId': nodeId,
            'name': alfrescoDocument.name,
            'title': alfrescoDocument.title,
            'description': alfrescoDocument.description,
            'prop_cm_taggable': '',
            'prop_cm_taggable_isCategory': 'true',
            'ticKet': ticKet
        }
        return this.apiHelper.post(Constant.ALFRESCO_DOCUMENT.UPDATE, body);
    }
    public moveFile(ticKet: string, nodeId: string, targetParentId: string) {
        return this.apiHelper.post(Constant.ALFRESCO.MOVE_FILE + '?ticKet=' + ticKet + '&nodeId=' + nodeId + '&targetParentId=' + targetParentId, null);
    }
    public editproperties(ticKet: string, nodeId: string, name: string, title: string, description: string, author: string) {
        return this.apiHelper.post(Constant.ALFRESCO.EDIT_PROPERTIES + '?ticKet=' + ticKet + '&nodeId=' + nodeId + '&name=' + name + '&title=' + title + '&description=' + description + '&author=' + author, null);
    }
    public uploadFile(files: File[], ticKet: string, filename: string, updateNodeRef: string, majorversion: string, overwrite: string, updatenameandmimetype: string) {
        let body = new FormData()
        body.append("filedata", files[0])
        body.append("ticKet", ticKet)
        body.append("filename", filename)
        body.append("updateNodeRef", updateNodeRef)
        body.append("majorversion", majorversion)
        body.append("overwrite", overwrite)
        body.append("updatenameandmimetype", updatenameandmimetype)
        return this.apiHelper.post(Constant.ALFRESCO.UPLOAD_FILE, body);
    }

 
    createDocumentDB(document: AlfrescoDocumentModel, folderId: string, fileId: string) {
      return this.apiHelper.post(Constant.DOCUMENTDB.CREATE_DOCUMENT_DB + folderId + '/' + fileId, document)
    }

    updateDocumentDB(document: AlfrescoDocumentModel, folderId: string, fileId: string, documentName: string) {
      return this.apiHelper.post(Constant.DOCUMENTDB.UPDATE_DOCUMENT_DB + folderId + '/' + fileId + '/' + documentName, document)
    }

    deleteDocumentDB (folderId: string, fileId: string, documentName: string) {
      return this.apiHelper.get(Constant.DOCUMENTDB.DELETE_DOCUMENT_DB + folderId + '/' + fileId + '/' + documentName)
    }
   public generatePreview(ticKet : string, nodeId :string, minetype :string){
        return this.apiHelper.get(Constant.ALFRESCO.GENERATE_PREVIEW+ '?ticKet='+ticKet+'&nodeId='+nodeId +'&mimeType='+minetype);
    }
}
