export class ArticleComment {
    public parentId: number;
    public commentId: number;
    public username: string;
    public content: string;
    public createdDate: Date;
    public approved: boolean = false;
    public likes: number;
    
    constructor(
    ) {}
}