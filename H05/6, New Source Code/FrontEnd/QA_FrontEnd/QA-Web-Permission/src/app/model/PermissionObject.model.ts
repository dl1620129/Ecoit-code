export class PermissionObject {
    name: string;
    description: string;
    users: number[];
    permissions: number[];
    categories: number[];
    organizations: number[];
    fields: number[];
    constructor(){
        this.name = "";
        this.description = "";
        this.users = new Array();
        this.permissions = new Array();
        this.categories = new Array();
        this.organizations = new Array();
        this.fields = new Array();
    }
}