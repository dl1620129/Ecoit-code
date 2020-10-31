declare const Liferay: any;
export class Contains{
    public static baseUrl = Liferay.ThemeDisplay.getPortalURL();
    public static clipUrl= '/o/clip/app/';
    public static categorylUrl= '/o/clip/app/category/';
    public static userId= Liferay.ThemeDisplay.getUserId();

    public static groupId = Liferay.ThemeDisplay.getScopeGroupId();

    public static languageId = Liferay.ThemeDisplay.getLanguageId();
}