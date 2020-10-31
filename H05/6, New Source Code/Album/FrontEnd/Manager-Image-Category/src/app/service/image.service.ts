import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { ImageModel } from '../model/image.model';

@Injectable({providedIn: 'root'})
export class ImageService {
    constructor(private httpClient: HttpClient) { }

    
    public createImageMutiple(imageModel: ImageModel,id:number,imageName:string,fileImages:File[]){
        if(imageModel.images==undefined){
            imageModel.images=null;
        }
        
        let body= new FormData();
        for (let index = 0; index < fileImages.length; index++) {
            body.append('images', fileImages[index]);
        }
        body.append('categoryId',id.toString());
            body.append('title', imageName);
        
        let url= Constants.baseUrl+Constants.imagelUrl+'createMutiple/'+Constants.groupId+'/'+Constants.userId;
        return this.httpClient.post(url, body).pipe(catchError(CommonService.handleError));
         
    }
    public getAllImage(limit: number, start: number, keyWord: string) {
        let url = Constants.baseUrl + Constants.imagelUrl + 'getall/' + Constants.groupId + '?limit=' + limit + '&start=' + start + '&q=' + keyWord;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getAllCategory() {
        let url = Constants.baseUrl + '/o/image/app/category/getall/' + Constants.groupId + '?limit=&start=&q=';
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public deleteImage(id: number) {
        let url = Constants.baseUrl + Constants.imagelUrl + 'delete/' + Constants.groupId + '/' + Constants.userId + '/' + id;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }

    public getImage(id: number) {
        let url = Constants.baseUrl + Constants.imagelUrl + 'getimage/' + Constants.groupId + '/' + Constants.userId + '/' + id;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));

    }
    public createImage(imageModel: ImageModel) {
        if (imageModel.images == undefined) {
            imageModel.images = null;
        } if (imageModel.title == undefined) {
            imageModel.title = '';
        } if (imageModel.description == undefined) {
            imageModel.description = '';
        } if (imageModel.thuTu == undefined) {
            imageModel.thuTu = 0;
        } if (imageModel.tacGia == undefined) {
            imageModel.tacGia = '';
        } if (imageModel.isDaiDien == undefined) {
            imageModel.isDaiDien = false;
        } if (imageModel.categoryId == undefined) {
            imageModel.categoryId = 0;
        }


        let body = new FormData();
        body.append('title', imageModel.title);
        body.append('description', imageModel.description);
        body.append('thuTu', imageModel.thuTu.toString());
        body.append('tacGia', imageModel.tacGia);
        body.append('isDaiDien', JSON.stringify(imageModel.isDaiDien));
        body.append('categoryId', imageModel.categoryId.toString());
            body.append('images', imageModel.images);
           
        let url = Constants.baseUrl + Constants.imagelUrl + 'create/' + Constants.groupId + '/' + Constants.userId;
        return this.httpClient.post(url, body).pipe(catchError(CommonService.handleError));

    }
    public deleteMutiple(ids: any[]){
        let url= Constants.baseUrl+Constants.imagelUrl+'delete-mutiple/'+Constants.groupId+'/'+Constants.userId;
        const body= new FormData();
        body.append('ids',ids.toString());
        return this.httpClient.post(url,body).pipe(catchError(CommonService.handleError));
    }
    public updateImage(imageModel: ImageModel, id: number) {
        if (imageModel.images == undefined) {
            imageModel.images = null;
        } if (imageModel.title == undefined) {
            imageModel.title = '';
        } if (imageModel.description == undefined) {
            imageModel.description = '';
        } if (imageModel.thuTu == undefined) {
            imageModel.thuTu = 0;
        } if (imageModel.tacGia == undefined) {
            imageModel.tacGia = '';
        } if (imageModel.isDaiDien == undefined) {
            imageModel.isDaiDien = false;
        } if (imageModel.categoryId == undefined) {
            imageModel.categoryId = 0;
        }


        let body = new FormData();
        body.append('images', imageModel.images);
        body.append('title', imageModel.title);
        body.append('description', imageModel.description);
        body.append('thuTu', imageModel.thuTu.toString());
        body.append('tacGia', imageModel.tacGia);
        body.append('isDaiDien', JSON.stringify(imageModel.isDaiDien));
        body.append('categoryId', imageModel.categoryId.toString());
      
        let url = Constants.baseUrl + Constants.imagelUrl + 'update/' + Constants.groupId + '/' + Constants.userId + '/' + id;
        return this.httpClient.put(url, body).pipe(catchError(CommonService.handleError));
    }

}