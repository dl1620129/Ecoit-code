import { Component, OnInit } from "@angular/core";
import { FormBuilder,FormGroup,FormControl,Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { GroupLinkService } from '../service/groupLink.service';
import { GroupLinksModel } from "../model/groupLink.model";
import { Constants } from '../common/Constants';
import { NotifierService } from "angular-notifier";
declare const Liferay: any;
@Component({
    selector: 'app-editor',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/GroupLink-FrontEnd/app/grouplink-editor.component.html'
})
export class GroupLinkEditorComponent implements OnInit{
    
    constructor(public service: GroupLinkService, public router: ActivatedRoute,public rt: Router,public notifierService: NotifierService){}
    groupLinksModel: GroupLinksModel = new GroupLinksModel();
    groupLinkId: any;
    updateform = new FormGroup({
        'groupName': new FormControl('',Validators.required),
        'description': new FormControl('')
    })
    get groupName(){ return this.updateform.get('groupName');}
    ngOnInit(){
        this.router.paramMap.subscribe((params: ParamMap)=>{
            this.groupLinkId = params.get('id');
        })
        if(this.groupLinkId !=null){
            this.service.getGroupLink(this.groupLinkId).subscribe((res:any)=>{
                this.updateform.patchValue({
                    'groupName':res.data.groupName,
                    'description':res.data.description
                })
            });
        }
    }
    onSubmit(){        
        this.router.paramMap.subscribe((params: ParamMap) =>{
            this.groupLinkId = params.get('id');
        });
        if(this.groupLinkId != null){
            this.service.updateGroupLinks(this.updateform,this.groupLinkId).subscribe((data:any) =>{
                if (data.error_code == Constants.SUCCESSFUL_CODE) {
                    this.rt.navigate(['/list']);
                    this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
                } else if (data.error_code == Constants.NOT_ACCESS_CODE) {
                    this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }
            })
        }
        else{
            this.service.createGroupLinks(this.updateform).subscribe((res:any) =>{
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