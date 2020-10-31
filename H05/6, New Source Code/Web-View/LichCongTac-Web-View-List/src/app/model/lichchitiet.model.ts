import { User } from "./user.model";

export class LichChiTiet {
    public startTime: Date;
    public selectedDate: Date;
    public description: string;
    public nguoiThamDu: User[];
    public nguoiChuTri: User[];
    public address: string;
    public note: string;
    constructor(){
    }
}