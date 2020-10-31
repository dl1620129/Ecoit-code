import {RoleComponent} from "src/app/modules/operation/role/role.component";
import {PermissionComponent} from "src/app/modules/operation/permission/permission.component";
// @ts-ignore
import config from "../../../assets/config.json";

export class Constant {
  public static ITEMS_PER_PAGE = 10;
  public static MAX_FILES_UPLOAD = 10
  public static API_ENDPOINT = config.BACKEND_URL+"/api";
  public static PORTAL_URL = config.PORTAL_URL
  public static EMAIL_URL = config.EMAIL_URL
  public static LOGOUT = config.BACKEND_URL + "/logout";
  public static LOGIN = config.BACKEND_URL + "/secured";
  public static ALLOWED_FILE_EXTENSION = ".doc, .docx, .xls, .xlsx, .ppt, .pptx, .jpg, .png, .pdf"
  public static ALLOWED_DRAFT_FILE_EXTENSION = ".doc, .docx, .pdf"
  public static ALLOWED_FILE_IMAGE = ".jpg, .png, .jpeg"
  public static API_AUTHEN = `${Constant.API_ENDPOINT}/users/login`;
  public static API_AUTHEN_CAS = `${Constant.API_ENDPOINT}/users/login/cas`;
  public static ADD_PERMISSION = '/permission/updateAuthorizeModule/';
  public static GET_ROLE = '/role/getAll';
  public static GET_USER_BY_ROLE = '/role/getUserActiveByRole/';
  public static ADD_USER_ROLE_PATCH = '/permission/addAuthorizeUserList/';
  public static ACTIVE_USER_ROLE = '/permission/inactiveAuthorizeUser/';
  public static UPDATE_ROLE = '/role/updateRole/';
  public static ACTIVE_ROLE = '/role/active/';
  public static DEACTIVE_ROLE = '/role/deactive/';
  public static DELETE_ROLE = '/role/delete/';
  public static ADD_ROLE = '/role/add';
  public static GET_CLIENTS = '/clients';
  public static ADD_DOCUMENT_BOOK = '/document-book/add';
  public static UPDATE_DOCUMENT_BOOK = '/document-book/update/';
  public static GET_DOCUMENT_BOOK = '/document-book/getAll/';
  public static API_AUTHEN_SERIAL = '/users/login/serial';
  



  public static DEACTIVE_DOCUMENT_BOOK = '/document-book/deactive/';
  public static ACTIVE_DOCUMENT_BOOK = '/document-book/active/';
  public static SEARCH_DOCUMENT_BOOK = `${Constant.API_ENDPOINT}/document-book/searchDocumentBook`;
  public static GET_DOCUMENT_BOOK_BY_TYPE = '/document-book/getByType/';
  public static MAX_SIZE_FILE_UPLOAD = 100 * 1024 * 1024;
  public static TIME_MILISECOND_24H = 24 * 60 * 60 * 1000;
  public static GET_POSITION_BY_ROLE = '/role/getPositionActiveByRole/';
  public static ADD_POSITION_ROLE_PATCH = '/permission/addAuthorizePositionList/';
  public static ACTIVE_POSITION_ROLE = '/permission/inactiveAuthorizePosition/';
  public static LINK_SIGN = '/';
  public static AUTHEN_CAS = config.AUTHEN_CAS;

  public static DOCUMENT_IN_FILE_TYPE = {
    DRAFT: "DRAFT",
    DOCUMENT: "DOCUMENT",
    COMMENT: "COMMENT"
  }
  public static MODULE_ADMIN = {
    GETALL : '/module-admin/getAllModuleAdmin',
    CREATE : '/module-admin/create/',
    UPDATE : '/module-admin/update/',
    DEACTIVE : '/module-admin/deactive/',
    ACTIVE : '/module-admin/active/',
    SEARCH : '/module-admin/search/',
  }
  public static PREFERENCES = {
    GETALL : '/preferences/getAllPreferences',
    CREATE : '/preferences/create',
    UPDATE : '/preferences/update/',
    DEACTIVE : '/preferences/deactive/',
    ACTIVE : '/preferences/active/',
    SEARCH: '/preferences/search/'
  }
  public static ALFRESCO = {
    CREAT_FOLDER: "/alfresco/addFolder",
    CREAT_FILE: "/alfresco/addFile",
    GET_TICKET: "/alfresco/getTicket",
    GET_IDFILE :  "/alfresco/getIdFile",
    GET_ALL: "/alfresco/getAll",
    DELETE: "/alfresco/delete",
    DOWNLOAD: "/alfresco/download",
    AS_ZIP: "/alfresco/as-zip-file",
    GET_AS_ZIP: "/alfresco/get-as-zip-file",
    DOWNLOAD_AS_ZIP: "/alfresco/download-as-zip-file",
    UPDATE_FOLDER: "/alfresco/updateFolder",
    GET_FOLDER: "/alfresco/getFolder",
    PREVIEW_DOCUMENT: "/alfresco/previewDocument",
  }
  public static ALFRESCO_MODEL = {
    CREATE: "/alfresco/model/addModel",
    GETALL: "/alfresco/model/get-all",
    UPDATE: "/alfresco/model/updateModel",
    DELETE: "/alfresco/model/delete",
    GET_DETAIL: "/alfresco/model/get-model-detail",
    GET_ALL_CUSTOM_TYPE: "/alfresco/model/custom-type/get-all",
    GET_ALL_ASPECTS: "/alfresco/model/aspects/get-all",
    CREATE_CUSTYPE: "/alfresco/model/custom-type/create",
    DELETE_CUSTOM_TYPE: "/alfresco/model/custom-type/delete",
    GET_DETAIL_CUSTOM_TYPE: "/alfresco/model/custom-type/get-detail",
    DELETE_ASPECTS: "/alfresco/model/aspects/delete",
    CREATE_PROPERTIES: '/alfresco/model/properties/create',
    UPDATE_PROPERTIES: '/alfresco/model/properties/update',
    DELETE_PROPERTIES: '/alfresco/model/properties/delete',
  }
  public static FOLDER = {
    GETALL: '/folder-entry/getAll',
    CREATE: '/folder-entry/create',
    UPDATE: '/folder-entry/update/',
    DEACTIVE: '/folder-entry/deactive/',
    ACTIVE: '/folder-entry/active/',
  }
  public static FILE = {
    GETALL: '/fileentry/getAll',
    CREATE: '/fileentry/add',
    UPDATE: '/fileentry/update/',
    DEACTIVE: '/fileentry/unactive/',
    ACTIVE: '/fileentry/active/',
  }
  public static DECENTRALIZATION = {
    ADDDECEN:'/decentralization/addDecen',
  }
  public static FIELDS = {
    GETALL: '/fields/getAll',
    CREATE: '/fields/create',
    UPDATE: '/fields/update/',
    ACTIVE: '/fields/active/',
    DELETE: '/fields/delete/',
  }
  public static FIELDS_TYPE = {
    GETALL: '/field-type/getAll',
    CREATE: '/field-type/create',
    UPDATE: '/field-type/update/',
    ACTIVE: '/field-type/active/',
    DELETE: '/field-type/delete/',
  }

  public static PAGING = {
    SIZE: 10,
    PRIVIOUS: 'Trang trước',
    NEXT: 'Trang sau'
  }

  public static ERROR_STATUS = {
    NOT_FOUND: '404',
    SERVER_ERROR: '500',
    INPUT_ERROR: '422'
  }

  public static PAGE_SIZE_OPTION =[
    { name: '5', value: 5},
    { name: '10', value: 10},
    { name: '25', value: 25},
    { name: '50', value: 50}
  ]

  public static COMPONENT_CODE = {
    'ROLE': RoleComponent,
    'PERMISSION': PermissionComponent,
  }

  public static SYSTEM_PARAM = {
    'NAME_SYSTEM': 'Quản lý tài liệu',
    'PRESENT_SYSTEM': 'Hệ thống Quản lý tài liệu - EcoDoc'
  }


  public static DOCUMENT_BOOK_TYPE = [
    {
      "name": "Văn bản đến",
      "code": 0,
      "documentStatus": [
        {
          key: 'RETURN_DOC',
          value: 'Trả lại văn bản',
        },
        {
          key: 'RETAKE_DOC',
          value: 'Thu hồi văn bản',
        },
        {
          key: 'DOING',
          value: 'Đang xử lý',
        },
        {
          key: 'NOT_YET',
          value: 'Chờ xử lý',
        },
        {
          key: 'DONE',
          value: 'Hoàn thành',
        }
      ]
    },
    {
      "name": "Văn bản đi",
      "code": 1,
      "documentStatus": [
        {
          key: 'DU_THAO',
          value: 'Dự thảo',
        },
        {
          key: 'DANG_XU_LY',
          value: 'Đang xử lý',
        },
        {
          key: 'CHO_BAN_HANH',
          value: 'Chờ ban hành',
        },
        {
          key: 'DA_BAN_HANH',
          value: 'Đã ban hành',
        },
        {
          key: 'BI_TRA_LAI',
          value: 'Bị trả lại',
        },
        {
          key: 'THU_HOI_XL',
          value: 'Thu hồi',
        },
        {
          key: 'THU_HOI_BH',
          value: 'Thu hồi',
        }
      ]
    }
  ]

  public static DOCUMENT_TYPE = [
    {
      "name": "Văn bản đến",
      "code": 0,
      "documentStatus": [
        {
          key: 'RETURN_DOC',
          value: 'Trả lại văn bản',
        },
        {
          key: 'RETAKE_DOC',
          value: 'Thu hồi văn bản',
        },
        {
          key: 'DOING',
          value: 'Đang xử lý',
        },
        {
          key: 'NOT_YET',
          value: 'Chờ xử lý',
        },
        {
          key: 'DONE',
          value: 'Hoàn thành',
        }
      ]
    },
    {
      "name": "Văn bản đi",
      "code": 1,
      "documentStatus": [
        {
          key: 'DU_THAO',
          value: 'Dự thảo',
        },
        {
          key: 'DANG_XU_LY',
          value: 'Đang xử lý',
        },
        {
          key: 'CHO_BAN_HANH',
          value: 'Chờ ban hành',
        },
        {
          key: 'DA_BAN_HANH',
          value: 'Đã ban hành',
        },
        {
          key: 'BI_TRA_LAI',
          value: 'Bị trả lại',
        },
        {
          key: 'THU_HOI_XL',
          value: 'Thu hồi',
        },
        {
          key: 'THU_HOI_BH',
          value: 'Thu hồi',
        }
      ]
    }
  ]

  public static DOCUMENT_STATUS = {
    WAIT_PROCESS: 'Chờ xử lý',
    IN_PROCESS: 'Đang xử lý',
    DONE: 'Hoàn thành',
    REJECT: 'Trả lại',
    DRAFT: 'Dự thảo',
    DRAFT_REJECT: 'Bị trả lại',
    WAIT_ISSUED: 'Chờ ban hành',
    DONE_ISSUED: 'Đã ban hành',
  }

  public static DOCUMENT_OUT_STATUS = {
    // // for document in
    RETURN_DOC: "Trả lại văn bản",
    RETAKE_DOC: "Thu hồi văn bản",
    DOING: "Đang xử lý",
    NOT_YET: "Chờ xử lý",
    DONE: "Hoàn thành"
  };

  public static DOCUMENT_IN_STATUS = {
    DU_THAO: "Dự thảo",
    DANG_XU_LY: "Đang xử lý",
    CHO_BAN_HANH: "Chờ ban hành",
    DA_BAN_HANH: "Đã ban hành",
    BI_TRA_LAI: "Bị trả lại",
    THU_HOI_XL: "Thu hồi",
    THU_HOI_BH: "Thu hồi",
  }

  public static DOCUMENT_STATUS_TYPE = {
    HANDLED: 0,
    WAIT_HANDLE: 1,
    HANDLING: 2
  }

  public static PERSON_HANDLE_TYPE = {
    MAIN: 0,
    COMBINE: 1,
    SHOW: 2,
    MAIN_AND_COMBINE: 3
  }

  public static STATUS = [
    {
      "name": "Hoạt động",
      "value": true
    },
    {
      "name": "Không hoạt động",
      "value": false
    }
  ]

  public static CATEGORYTYPE_CODE = {
    SECURITY: 'DMVB',
    URGENT: 'DKVB',
    ORG_TYPE: 'LDV',
    DOC_TYPE: 'LVB',
    DOC_FIELDS: 'LVVB',
    BOOK: 'SVB',
    METHOD_RECEIPT: 'PTNVB',
    ORG_SEND: 'DVN',
    DOC_STATUS: 'TTVB',
    USER_POSITION: 'CVND',
    CALENDAR_CATEGORY: 'CALENDARCAT',
    ROOM_CATEGORY: 'PH',
    TASK_FIELD: 'LVCV',
    PRIORITY: 'UT'
  }

  public static CATEGORYTYPE = {
    GET_ALL: '/category-type/getAllSort/',
    GET_ALL_WITH_PAGING: '/category-type/getAllSortAndPage/',
    GET_ONCE: '/category-type/getById/',
    ADD: '/category-type/add',
    UPDATE: '/category-type/update/',
    DELETE: '/category-type/delete/',
    ACTIVE: '/category-type/active/',
    DEACTIVE: '/category-type/deactive/'
  }

  public static CATEGORY = {
    GET_ALL: '/categories/getAllSort/',
    GET_ONCE: '/categories/getById/',
    GET_BY_CATEGORY_TYPE_ID: '/categories/getAllByCategoryTypeId/',
    GET_BY_CATEGORY_TYPE_ID_PAGING: '/categories/getAllByCategoryTypeIdPaging/',
    GET_BY_CATEGORY_TYPE_CODE: '/categories/getAllByCategoryTypeCode/',
    ADD: '/categories/add',
    UPDATE: '/categories/update/',
    DELETE: '/categories/delete/',
    ACTIVE: '/categories/active/',
    DEACTIVE: '/categories/deactive/'
  }

  public static MAP_CATEGORY = {
    GET_ALL: '/map_category/getAll/'
  }

  public static ORGANIZATION = {
    GET_ALL: '/org/getAllSort/',
    GET_ROOT: '/org/findByNoParent/',
    GET_LIST_ROOT: '/org/findByNoParent/',
    GET_ONCE: '/org/getById/',
    ADD: '/org/add',
    UPDATE: '/org/update/',
    DELETE: '/org/delete/',
    ACTIVE: '/org/active/',
    DEACTIVE: '/org/deactive/',
    SEARCH: '/org/search/'
  }

  public static DOCUMENT_OUT = {
    GET_ALL: '/document/getAll',
    GET_ALL_WAITING: "/document/getNotDoneDocsByUser",
    GET_ALL_DONE: '/document/getDoneDocsByUser',
    GET_BY_ID: '/document/getById/',
    GET_DETAIL_BY_ID: "/document/getDetailById/",
    GET_ARRIVAL: '/document/getNumberArrival',
    ADD: '/document/add',
    UPDATE: '/document/update/',
    DELETE: '/document/delete/',
    ACTIVE: '/document/active/',
    DEACTIVE: '/document/deactive/',
    REJECT: '/document/returnDoc/',
    RETAKE: '/document/retake/',
    TRANSFER: '/document/transferHandle/',
    TRANSFER_TRACKING: '/doc_in_process/listTracking/',
    LOG_TRACKING: '/doc_in_tracking/follow/',
    INCOMMING_BASIC_SEARCH: '/document/findBasic?',
    INCOMMING_ADVANCE_SEARCH: '/document/findAdvance?',
    DONE_DOC_BASIC_SEARCH: '/document/findBasicDoneDoc?',
    DONE_DOC_ADVANCE_SEARCH: '/document/findAdvanceDoneDoc?',
    WAIT_DOC_BASIC_SEARCH: '/document/findBasicExeDoc?',
    WAIT_DOC_ADVANCE_SEARCH: '/document/findAdvanceExeDoc?',
    HANDLING_DOC_SEARCH: '/document/find_process_doc?',
    BASIC_ALL_SEARCH: '/document/findBasicAllDoc?',
    ADVANCE_ALL_SEARCH: '/document/findAllDoc?',
    EXPORT_EXCEL: '/document/exportExcel?',
    FIND_DOC_REPLY: '/document/findDocReply',
    UPDATE_DEADLINE: '/document/updateDeadline/',
    FIND_DOC_BY_TYPE: '/document/findDocByTypeHandle/',
    TRANSFER_LIST: '/document/transferHandleList/',
  }

  public static ROLES = {
    CLERICAL: 'Văn thư'
  }

  public static DOCUMENT_PROCESS = {
    DONE: '/doc_in_process/done/',
    // HANDLE_TYPE: '/process_doc/getTypeHandleByUsername/'
    HANDLE_TYPE: '/doc_in_process/getTypeHandleByUsername/'
  }

  public static HANDLE_TYPE = {
    MAIN: 'MAIN',
    SUPPORT: 'SUPPORT',
    SHOW: 'SHOW'
  }

  public static DOCUMENT_OUT_COMMENT = {
    GET_ALL_BY_DOC_ID: '/comment_doc/getListByDocId/',
    ADD: '/comment_doc/addDoc',
    ADD_ATTACHMENT: '/attachment_comment/addAttachmentComment/'
  }

  public static SAVE_ACTION = {
    SAVE_AND_CLOSE: 1,
    SAVE_AND_COPY: 2,
    SAVE_AND_NEW: 3,
    SAVE_OF_TRANSFER: 4,
    SAVE_OF_DONE: 5
  }

  public static BUSINESS_LOG = {
    SEARCH: '/log/search',
    EXPORT: '/log/export'
  }

  public static ATTACHMENT = {
    GET_BY_ID: '/attachment/getById/',
    ADD: '/attachment/add',
    UPDATE: '/attachment/update/',
    ACTIVE: '/attachment/active/',
    DEACTIVE: '/attachment/deactive/',
    DELETE: '/attachment/delete/',
    DELETE_BY_DOC: '/attachment/deleteByDoc/'
  }

  public static PROCESS = {
    SEARCH: '/bpmn2/search',
    GET_ALL: '/bpmn2/getAll',
    GET_BY_ID: '/bpmn2/getById/',
    DELETE: '/bpmn2/delete/',
    ACTIVE: '/bpmn2/update/',
    DEACTIVE: '/bpmn2/update/',
    UPDATE: '/bpmn2/update/',
    ADD: '/bpmn2/add'
  }

  public static RETAKE = {
    GET_DOCUMENT_IN: '/document_out/getListIssued/',
    GET_DOCUMENT_OUT: '',
    RETAKE_DOCUMENT_IN: '',
    RETAKE_DOCUMENT_OUT: ''
  }

  public static DIRECTION = {
    ASC: 'ASC',
    DESC: 'DESC'
  }

  public static THREAD = {
    GET_BPMN_BY_TYPE: '/bpmn2/type/'
  };

  public static TASK_NEW = {
    ADD_TASK_ASSIGN: '/task/addTaskAssign',
    GET_BY_USER_EXECUTE: '/task/findByUserExecute',
    GET_BY_USER_COMBINATION: '/task/findByUserCombination',
    GET_BY_USER_ASSIGN: '/task/findByUserAssign',
    UPDATE_STATUS: '/task/updateStatus',
    ADD_COMMENT: '/taskComment/add',
    ADD_COMMENT_ATTACHMENT: '/taskAtt/add/',
    DOWNLOAD_ATTACHMENT: '/files/',
    GET_COMMENT: '/taskComment/getComment/',
    SEARCH_DOC_OUT: '/document_out/find_all/',
    SEARCH_DOC_IN: '/document/find_all/',
    UPDATE_COMPLETED: '/task/updateCompleted/',
    FIND_BY_ID: '/task/findById/',
    GET_ASSIGN: '/task/getByAssign/',
    SEARCH: '/task/findByTaskName/',
    ADD_USER_APPROVE: '/task/addUserApprove',
    DELETE_TASK_EXECUTE: '/task/deleteTaskExecute/',
    FIND_BY_CLIENT_ID: '/task/findByClientId/',
    DELETE_TASK_ACTIVE: '/task/delete',
    ADD_TASK_DOC: '/task/addTaskDoc'
  };

  public static THREAD_TYPE = {
    INCOMING: 'INCOMING',
    OUTCOMING: 'OUTCOMING',
    ASSIGN: 'ASSIGN',
    EXAM_FOR_OTHERS: 'EXAM_FOR_OTHERS'
  }

  public static POSITION = {
    PAGINATED: '/categories/findPosition/',
  }

  public static USER = {
    SEARCH_USER_ACTIVE: '/users/search',
    SEARCH_USER_ORG:'/users/all-user-in-org',
    SEARCH_USER_ACTIVE1: '/users/search1',
  }

  public static CALENDAR = {
    ADD: '/calendar/addCalendar',
    ADD_JOIN: '/calendar/addlistJoin/',
    GET_USER_JOIN: '/calendar/getCalendarJoin/',
    GET: '/calendar/getByMonth',
    GET_TIME: '/calendar/getTimes',
    FIND_BY_BOOK_BY: '/calendar/findByBookBy',
    FIND_BY_TITLE: '/calendar/findByName'
  }

  public static ROOM = {
    GET_ALL: '/room/getAll',
    ADD_ROOM: '/room/addRoom',
    UPDATE_ROOM: '/room/updateRoom/',
    findByName: '/room/findByName',
    findById: '/room/findById/',
    GET_BY_ORG: '/room/getRoomByOrg/',
  }

  public static DOCUMENT_IN_DRAFT = {
    GET_DATA_INIT: '/document_out/getDataInit/'
  }

  public static DOCUMENT_IN_MENU = {
    DRAF: 1,
    HANDLE: 2,
    ISSUED: 3,
    DOC_IN: 4,
    SEARCH: 5
  }

  public static ATTACHMENT_DOWNLOAD_TYPE = {
    DOCUMENT_IN: 'document_in',
    DOCUMENT_OUT_COMMENT: 'document_out_comment',
    DOCUMENT_OUT: 'document_out',
    DELEGATE: 'delegate'
  }

  public static SORT_TYPE = {
    INCREASE: 'ASC',
    DECREASE: 'DESC',
    NO_SORT: 'NO_SORT'
  }

  public static DELEGATE = {
    IN_REJECT: '/document/delegate_reject/',
    IN_TRANSFER: '/document/delegate_transfer/',
    IN_TRANSFER_DONE: '/doc_in_process/delegate_finish/',

    OUT_REJECT: '/document/delegate_reject/',
    OUT_TRANSFER: '/document/delegate_transfer/',
    OUT_TRANSFER_DONE: '/document/delegate_finish/',
  }

  public static DRAFT_TAB = {
    DANH_SACH_VAN_BAN_DI: 'DANH_SACH_VAN_BAN_DI'
  }

  // sub is combine
  // show is to know
  // public static PERSON_HANDLE_TYPE = {
  //   MAIN: 'MAIN',
  //   SUB: 'SUB',
  //   SHOW: 'SHOW'
  // }
  public static USE_DELEGATE_FROMUSER_LIST = false;

  public static FROM_NEW = {
    GET_ALL_FIELDS: '/fields/getAll',
    CREATE_FIELD: '/fields/createUpdateFields',
    GET_ID_FIELD: '/fields/getIdField/',
    CREATE_FIELD_TYPE: '/fields/addFieldType',
    UPDATE_ACTIVE_FIELD: '/fields/updateActive',
    UPDATE_ACTIVE_FIELD_TYPE: '/fields/updateActiveFieldType',
    GET_ID_FIELD_TYPE: '/fields/getIdFieldType/'
  };
}
