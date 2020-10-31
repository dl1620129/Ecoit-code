declare const Liferay: any;
export class Constants {
    constructor() { }
  
    public static baseUrl = Liferay.ThemeDisplay.getPortalURL();
    // public static baseUrl = 'http://localhost:8080';
    public static  client_id ='id-478c3327-3bef-3cc2-5f33-379a214c4a7f';
    
    public static  grant_type ='client_credentials';
    
    public static client_secret ='secret-77ce2e98-5f5e-7e19-dd2e-9362dc97377';
    public static groupId = Liferay.ThemeDisplay.getScopeGroupId();
    // public static groupId=34345;
  }
  
  