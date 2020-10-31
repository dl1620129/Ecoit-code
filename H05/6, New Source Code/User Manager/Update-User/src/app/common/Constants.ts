declare const Liferay: any;
export class Constants {
    constructor() { }
  
    public static baseUrl = Liferay.ThemeDisplay.getPortalURL();
    // public static baseUrl = 'http://localhost:8080';
    public static detailUrl = '/o/ldap/app/';
    public static  client_id ='id-478c3327-3bef-3cc2-5f33-379a214c4a7f';
    
    public static  grant_type ='client_credentials';
    
    public static client_secret ='secret-77ce2e98-5f5e-7e19-dd2e-9362dc97377';
    public static groupId = Liferay.ThemeDisplay.getScopeGroupId();
    public static userId=  Liferay.ThemeDisplay.getUserId();
    public static userMail=  Liferay.ThemeDisplay.getUserEmailAddress();
    // public static groupId=34345;
    public static SYSTEM_SUCCESS_MESSAGE = "Yêu cầu của bạn được thực hiện thành công.";

    public static SYSTEM_ERROR_MESSAGE = "Hiện đang có trục trặc hệ thống. Mong bạn thông cảm";
    
    public static NOT_ACCESS_MESSAGE = 'Bạn hiện tại không có quyền.';

    public static SUCCESSFUL_CODE = 'SUCCESSFUL';

    public static FAILED_CODE = 'FAILED';

    public static NOT_ACCESS_CODE = 'NOT_ACCESS';
  }
  
  