import { LichChiTiet } from "./lichchitiet.model";

export class DateObject {
    public day: Date;
    public isDisplay: boolean = false;
    public morningList: LichChiTiet[] = new Array();
    public afternoonList: LichChiTiet[] = new Array();
    constructor(){
    }
}