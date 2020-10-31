package com.ecodoc.backend.core.config;

import java.util.Arrays;
import java.util.List;


public class Constant {
	public static final int DEFAULT_LENGTH_PASSWORD_FILE = 8;
	public static final int NUMBER_OF_PAGE = 10;
	public static final int MAX_LENGTH_NAME = 20;
	public static final String UPDATE = "update";
	public static final String SAVE = "save";
	public static final String CAT_ORG_OTHER = "DVN";
	public static final String CAT_POSITION = "CVND";
	
	public static final String PASSWORD_DEFAULT = "123456";
	public static final String ACTION_ADD = "Thêm mới";
	public static final String ACTION_COMMENT = "Nhận xét";
	public static final String ACTION_ISSUED = "Ban hành";
	public static final String ACTION_READ = "Đã xem";
	public static final String ACTION_LOGIN = "Đăng nhập";
	public static final String ACTION_DONE = "Đã xử lý";
	public static final String ACTION_UNKNOW = "Chưa xác định";

	public static final int CALENDAR_WAIT = 0;
	public static final int CALENDAR_APPROVE = 1;
	public static final int CALENDAR_REJECT = 2;
	
	public static final String MAIN = "Xử lý chính";
	public static final String SUPPORT = "Xử lý phối hợp";
	public static final String SHOW = "Nhận để biết";
	public static final String ACTION_COMMING_TO = "Mới đến";
	public static final String ACTION_TRANFER_HANDLE = "Chuyển xử lý";
	public static final String ACTION_RETURN_DOC = "Trả lại văn bản";

	public static final String RECIEVE_TYPE_ORG = "ORG";
	public static final String RECIEVE_TYPE_USER = "USER";
	public static final String LINK_SIGN = "/";
	public static final int DESCRIPTION_LENGTH = 20;
	public static final int ORG_NAME_LENGTH = 100;
	public static final int ORG_PHONE_LENGTH = 50;
	public static final int ORG_ADDRESS_LENGTH = 200;
	public static final int ORG_EMAIL_LENGTH = 50;
	public static final int COMMENT_LENGTH = 2000;
	public static final String ORG_PHONE_NAME = "Số điện thoại";
	public static final String ORG_ADDRESS_NAME = "Địa chỉ";
	public static final String ORG_NAME = "Tên đơn vị";
	public static final String ORG_EMAIL_NAME = "Thư điện tử";
	public static final String ORG_TYPE_NAME = "Loại đơn vị";
	public static final String ORG_ORDER_NUMBER = "Số thứ tự";

	//default sort by
	public static final String DEFAULT_SORT_BY = "UPDATEDATE";
	public static final String DEFAULT_DIRECTION = "DESC";
	public static final String DEFAULT_PAGE_SIZE = "10";
	public static final String DEFAULT_PAGE_NUMBER = "1";
	
	public static final int MDA_NAME_LENGTH = 100;
	public static final String MDA_NAME = "Tên module";
	public static final int MDA_CODE_LENGTH = 100;
	public static final String MDA_CODE = "Mã code";
	public static final int MDA_ROUTER_PATH_LENGTH = 200;
	public static final String MDA_ROUTER_PATH = "Đường dẫn";
	public static final int MDA_DESCRIPTION_LENGTH = 1000;
	public static final String MDA_DESCRIPTION = "Mô tả";
	public static final int MDA_ICON_LENGTH = 100;
	public static final String MDA_ICON = "Icon";
	public static final int MDA_COMPONENT_NAME_LENGTH = 200;
	public static final String MDA_COMPONENT_NAME = "Tên component";
	
	public static final int PRE_NAME_LENGTH = 100;
	public static final String PRE_NAME = "Tên phần mở rộng";
	public static final int PRE_ORGID_LENGTH = 100;
	public static final String PRE_ORGID = "Tổ chức";
	public static final int PRE_EXTENSION_LENGTH = 100;
	public static final String PRE_EXTENSION = "Phần mở rộng";
	public static final int PRE_MAX_LENGTH = 100;
	public static final String PRE_MAX = "Kích thước tối đa";
	
	public static final int FOLDERENTRY_NAME_LENGTH = 100;
	public static final String FOLDERENTRY_NAME = "Tên Folder";
	public static final int FOLDERENTRY_NODEID_LENGTH = 100;
	public static final String FOLDERENTRY_NODEID = "Node ID";
	public static final int FOLDERENTRY_PARENTID_LENGTH = 100;
	public static final String FOLDERENTRY_PARENTID = "ParentID";
	
	public static final String DOMAIN = "http://118.71.99.243:8080";
	public static final String ALFRESCO_PATH_TICKET = "/alfresco/api/-default-/public/authentication/versions/1/tickets";
	public static final String ALFRESCO_PATH = "/alfresco/api/-default-/public/alfresco/versions/1";
	public static final String ALFRESCO_PATH_PRIVATE = "/alfresco/api/-default-/private/alfresco/versions/1/cmm";
	public static final String ALFRESCO_TICKET = "/tickets";
	public static final String ALFRESCO_NODE = "/nodes";
	public static final String ALFRESCO_NODE_ROOT = "-root-";
	public static final String ALFRESCO_CHILDEN = "/children";
	public static final String ALFRESCO_FOLDER = "cm:folder";
	public static final String IS_FOLDER = "&where=(isFolder=true)";
	public static final String IS_FILE = "&where=(isFile=true)";
	public static final String DESC = " DESC";
	public static final String ASC = " ASC";
	public static final String ALFRESCO_DOWNLOAD = "/content?attachment=true";
	public static final String ALFRESCO_ASZIP = "/downloads";
	public static final String ALFRESCO_TYPES = "/types";
	public static final String ALFRESCO_ASPECTS = "/aspects";
	public static final String ALFRESCO_MOVE = "/move";
	public static final String ALFRESCO_COPY = "/move";
	public static final String ALFRESCO_REDITIONS = "/renditions";
	public static final String ALFRESCO_CONTENT = "/content";
	
	public static final String BAN = "Ban";
	public static final String CUC_VU_VIEN = "Cục Vụ Viện";
	public static final String PHONG = "Phòng";
}
