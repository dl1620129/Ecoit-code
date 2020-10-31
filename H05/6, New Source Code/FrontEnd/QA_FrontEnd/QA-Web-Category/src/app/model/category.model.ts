export class Category {
    public name: string;
    public categoryId: number;
    public description: string;
    public parentId: number;
    public position: number;
    public child: Array<Category>;
    constructor() {};
}