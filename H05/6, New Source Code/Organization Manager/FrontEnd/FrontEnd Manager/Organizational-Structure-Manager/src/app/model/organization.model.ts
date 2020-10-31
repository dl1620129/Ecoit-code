export class OrganizationModel{
    organizationId: number;
    organizationCode: string;
    name: string;
    description: string;
    leader: string;
    parentId: number;
    orgCoreId: number;
    address:string;
    phoneNumber:string;
    thuTu:number;
    child:  Array<OrganizationModel>;
     constructor( organizationId: number,orgCoreId:number,organizationCode: string,  name: string,
        description: string,leader: string,parentId: number,child:  Array<OrganizationModel>,thuTu:number){
            this.organizationCode=organizationCode;
            this.orgCoreId=orgCoreId;
            this.organizationId=organizationId;
            this.name=name;
            this.description=description;   
            this.parentId=parentId;
            this.leader=leader;
            this.child=child;
            this.thuTu=thuTu;
        };
       
}  