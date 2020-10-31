declare const Liferay: any;

export class Constants {
 
    public static baseUrl = Liferay.ThemeDisplay.getPortalURL();

    //public static userId = 'id-28d8c6c7-16de-0af2-5eb2-bed66c4cd63';
    public static userId= Liferay.ThemeDisplay.getUserId();

    public static clientSecret = 'secret-7b2df2e0-33b4-819f-5f67-ded9be65f9ec';

    public static scopeGroupId = Liferay.ThemeDisplay.getScopeGroupId();

    public static languageId = Liferay.ThemeDisplay.getLanguageId();

    public static SUCCESSFUL_CODE = 'SUCCESSFUL';

    public static FAILED_CODE = 'FAILED';

    public static NOT_ACCESS_CODE = 'NOT_ACCESS';

    public static DISPLAY_LIMIT = 5;
}