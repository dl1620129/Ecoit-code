import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { DomSanitizer } from '@angular/platform-browser';
import { Constants } from '../common/Constants';
import { ClipModel } from '../model/Clip.model';
import { CommonService } from './common.service';
import { catchError } from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class ClipService {
    constructor(private httpClient: HttpClient,private sanitizer: DomSanitizer) { }

    public getAllClip(limit: number, start: number, keyWord: string){
        let url=Constants.baseUrl+'/o/clip/app/getall/'+Constants.groupId+'?limit='+limit+'&start='+start+'&q='+keyWord;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public deleteClip(id: number){
        let url=Constants.baseUrl+'/o/clip/app/delete/'+Constants.groupId+'/'+Constants.userId+'/'+id;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
    public getClipcategory(){
        let url=Constants.baseUrl+'/o/clip/app/category/getall/'+Constants.groupId+'?limit=&start=0&q=';
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getClipById(id: number){
        let url=Constants.baseUrl+'/o/clip/app/getclip/'+Constants.groupId+'/'+Constants.userId+'/'+id;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
        
    }
    public createClip(clipModel:ClipModel){
        let url=Constants.baseUrl+'/o/clip/app/create/'+Constants.groupId+'/'+Constants.userId;
        if(clipModel.title==undefined){
            clipModel.title='';
        } if(clipModel.description==undefined){
            clipModel.description='';
        } if(clipModel.nguonVideo==undefined){
            clipModel.nguonVideo='';
        } if(clipModel.tacGia==undefined){
            clipModel.tacGia='';
        } if(clipModel.thoiLuongVideo==undefined){
            clipModel.thoiLuongVideo='';
        } 
        clipModel.isDaiDien=true;
        let fd = new FormData();
        fd.append('videos',clipModel.videos);

        fd.append('title',clipModel.title.trim());
        fd.append('description',clipModel.description.trim());
        fd.append('nguonVideo',clipModel.nguonVideo.trim());
        fd.append('tacGia',clipModel.tacGia.trim());
        fd.append('thoiLuongVideo',clipModel.thoiLuongVideo);
        fd.append('isDaiDien',JSON.stringify(clipModel.isDaiDien));
        fd.append('display',JSON.stringify(clipModel.display));
        fd.append('categoryId',clipModel.categoryId.toString());
        fd.append('videos',clipModel.videos);
        fd.append('clipFileId',JSON.stringify(clipModel.clipFileId));
        
        console.log('videos: '+JSON.stringify(clipModel.videos));
        return this.httpClient.post(url, fd).pipe(catchError(CommonService.handleError));
    }
    public deleteMutiple(ids: any[]){
        let url= Constants.baseUrl+'/o/clip/app/delete-mutiple/'+Constants.groupId+'/'+Constants.userId;
        const body= new FormData();
        body.append('ids',ids.toString());
        return this.httpClient.post(url,body).pipe(catchError(CommonService.handleError));
    }
    public updateClip(clipModel:ClipModel, id: number){
        let url=Constants.baseUrl+'/o/clip/app/update/'+Constants.groupId+'/'+Constants.userId+'/'+id;
        if(clipModel.title==undefined){
            clipModel.title='';
        } if(clipModel.description==undefined){
            clipModel.description='';
        } if(clipModel.nguonVideo==undefined){
            clipModel.nguonVideo='';
        } if(clipModel.tacGia==undefined){
            clipModel.tacGia='';
        } if(clipModel.thoiLuongVideo==undefined){
            clipModel.thoiLuongVideo='';
        } 
        clipModel.isDaiDien=true;
        let fd = new FormData();
        fd.append('title',clipModel.title.trim());
        fd.append('description',clipModel.description.trim());
        fd.append('nguonVideo',clipModel.nguonVideo.trim());
        fd.append('tacGia',clipModel.tacGia.trim());
        fd.append('thoiLuongVideo',clipModel.thoiLuongVideo);
        fd.append('isDaiDien',JSON.stringify(clipModel.isDaiDien));
        fd.append('display',JSON.stringify(clipModel.display));
        fd.append('categoryId',clipModel.categoryId.toString());
        fd.append('clipFileId',JSON.stringify(clipModel.clipFileId));
        fd.append('videos',clipModel.videos);
        
        return this.httpClient.put(url, fd).pipe(catchError(CommonService.handleError));
    }
}