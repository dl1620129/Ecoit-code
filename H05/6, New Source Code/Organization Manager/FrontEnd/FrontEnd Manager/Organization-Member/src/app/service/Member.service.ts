import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { MemberModel } from '../model/member.model';
import { OrganizationModel } from '../model/organization.model';

@Injectable({providedIn: 'root'})
export class MemberService {
    constructor(private httpClient: HttpClient) { }

    public getAllMember(limit: number, start: number, keyWord: string){
        let url= Constants.baseUrl+Constants.detailUrl+'getall/'+Constants.groupId+'?limit='+limit+'&start='+start+'&q='+keyWord;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }public getAllMemberByOrgan(limit: number, start: number, organizationId: number){
        let url= Constants.baseUrl+Constants.detailUrl+'get-by-organization/'+Constants.groupId+'/'+organizationId+'?limit='+limit+'&start='+start;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getAllOrgan(){
        let url= Constants.baseUrl+'/o/organizational/app/getall/'+Constants.groupId+'/0';
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public deleteImage(id: number){
        let url= Constants.baseUrl+Constants.detailUrl+'delete/'+Constants.groupId+'/'+Constants.userId+'/'+id;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
  
    public getMember(id: number){
        let url= Constants.baseUrl+Constants.detailUrl+'getmember/'+Constants.groupId+'/'+Constants.userId+'/'+id;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));

    }
    public createImage(memberModel: MemberModel){
        if(memberModel.images==undefined){
            memberModel.images=null;
        }if(memberModel.fullName==undefined){
            memberModel.fullName='';
        }if(memberModel.address==undefined){
            memberModel.address='';
        }if(memberModel.sex==undefined){
            memberModel.sex=true;
        }if(memberModel.position==undefined){
            memberModel.position='';
        }if(memberModel.organizationId==undefined){
            memberModel.organizationId=0;
        }

    let re = /\-/gi;
        let body= new FormData();
        body.append('images', memberModel.images);
        body.append('fullName', memberModel.fullName);
        body.append('address', memberModel.address);
        body.append('position',memberModel.position);
        body.append('birthday', memberModel.birthday.toString().replace(re,'/'));
        body.append('sex', JSON.stringify(memberModel.sex));
        body.append('isLeader', JSON.stringify(memberModel.isLeader));
        body.append('organizationId', memberModel.organizationId.toString());

        let url= Constants.baseUrl+Constants.detailUrl+'create/'+Constants.groupId+'/'+Constants.userId;
        return this.httpClient.post(url, body).pipe(catchError(CommonService.handleError));
         
    }
    public updateImage(memberModel: MemberModel, id: number){
        if(memberModel.images==undefined){
            memberModel.images=null;
        }if(memberModel.fullName==undefined){
            memberModel.fullName='';
        }if(memberModel.address==undefined){
            memberModel.address='';
        }if(memberModel.sex==undefined){
            memberModel.sex=true;
        }if(memberModel.position==undefined){
            memberModel.position='';
        }if(memberModel.organizationId==undefined){
            memberModel.organizationId=0;
        }
        
        let re = /\-/gi;
        let body= new FormData();
        body.append('images', memberModel.images);
        body.append('fullName', memberModel.fullName);
        body.append('address', memberModel.address);
        body.append('position',memberModel.position);
        body.append('birthday', memberModel.birthday.toString().replace(re,'/'));
        body.append('sex', JSON.stringify(memberModel.sex));
        body.append('isLeader', JSON.stringify(memberModel.isLeader));
        body.append('organizationId', memberModel.organizationId.toString());
        let url= Constants.baseUrl+Constants.detailUrl+'update/'+Constants.groupId+'/'+Constants.userId+'/'+id;
        return this.httpClient.put(url,body).pipe(catchError(CommonService.handleError));
    }
     convertTreeList(treeList: OrganizationModel[], level: number, listOfOrganizations: OrganizationModel[]) {
        treeList.forEach((element: OrganizationModel) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element['name'];
            let newElement = new OrganizationModel(element.organizationId, element.organizationCode, newTitle, element.description, element.leader,element.parentId,element.child);
            listOfOrganizations.push(newElement);
       
            this.convertTreeList(element['child'], level+1, listOfOrganizations);
        });
      
    }

}