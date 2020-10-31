import { LichChiTiet } from "./lichchitiet.model";

export class LichCongTac {
    public lichCongTacId: number;
    public startDate: Date;
    public endDate: Date;
    public name: string;
    public organizations: string[];
    public users: string[];
    public lichChiTietList: LichChiTiet[];
    constructor(){
        this.lichChiTietList = new Array();
        this.startDate = new Date();
        this.endDate = new Date();
    }
}