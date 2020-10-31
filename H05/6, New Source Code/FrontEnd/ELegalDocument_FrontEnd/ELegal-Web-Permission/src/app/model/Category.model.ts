export class Category {
    public name: string;
    public typeId: number;
    public parentId: number;
    public position: number;
    public createDate: Date;
    public checked: boolean;
    public child: Array<Category>;
    constructor() {};
}