export class OrganizationModel{
    organizationId: number;
    organizationCode: string;
    name: string;
    description: string;
    leader: string;
    parentId: number;
    child:  Array<OrganizationModel>;
    constructor( organizationId: number,organizationCode: string,  name: string,
        description: string,leader: string,parentId: number,child:  Array<OrganizationModel>){
            this.organizationCode=organizationCode;
            this.organizationId=organizationId;
            this.name=name;
            this.description=description;
            this.parentId=parentId;
            this.leader=leader;
            this.child=child;
        }
}  