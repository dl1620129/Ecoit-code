import { Attachment } from "./attachment.model";

export class Answer {
    public answerId: number;
    public content: string;
    public attachments: Attachment[];
    constructor(){
    }
}