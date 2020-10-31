export class Category {
    public categoryId: number;
    public name: string;
    public description: string;
    public parentId: number;
    public child: Array<Category>;
    constructor() {};
}