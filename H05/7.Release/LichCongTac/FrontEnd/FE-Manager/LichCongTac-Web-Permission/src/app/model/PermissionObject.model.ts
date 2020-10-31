export class PermissionObject {
    groupName: string;
    description: string;
    users: number[];
    permissions: number[];
    columns: number[];
    categories: number[];
    organizations: number[];
    fields: number[];
    constructor(){
        this.groupName = "";
        this.description = "";
        this.users = new Array();
        this.permissions = new Array();
        this.columns = new Array();
        this.categories = new Array();
        this.organizations = new Array();
        this.fields = new Array();
    }
}