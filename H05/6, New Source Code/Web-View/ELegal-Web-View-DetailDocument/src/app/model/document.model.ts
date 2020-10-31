export class LegalDocument {
    public docId: number;
    public promulDate: Date;
    public publishedDate: Date;
    public effectivedDate: Date;
    public expiredDate: Date;
    public symbol: string;
    public summary: string;
    public content: string;
    public typeName: string;
    public signerName: string;
    public organizationName: string;
    public fieldName: string;
    public view: number;
    public signerRels: String[];
    constructor() {};
}