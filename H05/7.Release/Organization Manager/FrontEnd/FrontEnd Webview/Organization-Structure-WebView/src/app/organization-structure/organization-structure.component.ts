import { Component,OnInit } from '@angular/core';
import { OrganizationService } from '../service/organization.service';
import { organ } from '../model/organ.model';
declare const Liferay: any;
declare const $:any;
@Component({
    selector: 'app-list',
    templateUrl:Liferay.ThemeDisplay.getPathContext() + 
   '/o/Organization-Structure-WebView/app/organization-structure.component.html'
})
export class OrganizationComponent implements OnInit{
    organizationModels: any=[];
    organizationModelParents: any=[];
    arrayById: any=[];
    arrayOne(n: number): any[] {
        return Array(n);
    }
   
    organizationObject:organ= new organ();
    constructor(public organizationService: OrganizationService){}
    ngOnInit() {
        this.getorganizationData();
     
    }
    listById(id:number){
            this.organizationService.getById(id).subscribe((res:any)=>{
                this.arrayById=res.data.data;
               return this.arrayById;
            })
        
        
    }
    getorganizationData(){
        this.organizationService.getAllorganization().subscribe((res: any) =>{
            this.organizationModels = res.data.data;
            this.organizationModelParents=res.data.data[0].child;
            this.organizationObject=res.data.data[0];
            for (let index = 0; index < this.organizationModelParents.length; index++) {
                    this.organizationService.getById(this.organizationModelParents[index].organizationId).subscribe((res:any)=>{
                        this.arrayById=res.data.data;
                    })
            }
        })
    }
 
    displayDropDown(event: any) {
        event.preventDefault();
        let isVisible = $(event.currentTarget).data('visible');
        $(event.currentTarget).data('visible', !isVisible);
        if (isVisible) {
            //switch to plus
            $(event.currentTarget).html('<i class="fa fa-fw" aria-hidden="true"></i>');
        } else {
            //switch to minus
            $(event.currentTarget).html('<i class="fa fa-fw" aria-hidden="true"></i>');
        }
        let targetLevel = $(event.currentTarget).data('target');
        let currentRow = $(event.currentTarget).parents('.parenttree').next();
        let currentLevel = $(currentRow).data('level');
        let mainVisible = isVisible;
        while (currentLevel > targetLevel) {
            let isShow = false;
            if (mainVisible) {
                if ($(currentRow).is(':visible')) {
                    $(currentRow).hide();
                }
            } else {
                isShow = true;
                $(currentRow).show();
            }

            if (($(currentRow).next().data('level') - targetLevel) == 1) {
                mainVisible = isVisible;
            } else {
                if ($(currentRow).find('.dropdown-btn').length > 0 && isShow) {
                    mainVisible = !$(currentRow).find('.dropdown-btn').data('visible');
                }
            }
            currentRow = $(currentRow).next();
            currentLevel = $(currentRow).data('level');
        }
    }

}