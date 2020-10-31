import { Component, OnInit } from "@angular/core";
import { FormBuilder,FormGroup,FormControl,Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { GroupClipModel } from '../model/groupClip.model';
import { GroupClipService } from '../service/groupClip.service';
import { NotifierService } from 'angular-notifier';
import { Constants } from "../common/Constants";
declare const Liferay: any;
@Component({
    selector: 'app-editor',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/GroupClip-FrontEnd/app/groupclip-editor.component.html'
})
export class GroupClipEditorComponent implements OnInit{
    
    constructor(public service: GroupClipService, public router: ActivatedRoute,public rt: Router,public notifierService: NotifierService){}
    groupClipModel: GroupClipModel = new GroupClipModel();
    groupClipId: any;
    updateform = new FormGroup({
        'title': new FormControl('',[Validators.required,Validators.maxLength(500)]),
        'description': new FormControl('',[Validators.maxLength(500)])
    })
    get title(){ return this.updateform.get('title');}
    get description(){ return this.updateform.get('description');}
    ngOnInit(){
        this.router.paramMap.subscribe((params: ParamMap)=>{
            this.groupClipId = params.get('id');
        })
        if(this.groupClipId !=null){
            this.service.getGroupClip(this.groupClipId).subscribe((res:any)=>{
                this.updateform.patchValue({
                    'title':res.data.title,
                    'description':res.data.description
                })
            });
        }
    }
    onSubmit(){        
        this.router.paramMap.subscribe((params: ParamMap) =>{
            this.groupClipId = params.get('id');
        });
      
        if (this.groupClipId != null) {
            this.service.updateGroupLinks(this.updateform, this.groupClipId).subscribe((response: any) => {
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
            this.service.createGroupLinks(this.updateform).subscribe((res: any) => {
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