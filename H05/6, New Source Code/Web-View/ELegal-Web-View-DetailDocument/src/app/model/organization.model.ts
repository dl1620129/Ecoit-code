export class Organization {
    public name: string;
    public organizationId: number;
    public description: string;
    public parentId: number;
    public position: number;
    public statusOrg: boolean;
    public child: Array<Organization>;
    constructor() {};
}