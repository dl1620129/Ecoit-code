import { User } from "./user.model";

export class LichChiTiet {
    public lichChiTietId: number;
    public startTime: Date;
    public selectedDate: Date = new Date();
    public description: string;
    public tenLich: string;
    public nguoiThamDu: User[];
    public nguoiChuTri: User[];
    public address: string;
    public note: string;
    public organizationId: number;
    public organizationName: string;
    public lyDoTraVe: string;
    constructor(){
    }
}