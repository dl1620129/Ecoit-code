export class Organization {
    ID: number;
    name: string;
    parentId: number;
    children:  Array<Organization>;
    
    constructor(){
    };
       
}  