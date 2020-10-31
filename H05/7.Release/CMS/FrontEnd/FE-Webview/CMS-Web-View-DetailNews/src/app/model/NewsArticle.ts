import { NewsComment } from "./NewsComment";

export class NewsArticle {
    articleId: number;
    title: string;
    summary: string;
    content: string;
    author: string;
    publishedDateFrom: any;
    imageUrl: string;
    allowComent: boolean;
    friendlyURL: string;
    comment: {
        parentCommentList: NewsComment[],
        childCommentList: NewsComment[]
    }
    constructor() {};
}