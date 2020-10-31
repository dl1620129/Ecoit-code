declare const Liferay: any;

export class URLConstants {

    public static HOME_URL = Liferay.ThemeDisplay.getURLHome();

    public static ARTICLE_URL = "/bài-viết";

    public static CATEGORY_URL = "/chuyên-mục";

    public static CHILD_CATEGORY_URL = "/chuyên-mục-con";
}