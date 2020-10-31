declare const Liferay: any;
export class Constants {
    constructor() { }
  
    public static baseUrl = Liferay.ThemeDisplay.getPortalURL();

    public static questionUrl = '/o/qaquestion/app/';
    public static categoryUrl = '/o/qacategory/app/';

    
    public static  client_id ='id-478c3327-3bef-3cc2-5f33-379a214c4a7f';
    
    public static  grant_type ='client_credentials';
    
    public static client_secret ='secret-77ce2e98-5f5e-7e19-dd2e-9362dc97377';
    public static groupId = Liferay.ThemeDisplay.getScopeGroupId();
    public static userId=  Liferay.ThemeDisplay.getUserId();
    public static languageId = Liferay.ThemeDisplay.getLanguageId();
    public static   PHAN_HOI_NHAP = 'PHAN_HOI_NHAP';
    public static   PHAN_HOI_CHO_DUYET = 'PHAN_HOI_CHO_DUYET';
    public static   PHAN_HOI_DA_DUYET = 'PHAN_HOI_DA_DUYET';
    public static   PHAN_HOI_DA_XUAT_BAN = 'PHAN_HOI_DA_XUAT_BAN';
    public static   PHAN_HOI_HUY_DUYET = 'PHAN_HOI_HUY_DUYET';
    public static   PHAN_HOI_HUY_XUAT_BAN = 'PHAN_HOI_HUY_XUAT_BAN';

  }
  
  