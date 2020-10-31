import { LichChiTiet } from "./lichchitiet.model";

export class LichCongTac {
    public lichCongTacId: number;
    public startDate: Date;
    public endDate: Date;
    public name: string;
    public organizationId: number;
    public organizationName: string;
    public coLyDo: boolean;
    public lyDoTraVe: string;
    public organizations: string[];
    public users: string[];
    public lichChiTietList: LichChiTiet[];
    constructor(){
        this.lichChiTietList = new Array();
        let currentDate = new Date();
        this.startDate = new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate());
        this.endDate = new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate());
    }
}