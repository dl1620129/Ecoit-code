export class DocumentConstants {
 
    public static TYPE_NOT_SELECTED = 'Bạn chưa chọn lĩnh vực văn bản.';
    public static ORGANIZATION_NOT_SELECTED = 'Bạn chưa chọn cơ quan ban hành.';
    public static FIELD_NOT_SELECTED = 'Bạn chưa chọn loại văn bản.';

	public static DOCUMENT_ADD = 0;
	public static DOCUMENT_EDIT = 1;
	public static DOCUMENT_REMOVE = 2;
	public static DOCUMENT_APPROVED = 3;
	public static DOCUMENT_APPROVED_RETURN = 4;
	public static DOCUMENT_PUBLISH = 5;
	public static DOCUMENT_PUBLISH_RETURN = 6;
	public static EDIT_CATEGORY = 7;
	public static EDIT_FIELD = 8;
	public static EDIT_ORGANIZATION = 9;
	public static EDIT_SIGNER = 10;
	public static PERMISSION = 11;
	public static DOCUMENT_PENDING = 12;

    public static CONFIG_ALL = 'VAN_BAN'
    public static CONFIG_DRAFT = 'VAN_BAN_NHAP';
    public static CONFIG_PENDING = 'VAN_BAN_CHO_DUYET';
    public static CONFIG_APPROVED = 'VAN_BAN_DA_DUYET';
    public static CONFIG_PUBLISHED = 'VAN_BAN_DA_XUAT_BAN';
    public static CONFIG_APPROVED_CANCEL = 'VAN_BAN_HUY_DUYET';
    public static CONFIG_PUBLISHED_CANCEL = 'VAN_BAN_HUY_XUAT_BAN';

    public static PERMISSION_EDIT = 'EDIT';
    public static PERMISSION_PENDING = 'PENDING';
    public static PERMISSION_APPROVED = 'APPROVED';
    public static PERMISSION_PUBLISH = 'PUBLISH';
    public static PERMISSION_DENIED_APPROVE = 'DENIEDAPPROVE';
    public static PERMISSION_DENIED_PUBLISH = 'DENIEDPUBLISH';
    public static PERMISSION_REMOVE = 'REMOVE';

}