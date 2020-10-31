import { Component, OnInit } from "@angular/core";
import { FormBuilder,FormGroup,FormControl,Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { LinhVucService } from '../service/linhVuc.service';
import { LinhVucModel } from "../model/LinhVuc.model";
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
declare const Liferay: any;
@Component({
    selector: 'app-editor',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/Manager-Field-Image/app/linhvuc-editor.component.html'
})
export class LinhVucEditorComponent implements OnInit{
    
    constructor(public service: LinhVucService, public router: ActivatedRoute,public rt: Router,public notifierService:NotifierService ){}
    linhVucModel: LinhVucModel = new LinhVucModel();
    linhVucId: any;
    updateform = new FormGroup({
        'name': new FormControl('',Validators.required),
        'description': new FormControl('')
    })
    get name(){ 
        return this.updateform.get('name');
    }
    ngOnInit(){
        this.router.paramMap.subscribe((params: ParamMap)=>{
            this.linhVucId = params.get('id');
        })
        if(this.linhVucId !=null){
            this.service.getGroupLink(this.linhVucId).subscribe((res:any)=>{
                this.updateform.patchValue({
                    'name':res.data.name,
                    'description':res.data.description,
                })
            });
        }
    }
    onSubmit(){        
        this.router.paramMap.subscribe((params: ParamMap) =>{
            this.linhVucId = params.get('id');
        });
        if(this.linhVucId != null){
            this.service.updateLinhVuc(this.updateform,this.linhVucId).subscribe((response: any) =>{
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
            this.service.createLinhVuc(this.updateform).subscribe((res:any) =>{
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