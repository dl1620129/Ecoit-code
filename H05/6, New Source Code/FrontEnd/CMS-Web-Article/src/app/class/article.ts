export class Article {
    public articleId: number;
    public title: string;
    public summary: string;
    public content: any;
    public imageDes: string;
    public author: string;
    public source: string;
    public images: File;
    public category: any[];
    public site: any[];
    public involve: any[];
    public isComment: boolean;
    public isNoibat: boolean;
    public homePage: boolean;
    public orderShowHomePage: string;
    public humanAccessArticle: any[];
    public tags: any[];
    public events: any[];
    public henGio: boolean;
    public thoiGianHenGio: any;
    public neverExpire: boolean;
    public publishedDateFrom: any;
    public publishedDateTo: any;
    public userPermissisons: any[];
    public comment: any;
    constructor(
        articleId: number,
        title: string,
        summary: string,
        content: any,
        imageDes: string,
        author: string,
        source: string,
        images: File,
        category: any[],
        site: any[],
        involve: any[],
        isComment: boolean,
        isNoibat: boolean,
        homePage: boolean,
        orderShowHomePage: string,
        humanAccessArticle: any[],
        tags: any[],
        events: any[],
        henGio: boolean,
        thoiGianHenGio: any,
        neverExpire: boolean,
        publishedDateFrom: any,
        publishedDateTo: any,
        userPermissisons: any[],
        comment: any
    ){
        this.articleId = articleId;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.imageDes = imageDes;
        this.author = author;
        this.source = source;
        this.images = images;
        this.category = category;
        this.site = site;
        this.involve = involve;
        this.isComment = isComment;
        this.isNoibat = isNoibat;
        this.homePage = homePage;
        this.orderShowHomePage = orderShowHomePage;
        this.humanAccessArticle = humanAccessArticle;
        this.tags = tags;
        this.events = events;
        this.henGio = henGio;
        this.thoiGianHenGio = thoiGianHenGio;
        this.neverExpire = neverExpire;
        this.publishedDateFrom = publishedDateFrom;
        this.publishedDateTo = publishedDateTo;
        this.userPermissisons = userPermissisons;
        this.comment = comment;
    };
}