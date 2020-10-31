import { Component, OnInit } from "@angular/core";
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
import { Validators } from '@angular/forms';
import { RankService } from '../service/rank.service';
import { RankModel } from '../model/rank.model';
declare const Liferay: any;
@Component({
    selector: 'app-editor',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/UserRankManager/app/rank-editor.component.html'
})
export class RankkEditorConponent implements OnInit{
    pageSize= 5;
    page = 1;
    listSize = 0;
    imgSrc: any;
    constructor(public service: RankService, public router: ActivatedRoute,public rt: Router,public notifierService:NotifierService,
        private fb: FormBuilder ){}
    rankModel: RankModel = new RankModel();
    rankId: any;
    fields: any;
    listImageCategory:any;

    updateform = this.fb.group({
        // [''[Validators.required,Validators.minLength(30),Validators.pattern(/^((?!\s{2,}).)*$/)]]
        userRankName: ['', [Validators.required, Validators.maxLength(500),Validators.pattern(".*\\S.*")]],
        description: ['', [Validators.maxLength(500),Validators.pattern(".*\\S.*")]],
    });
    get userRankName(){ 
        return this.updateform.get('userRankName');
    }
   
    get description(){ 
        return this.updateform.get('description');
    }
    ngOnInit(){
      
        this.router.paramMap.subscribe((params: ParamMap)=>{
            this.rankId = params.get('id');
        })
        if(this.rankId !=null){
            this.service.getCategory(this.rankId).subscribe((res:any)=>{
                this.updateform.patchValue({
                    userRankName:res.data.userRankName,
                    description:res.data.description,
                })
            });
        }
    }
    displayId(event: any){
        console.log("id:"+event.target.value);
    }

    onSubmit(){        
        this.router.paramMap.subscribe((params: ParamMap) =>{
            this.rankId = params.get('id');
        });
        if(this.rankId != null){
            this.service.updateCategory(this.updateform,this.rankId).subscribe((response: any) =>{
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
            this.service.createCategory(this.updateform).subscribe((res:any) =>{
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
  
    pageChange(event: any){
        let startPage = (event - 1) * this.pageSize;
    }
   

}