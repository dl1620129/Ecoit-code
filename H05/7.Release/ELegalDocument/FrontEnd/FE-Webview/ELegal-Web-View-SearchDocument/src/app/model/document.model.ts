export class DocumentModel{
    public docId: number;
    public promulDate: Date;
    public effectivedDate: Date;
    public expiredDate: Date;
    public symbol: string;
    public summary: string;
    public typeName: string;
    public signerName: string;
    public organizationName: string;
    public fieldName: string;
    public signerRels: String[];
    constructor(){};
}