export class ModuleAdmin {
    id: number;
    name: string;
    active: boolean;
    // create_by: number;
    createDate: Date;
    // update_by: number;
    // update_time: Date;
    // client_id: number;
    parentId: number;
    code: string;
    order: number;
    routerPath: string;
    faIcon: string;
    componentName: string;
    description: string;
    constructor(){
        
    }
}

export class ModuleAdminSearch {
    name: string;
    code: string;
    status: boolean;
}

