export class Category {
    public title: string;
    public cateId: number;
    public parentId: number;
    public orderNumber: number;
    public createDate: Date;
    public child: Array<Category>;
    constructor(title: string, cateId: number, parentId: number, orderNumber: number, createDate: Date, child: Array<Category>) 
    {
        this.title = title;
        this.cateId = cateId;
        this.parentId = parentId;
        this.orderNumber = orderNumber;
        this.createDate = createDate;
        this.child = child;
    }
}