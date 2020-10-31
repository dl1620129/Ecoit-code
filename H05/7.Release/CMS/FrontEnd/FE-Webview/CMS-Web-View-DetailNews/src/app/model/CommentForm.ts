export class CommentForm {
    name: string;
    email: string;
    content: string;
    constructor(name: string, email: string, content: string) {
        this.name = name;
        this.email = email;
        this.content = content;
    };
}