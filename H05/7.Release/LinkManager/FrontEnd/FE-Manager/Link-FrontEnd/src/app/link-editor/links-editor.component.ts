import { Component, OnInit } from "@angular/core";
import { LinkService } from "../service/Link.service";
import { LinksModel } from "../model/Link.model";
import { FormBuilder,FormGroup,FormControl,Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { Constants } from '../common/Constants';
import { NotifierService } from "angular-notifier";
declare const Liferay: any;
@Component({
    selector: 'app-editor',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/Link-FrontEnd/app/links-editor.component.html'
})
export class LinksEditorComponent implements OnInit{
    updateform = new FormGroup({
        'name': new FormControl('', Validators.required),
        'decription': new FormControl(''),
        'linksgroupid': new FormControl(''),
        'url': new FormControl('')
    })
    linkModels: LinksModel[];
    datagroupLink: any;
    linkId:  any;
    constructor(public linkService: LinkService, public router: ActivatedRoute, public rt: Router,public notifierService: NotifierService){}
    ngOnInit() {
        this.linkService.getGroupLink().subscribe((respone:any)=>{
            this.datagroupLink =respone.data.data;
        })
        this.router.paramMap.subscribe((params: ParamMap) =>{
            this.linkId = params.get('id');
        });
        if(this.linkId != null){
            this.linkService.getLink(this.linkId).subscribe((res1: any)=>{
            this.updateform.patchValue({
                'name' : res1.data.name,
                'decription' : res1.data.decription,
                'linksgroupid' : res1.data.linksgroupid,
                'url' : res1.data.url
            })
        })
        }
        
       
       
    }
    get name() { return this.updateform.get('name'); }
    onSubmit(){        
        this.router.paramMap.subscribe((params: ParamMap) =>{
            this.linkId = params.get('id');
        });
        console.log('id: '+this.linkId);
        if(this.linkId != null){
            this.linkService.updateLinks(this.updateform,this.linkId).subscribe((data:any) =>{
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
            this.linkService.createLinks(this.updateform).subscribe((data:any)=>{
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

       
    }
   
    
  
    


  

}