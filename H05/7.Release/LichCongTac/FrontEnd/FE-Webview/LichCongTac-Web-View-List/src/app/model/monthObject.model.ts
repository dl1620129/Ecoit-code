import { LichChiTiet } from "./lichchitiet.model";

export class MonthObject {
    public day: Date;
    public chitietList: LichChiTiet[] = new Array();
    public isDisplay: boolean = false;
    constructor(){
    }
}