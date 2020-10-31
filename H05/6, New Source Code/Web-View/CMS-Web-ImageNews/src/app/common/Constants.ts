declare const Liferay: any;
export class Constants {
    constructor() { }
  
    public static baseUrl = Liferay.ThemeDisplay.getPortalURL();

    public static categorylUrl = '/o/image/app/category/';
    public static imagelUrl = '/o/image/app/';
    public static  client_id ='id-478c3327-3bef-3cc2-5f33-379a214c4a7f';
    
    public static  grant_type ='client_credentials';
    
    public static client_secret ='secret-77ce2e98-5f5e-7e19-dd2e-9362dc97377';
    public static groupId = Liferay.ThemeDisplay.getScopeGroupId();
    public static userId=  Liferay.ThemeDisplay.getUserId();
    public static ARTICLE_URL= '/tin-anh'
    public static LIST_ARTICLE= '/danh-sach-tin-anh'

  }
  
  