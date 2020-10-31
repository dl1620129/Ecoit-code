import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { OrganizationModel } from '../model/organization.model';

@Injectable({providedIn: 'root'})
export class OrganizationService {
    constructor(private httpClient: HttpClient) { }

    public getAllorganization(limit: number, start: number, keyWord: string){
        let url= Constants.baseUrl+Constants.detailUrl+'getall/'+Constants.groupId+'/0'+'?q='+keyWord;
        // let url= Constants.baseUrl+'/o/ldap/app/get-organization-all'
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getOrganizationById(id: number){
        let url= Constants.baseUrl+Constants.detailUrl+'get/'+Constants.groupId+'/'+id;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getAllOrgan(){
        let url= Constants.baseUrl+'/o/organizational/app/getall/'+Constants.groupId+'/0';
        // let url= Constants.baseUrl+'/o/ldap/app/get-userId-inOrg/'+Constants.userId;
        // let url= Constants.baseUrl+'/o/ldap/app/get-organization-all';
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public deleteOrgan(id: number){
        let url= Constants.baseUrl+Constants.detailUrl+'delete/'+Constants.groupId+'/'+id;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
  
    // public getorganization(id: number){
    //     let url= Constants.baseUrl+Constants.detailUrl+'getorganization/'+Constants.groupId+'/'+Constants.userId+'/'+id;
    //     return this.httpClient.get(url).pipe(catchError(CommonService.handleError));

    // }
 
     convertTreeList(treeList: OrganizationModel[], level: number, listOfOrganizations: OrganizationModel[]) {
        treeList.forEach((element: OrganizationModel) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element['name'];
            let newElement = new OrganizationModel(element.organizationId,element.orgCoreId, element.organizationCode, newTitle, element.description, element.leader,element.parentId,element.child,element.thuTu);
            listOfOrganizations.push(newElement);
            this.convertTreeList(element['child'], level+1, listOfOrganizations);
        });
      
    }
    // createOrganization(form:any){
    //     if(!form.value.parentId){
    //         form.value.parentId =0;
    //     }
    //     console.log('parenId: '+form.value.parentId);
    //     let url= Constants.baseUrl+Constants.detailUrl+'create/'+Constants.groupId+'/'+form.value.parentId;
    //     let body={
    //         'name': form.value.name,
    //         'description': form.value.description,
    //         'address': form.value.address,
    //         'phoneNumber': form.value.phoneNumber,
    //         'organizationCode': form.value.organizationCode
    //     }
    //     return this.httpClient.post(url,body).pipe(catchError(CommonService.handleError));
    // }
    createOrganization(organizationModel:OrganizationModel,orgId:number){
        if(!organizationModel.parentId){
            organizationModel.parentId =0;
        }
        let url= Constants.baseUrl+Constants.detailUrl+'create/'+Constants.groupId+'/' +organizationModel.parentId;
       if(organizationModel.name==undefined){
            organizationModel.name='';
        }if(organizationModel.description==undefined){
            organizationModel.description='';
        }if(organizationModel.address==undefined){
            organizationModel.address='';
        }if(organizationModel.phoneNumber==undefined){
            organizationModel.phoneNumber='';
        }
        // if(organizationModel.orgCoreId==undefined){
        //     organizationModel.orgCoreId=0;
        // }
 
        let body= new FormData();
        body.append('name', organizationModel.name);
        body.append('description', organizationModel.description);
        body.append('organizationCode', organizationModel.organizationCode);
        body.append('address', organizationModel.address);
        body.append('phoneNumber', organizationModel.phoneNumber);
        body.append('organCoreId', orgId+'');
        body.append('thuTu', organizationModel.thuTu.toString());
       
        return this.httpClient.post(url,body).pipe(catchError(CommonService.handleError));
    }
    addOrgCore(organizationModel:OrganizationModel){
        if(!organizationModel.parentId){
            organizationModel.parentId =0;
        }

        let url= Constants.baseUrl+'/o/ldap/app/create-organization';
        let body= new FormData();
        body.append('name', organizationModel.organizationCode);
        body.append('parentId', organizationModel.parentId.toString());
        body.append('groupId', Constants.groupId.toString());
        return this.httpClient.post(url,body).pipe(catchError(CommonService.handleError));
    }
    updateCore(organizationModel:OrganizationModel,id: number){
        if(!organizationModel.parentId){
            organizationModel.parentId =0;
        }

        let url= Constants.baseUrl+'/o/ldap/app/update-organization/'+id;
        let body= new FormData();
        body.append('name', organizationModel.organizationCode);
        body.append('parentId', organizationModel.parentId.toString());
        body.append('groupId', Constants.groupId.toString());
        return this.httpClient.post(url,body).pipe(catchError(CommonService.handleError));
    }
    deleteOrgCore(orgId: number){
        let url= Constants.baseUrl+'/o/ldap/app/delete-organization/'+orgId;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
    updateOrganization(organizationModel: OrganizationModel,id: Number){
        if(!organizationModel.parentId){
            organizationModel.parentId =0;
        }
        let url= Constants.baseUrl+Constants.detailUrl+'update/'+Constants.groupId+'/'+id;
        let body= new FormData();
        body.append('name', organizationModel.name);
        body.append('description', organizationModel.description);
        body.append('organizationCode', organizationModel.organizationCode);
        body.append('address', organizationModel.address);
        body.append('parentId', organizationModel.parentId.toString());
        body.append('phoneNumber', organizationModel.phoneNumber);
        body.append('thuTu', organizationModel.thuTu.toString());
        return this.httpClient.put(url,body).pipe(catchError(CommonService.handleError));
    }
}