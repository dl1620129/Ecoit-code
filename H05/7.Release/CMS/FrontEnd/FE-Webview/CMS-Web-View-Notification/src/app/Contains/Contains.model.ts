declare const Liferay: any;
export class Contains{
    constructor(){}

    public static baseUrl = 'http://118.71.99.245:5006/o/news';

    public static groupId = Liferay.language.getScopeGroupId();

    
    public static languageId = Liferay.language.getLanguageId();
}