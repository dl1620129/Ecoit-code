export class OrganizationModel{
    ID: number;
    name: string;
    parentName: string;
    parentId: number;
    organCoreId: number;
    address:string;
    phoneNumber:number;
    children:  Array<OrganizationModel>;
     constructor( ID: number,  name: string,
        parentName: string,parentId: number,children:  Array<OrganizationModel>){
            this.ID=ID;
            this.name=name;
            this.parentName=parentName;   
            this.parentId=parentId;
            this.children=children;
        };
    // ID:number;
    // name: string;
    // parentId:number;
    // parentName:string;
    // children:  Array<OrganizationModel>;
    // constructor(ID: number,name: string, parentName:string,parentId: number,children:  Array<OrganizationModel>){}
}  