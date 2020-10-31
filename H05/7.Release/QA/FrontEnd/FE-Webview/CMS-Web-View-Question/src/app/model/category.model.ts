export class CategoryModel{
    categoryId: number;
    name: string;
    description: string;
    position: string;
    parentId: string;
    child: CategoryModel[];
    constructor(){}
}