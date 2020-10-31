import { AttachmentUrl } from "./attachment-url.model";

export class Document {
    public docId: number;
    public num: string;
    public symbol: string;
    public isPublic: string;
    public summary: string;
    public promulDate: Date;
    public effectivedDate: Date;
    public expiredDate: Date;
    public organizationId: number;
    public typesList: number[];
    public fieldId: number;
    public signerRels: string[];
    public docRelation: number[];
    public replaceDoc: number[];
    public content: string;
    public attachmentURLsList: AttachmentUrl[];
    public isNeverExpired: boolean;
    public newGopY: boolean;
    constructor(){
        this.docId = 0;
        this.num = "";
        this.symbol = "";
        this.isPublic = "1";
        this.summary = "";
        this.promulDate = new Date();
        this.effectivedDate = new Date();
        this.expiredDate = null;
        this.organizationId = 0;
        this.fieldId = 0;
        this.content = "";
        this.typesList = new Array();
        this.signerRels = new Array();
        this.docRelation = new Array();
        this.replaceDoc = new Array();
        this.attachmentURLsList = new Array();
        this.isNeverExpired = true;
        this.newGopY = false;
    }
}