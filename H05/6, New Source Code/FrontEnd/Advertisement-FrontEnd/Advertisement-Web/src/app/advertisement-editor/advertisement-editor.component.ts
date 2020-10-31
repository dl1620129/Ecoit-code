import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { AdvertisementService } from '../service/advertisement.service';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';

declare const Liferay: any;

@Component({
    selector: 'app-tag-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/Advertisement-Web/app/advertisement-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class AdvertisementEditorComponent implements OnInit {

    urlRegex = /^(?:http(s)?:\/\/)?[\w.-]+(?:\.[\w\.-]+)+[\w\-\._~:/?%#[\]@!\$&'\(\)\*\+,;=.]+$/;
    advertisementForm = this.fb.group({
        nameAdv: ['', [Validators.required, Validators.maxLength(300)]],
        description: ['', Validators.maxLength(500)],
        target: false,
        url: ['', [Validators.maxLength(300), Validators.pattern(this.urlRegex)]],
        isShow: false,
        imageFile: null
    });

    imgSrc: any;
    imageId: number;
    isImageExisted: boolean = false;
    advertisementId: any;

    get nameAdv() {
        return this.advertisementForm.get('nameAdv');
    };

    get url() {
        return this.advertisementForm.get('url');
    };

    get description() {
        return this.advertisementForm.get('description');
    };

    constructor(private fb: FormBuilder, 
        private routes: ActivatedRoute, 
        private advertisementService: AdvertisementService, 
        private router: Router,
        private notifierService: NotifierService) {};

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.advertisementId = params.get('id');
                this.advertisementService.getAdvertisement(this.advertisementId).subscribe((response: any) => {
                    console.log(response.data);
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.advertisementForm.patchValue({
                            nameAdv: response.data.tenQuangCao,
                            description: response.data.moTa,
                            target: response.data.target,
                            url: response.data.url,
                            isShow: response.data.url
                        });
                        if (response.data.imageUrl) {
                            this.imgSrc = response.data.imageUrl;
                            this.imageId = response.data.imageId;
                            this.isImageExisted = true;
                        }

                    } else {
                        this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                    }
                });
            }
        });
    };

    onSubmit() {
        this.advertisementService.submitAdvertisement(this.advertisementForm, this.advertisementId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {              
                this.router.navigate(['/advertisement-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    };

    validExts = [".jpg", ".png",".jpeg",".gif"];
    processFile(event: any) {
        let fileExt = event.target.value;

        if(fileExt != ''){
            fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
            console.log(fileExt);
            if (this.validExts.indexOf(fileExt.toLowerCase()) < 0) {
                alert("Không đúng định dạng " +
                       this.validExts.toString());
                return false;
            } else {
                let totalSize = event.target.files[0].size;
                let fSExt = new Array('Bytes', 'KB', 'MB', 'GB');
                let fSize = totalSize; 
                let i=0;
                while(fSize>900){fSize/=1024;i++;}
                var total = (Math.round(fSize*100)/100);
                if(fSExt[i] == 'MB'){
                    if(total >= 3){
                        alert("File đính kèm ảnh không được quá 3 Mb");
                        return false;
                    } else {
                        let F = event.target.files;
                        if(F && F[0]) this.readImage( F[0]);
                    }
                } else {
                    var F = event.target.files;
                    if(F && F[0]) this.readImage( F[0]);
                }
            }
        }
    }

    readImage(file: any) {
        const reader = new FileReader();
        this.advertisementForm.patchValue({
            imageFile: file
        });
        reader.onload = (e: any) => {
            var w = e.target.width;
            if (w < 100) {
                alert("Kích thước ảnh không hợp lệ width >= 656");
            }
        };
        reader.readAsDataURL(file);
    }

    //delete image
    deleteImage() {
        this.advertisementService.deleteImage(this.advertisementId, this.imageId).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.isImageExisted = false;
                this.imgSrc = null;
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
}