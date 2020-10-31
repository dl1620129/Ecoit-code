import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { ClipService } from '../service/clip.service';
import { ClipModel } from '../model/Clip.model';
import { NotifierService } from 'angular-notifier';
import { Constants } from '../common/Constants';
declare const Liferay: any;
declare const $: any;
@Component({
    selector: 'app-editor',
    templateUrl:
        Liferay.ThemeDisplay.getPathContext() +
        '/o/ThuVienClip-FrontEnd/app/clip-editor.component.html'
})
export class ClipEditorComponent implements OnInit {

    clip: any;
    constructor(public clipservice: ClipService, public rt: Router, public router: ActivatedRoute, public notifierService: NotifierService) { }
    listCategory: any;
    clipModel: ClipModel = new ClipModel();
    clipId: number;
    urlim: String;
    andelete = true;
    thoiLuong: any;
    ngOnInit() {

        this.clipModel.thoiLuongVideo = '';
        this.router.paramMap.subscribe((params: any) => {
            this.clipId = params.get('id');
        })
        if (this.clipId != null) {
            this.clipservice.getClipById(this.clipId).subscribe((res1: any) => {
                this.clipModel = res1.data;
                this.urlim = res1.data.clipUrl;
                this.urlim = this.urlim.split("/")[4];
                console.log(this.urlim);


            })
        }
        this.clipservice.getClipcategory().subscribe((res: any) => {
            this.listCategory = res.data[0].data;
        })
    }
    deletevideo() {
        this.urlim = '';
        this.andelete = true;
    }
    submitForm() {
        this.router.paramMap.subscribe((params: any) => {
            this.clipId = params.get('id');
        })
        this.notifierService.notify('success',"Hệ thống đang xử lý");
        if (this.clipId != null) {
            this.clipservice.updateClip(this.clipModel, this.clipId).subscribe((response: any) => {
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
            this.clipservice.createClip(this.clipModel).subscribe((res: any) => {
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

    validExts = [".mp4"];
    readVideo(file: any) {

        this.clipModel.videos = file;
      
		var video = document.createElement('video');
		video.preload = 'metadata';
		video.onloadedmetadata = (e:any) =>{
			window.URL.revokeObjectURL(video.src);
			if (video.duration < 1) {
                console.log("Invalid File: " );
				console.log("Invalid File: " + video.duration);
            }
            
		}
		video.onerror = (e:any)=> {
            alert("Không đúng định dạng "+this.validExts.toString());
            this.clipModel.videos=null;
            return false;
		}
		video.src = URL.createObjectURL(file);
       
    }
  
    processFile(event: any) {
        let fileExt = event.target.value;
        if (fileExt != '') {
            fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
            if (this.validExts.indexOf(fileExt.toLowerCase()) < 0) {
                alert("Mời bạn tải lên video dạng mp4,mp3 " +
                    this.validExts.toString());
                    event.target.files[0]='';
                return false;

            } else {
                let totalSize = event.target.files[0].size;
                let fSExt = new Array('Bytes', 'KB', 'MB', 'GB');
                let fSize = totalSize;
                let i = 0;
              
               
                while (fSize > 900) { fSize /= 1024; i++; }
                var total = (Math.round(fSize * 100) / 100);
                if (fSExt[i] == 'MB') {
                    if (total >= 300) {
                        alert("Video tải nên không được quá 300 Mb");
                        return false;
                    } else {
                        let F = event.target.files;
                        if(F && F[0]) this.readVideo( F[0]);
                    }
                }else{
                    var F = event.target.files;
                    if (F && F[0]) this.readVideo(F[0]);
                }
                // let a= event.target.files[0];
                // let objectUrl = URL.createObjectURL(a);
                // $("#vid").prop("src", objectUrl);  
                  
            }
        }
    }


}