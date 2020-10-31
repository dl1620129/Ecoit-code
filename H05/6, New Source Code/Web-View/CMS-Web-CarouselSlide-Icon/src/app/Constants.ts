declare const Liferay: any;
export class Constants {
    constructor() { }
  
    public static baseUrl = Liferay.ThemeDisplay.getPortalURL();
    public static EcoOffice = "http://192.168.10.103/";
   
    public static groupId = Liferay.ThemeDisplay.getScopeGroupId();
    public static userId=  Liferay.ThemeDisplay.getUserId();
    public static ARTICLE_URL= '/tin-anh'

  }
  
