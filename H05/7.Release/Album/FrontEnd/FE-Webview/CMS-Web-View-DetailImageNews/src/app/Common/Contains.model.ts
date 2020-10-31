declare const Liferay: any;
export class Contains{
    public static baseUrl = Liferay.ThemeDisplay.getPortalURL();
    public static imagelUrl= '/o/image/app/';
    public static categorylUrl= '/o/image/app/category/';
    public static userId= Liferay.ThemeDisplay.getUserId();

    public static groupId = Liferay.ThemeDisplay.getScopeGroupId();

    public static languageId = Liferay.ThemeDisplay.getLanguageId();
}