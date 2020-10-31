import { Component, OnInit } from "@angular/core";

import { Routes } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/Constants';
import { MemberModel } from '../model/member.model';
import { MemberService } from '../service/Member.service';

declare const Liferay: any;
@Component({
    selector: 'app-leader',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMS-Web-View-Information/app/leader.component.html'
})
export class MemberComponent implements OnInit{
    pageSize= 5;
    page = 1;
    listSize = 0;
    organId:number;
    listLeader:any=[];
    leader:MemberModel = new MemberModel();
    constructor(public service: MemberService){}
    ngOnInit() {
        this.getOrganData(0,0);
      
    }
    getOrganData(parentId:number,start: number){
        this.service.getAllOrgan(parentId).subscribe((res:any)=>{
            this.organId=res.data.data[0].organizationId;
            this.service.getAllMemberByOrgan(this.pageSize,start,this.organId).subscribe((result:any)=>{
                    this.listLeader=result.data[0].data;
                    for (let index = 0; index < this.listLeader.length; index++) {
                        const element = this.listLeader[index];
                        if(this.listLeader[index].isLeader==true){
                            this.leader=this.listLeader[index];
                            const a: number = this.listLeader.indexOf(this.listLeader[index]);
                            if (index !== -1) {
                                this.listLeader.splice(a, 1);
                            }  
                            break;
                        }
                    }
                   
            })
        })
    }
    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getOrganData(0,startPage);
    }
   
  


}