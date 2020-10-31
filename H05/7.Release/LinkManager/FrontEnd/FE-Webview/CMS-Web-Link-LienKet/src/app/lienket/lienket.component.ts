import { Component, OnInit } from "@angular/core";
import { LienKetService } from "../service/lienket.service";

declare const Liferay: any;
@Component({
    selector: 'app-lienket',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMS-Web-Link-LienKet/app/lienket.component.html'
})
export class LienKetComponent implements OnInit{
    links: any;
    grouplinks: any;
    constructor(public service: LienKetService){}
    ngOnInit(){

        this.service.getAllLinks().subscribe((res: any)=>{
                this.links = res.data[0].data;
        });
        this.service.getGroupLink().subscribe((res1: any)=>{
            this.grouplinks = res1.data.data;
        });
    }
    lienketLink(event:any){

        let url = event.target.value;
        // this.service.getLinkByGroupLinkId(url).subscribe((respone: any)=>{
        //             this.links=respone.data[0].data;
        //             console.log(this.links);
        // });
        window.open(url);
    }
    // getLinkGroupId(event:any){
    //     let linkgroupId=event.target.value;
    //     this.service.getLinkByGroupLinkId(linkgroupId).subscribe((respone: any)=>{
    //         this.links=respone.data[0].data;
    //     })
    // }
}