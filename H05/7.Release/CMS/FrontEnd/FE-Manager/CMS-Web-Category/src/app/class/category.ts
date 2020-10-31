import { create } from "domain";

export class Category {
    public title: string;
    public cateId: number;
    public parentId: number;
    public orderNumber: number;
    public createDate: Date;
    public link: string;
    public description: string;
    public child: Array<Category>;
    constructor(title: string, cateId: number, parentId: number, orderNumber: number, createDate: Date, link: string, description: string, child: Array<Category>) 
    {
        this.title = title;
        this.cateId = cateId;
        this.parentId = parentId;
        this.orderNumber = orderNumber;
        this.createDate = createDate;
        this.link = link;
        this.description = description;
        this.child = child;
    }
}