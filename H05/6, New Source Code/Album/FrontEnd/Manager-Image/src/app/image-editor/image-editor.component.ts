import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
import { ImageService } from "../service/image.service";
import { ImageModel } from "../model/image.model";
declare const Liferay: any;
@Component({
    selector: 'app-editor',
    templateUrl:
        Liferay.ThemeDisplay.getPathContext() +
        '/o/Manager-Image/app/image-editor.component.html'
})
export class ImageEditorComponent implements OnInit {
    imgSrc: any;
    imageList: ImageModel[] = new Array();
    constructor(public service: ImageService, public router: ActivatedRoute, public rt: Router, public notifierService: NotifierService) { }
    imageModel: ImageModel = new ImageModel();
    imageId: any;
    categories: any;
    urlim: string;
    formDisplay=true;
    ngOnInit() {
        this.service.getAllCategory().subscribe((res: any) => {
            this.categories = res.data.data;
        })
        this.router.paramMap.subscribe((params: ParamMap) => {
            this.imageId = params.get('id');
        })
        if (this.imageId != null) {
            this.service.getImage(this.imageId).subscribe((res: any) => {
                this.formDisplay=false;
                this.imageModel = res.data;
                this.urlim = res.data.imageUrl;
                this.urlim = this.urlim.split("/")[4];

            });
        }
    }
    addImage() {
        if (this.imageList.length <= 7) {
            this.imageList.push(new ImageModel());
        }
    }
    deleteImage(index: any) {
        console.log(index);
        this.imageList.splice(index, 1);
        this.fileImages.splice(index, 1);
        
    }

    deletevideo() {
        this.urlim = '';
    }
    validExts = [".jpg", ".png", ".jpeg", ".gif"];
    
    processFile( event: any) {
        let fileExt = event.target.value;
        if (fileExt != '') {
            fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
            if (this.validExts.indexOf(fileExt.toLowerCase()) < 0) {
                alert("Không đúng định dạng " +
                    this.validExts.toString());
                return false;
            } else {
                let totalSize = event.target.files[0].size;
                let fSExt = new Array('Bytes', 'KB', 'MB', 'GB');
                let fSize = totalSize;
                let i = 0;
                while (fSize > 900) { fSize /= 1024; i++; }
                var total = (Math.round(fSize * 100) / 100);
                if (fSExt[i] == 'MB') {
                    if (total >= 5) {
                        alert("File đính kèm ảnh không được quá 5 Mb");
                        return false;
                    } else {
                        let F = event.target.files;
                        if(F && F[0]) this.readImage( F);
                    }
                } else {
                    var F = event.target.files;
                    if(F && F[0]) this.readImage( F);
                }
            }
        }
    }

    fileImages:File[]= new Array();
    readImage(file: any) {
        console.log(file)
        const reader = new FileReader();
        this.fileImages=file;
        // this.imageModel.images = file;
        // this.fileImages.push(this.imageModel.images);
        reader.onload = (e: any) => {
            this.imgSrc = e.target.result;
            var w = e.target.width;
            if (w < 100) {
                alert("Kích thước ảnh không hợp lệ width >= 656");
            }
        };
        // for (let index = 0; index < file.length; index++) {
        //    console.log(file[index]);
        //     reader.readAsDataURL(file[index]);
        // }
     
    }
    // readImage(event: any, index: any) {
    //     var file = event.target.files;
    //     if (file && file[0]) {
    //         const reader = new FileReader();
    //        let item=file[0]
    //        this.imageList[index]=item;
    //        console.log('list Image:'+JSON.stringify(this.imageList));
    //         reader.onload = (e: any) => {
    //             this.imgSrc = e.target.result;
    //         };
    //         reader.readAsDataURL(file);
    //     }
    // }
    onSubmit() {
        this.router.paramMap.subscribe((params: ParamMap) => {
            this.imageId = params.get('id');
        });
        if (this.imageId != null) {
            this.service.updateImage(this.imageModel, this.fileImages, this.imageId).subscribe((response: any) => {
                if (response.error_code == Constants.SUCCESSFUL_CODE) {
                    this.rt.navigate(['/list']);
                    this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
                } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                    this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }
            })
        }
        else {
            this.service.createImage(this.imageModel, this.fileImages).subscribe((res: any) => {
                if (res.error_code == Constants.SUCCESSFUL_CODE) {
                    this.rt.navigate(['/list']);
                    this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
                } else if (res.error_code == Constants.NOT_ACCESS_CODE) {
                    this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }
            })
        }


    }

}