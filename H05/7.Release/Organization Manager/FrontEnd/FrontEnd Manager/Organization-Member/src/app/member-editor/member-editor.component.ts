import { Component, OnInit } from "@angular/core";
import { FormBuilder,FormGroup,FormControl,Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
import { MemberService } from '../service/Member.service';
import { MemberModel } from "../model/member.model";
import { OrganizationModel } from "../model/organization.model";
declare const Liferay: any;
@Component({
    selector: 'app-editor',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/Organization-Member/app/member-editor.component.html'
})
export class MemberEditorComponent implements OnInit{
    imgSrc: any;
    
    constructor(public service: MemberService, public router: ActivatedRoute,public rt: Router,public notifierService:NotifierService ){}
    imageModel: MemberModel = new MemberModel();
    imageId: any;

    ngOnInit(){
        this.getOrganData();
        this.router.paramMap.subscribe((params: ParamMap)=>{
            this.imageId = params.get('id');
        })
        if(this.imageId !=null){
            this.service.getMember(this.imageId).subscribe((res:any)=>{
                this.imageModel= res.data;
                
            });
        }
    }
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
    listOrgan: any=[];
    listOrgan2: any=[];
    getOrganData(){
        this.service.getAllOrgan().subscribe((res: any)=>{
            this.listOrgan2=res.data.data;
            this.service.convertTreeList(this.listOrgan2,1,this.listOrgan);
        })
    }
    readImage(file: any) {
        const reader = new FileReader();
        this.imageModel.images = file;
        reader.onload = (e: any) => {
            this.imgSrc = e.target.result;
            var w = e.target.width;
            if (w < 100) {
                alert("Kích thước ảnh không hợp lệ width >= 656");
            }
        };
        reader.readAsDataURL(file);
    }
    
    onSubmit(){        
        this.router.paramMap.subscribe((params: ParamMap) =>{
            this.imageId = params.get('id');
        });
        if(this.imageId != null){
            this.service.updateImage(this.imageModel,this.imageId).subscribe((response: any) =>{
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
        else{
            this.service.createImage(this.imageModel).subscribe((res:any) =>{
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