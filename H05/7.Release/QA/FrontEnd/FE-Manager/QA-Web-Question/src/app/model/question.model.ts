import { Attachment } from "./attachment.model";

export class Question {
    public questionId: number;
    public title: string;
    public address: string;
    public email: string;
    public content: string;
    public phoneNumber: string;
    public userName: string;
    public categoryId: number;
    public status: number;
    public attachments: Attachment[];
    constructor(){
    }
}