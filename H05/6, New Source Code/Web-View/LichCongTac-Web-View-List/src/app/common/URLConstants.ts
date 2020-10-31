declare const Liferay: any;

export class URLConstants {

    public static HOME_URL = Liferay.ThemeDisplay.getURLHome();

    public static CURRENT_URL = Liferay.ThemeDisplay.getCanonicalURL();
}