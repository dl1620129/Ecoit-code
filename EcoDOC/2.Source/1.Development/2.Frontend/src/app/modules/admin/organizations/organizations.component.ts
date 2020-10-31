import { Component, OnInit, SimpleChanges, OnChanges, DoCheck, KeyValueDiffer, KeyValueDiffers } from '@angular/core';
import { OrganizationService } from 'src/app/services/organization.service';
import { Organization } from 'src/app/core/model/domain/organization';
import { MatDialogConfig, MatDialog } from '@angular/material';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { Category } from 'src/app/core/model/domain/category';
import { TokenService } from 'src/app/core/authen/token.service';
import { CategoryService } from 'src/app/services/category.service';
import { Constant } from 'src/app/core/config/constant';
import { CommonUtils } from 'src/app/core/common/common-utils';
import { InputError } from 'src/app/core/model/domain/error/input-error';
import { ValidationService } from 'src/app/services/validation.service';
import { TreeNode } from 'primeng/api';

@Component({
  selector: 'app-organizations',
  templateUrl: './organizations.component.html',
  styleUrls: ['./organizations.component.css']
})
export class OrganizationsComponent implements OnInit, DoCheck {
  organizations: Organization[];
  organizationType: Category[];
  organization: Organization;
  titleModal;
  client;
  isAddRootOrg = false;
  currentModal: NgbModalRef;
  inputErrors: InputError;
  errorViewer = {};
  searchObject = new Organization();
  currentMaxChildOrder;
  isUpdate;

  obj = {};
  differ: KeyValueDiffer<string, any>;

  searchForm = {
    name: '',
    orgType: '',
    email: '',
    address: '',
    active: '',
    phone: '',
  };
  searchList;
  isSearch = false;
  paging = {
    itemsPerPage: Constant.ITEMS_PER_PAGE,
    currentPage: 1,
    totalRecord: -1,
  };

  orgList;
  orgObject;
  orgModel = [];
  processTreeData: TreeNode[];
  dataTree: TreeNode = {};
  orgChildren = [];
  mainTree;
  showTree;
  orgList1;
  listChildOrgs;
  currentSelect = null;

  constructor(
    private differs: KeyValueDiffers,
    private organizationService: OrganizationService,
    private categoryService: CategoryService,
    private modalService: NgbModal,
    private tokenService: TokenService,
    private toastr: ToastrService,
    private commonUtils: CommonUtils,
    private validationService: ValidationService
  ) {
    this.differ = this.differs.find({}).create();
  }
  cols;
  ngOnInit() {
    this.getOrganizationList();
    this.getOrganizationType();
    this.searchObject = new Organization();
    this.initSearchForm();
    this.cols = [
      { field: 'name', header: 'Tên đơn vị, cá nhân' },
    ];
  }

  initSearchForm() {
    this.searchObject.name = '';
    this.searchObject.email = '';
    this.searchObject.active = '';
    this.searchObject.name = '';
    this.searchObject.orgType = '';
  }

  getOrganizationList() {
    this.processTreeData = [];
    this.organizationService.getOrganizations().subscribe(data => {
      if (data != undefined) {
        this.resetTree();
        this.orgList = data;
        this.orgList1 = Array.from(data);
        for (let i = 0; i < this.orgList.length; i++) {
          if (this.orgList[i].parentId != null) {
            if (this.checkParent(this.orgList[i].id, this.orgList)) {
              this.orgList[i].haschild = true;
              this.orgList[i].nodeIcon = 'fas fa-check';
            } else {
              this.orgList[i].haschild = false;
              this.orgList[i].nodeIcon = 'fas fa-check';
            }
          } else {
            this.orgList[i].haschild = true;
            this.orgList[i].nodeIcon = 'fa fa-university';
          }
          if (this.currentSelect != null && this.orgList[i].id == this.currentSelect.id) {
            this.currentSelect = this.orgList[i];
          }
        }
        this.orgObject = {
          dataSource: this.orgList, value: 'id',
          text: 'name', parentValue: 'parentId', hasChildren: 'haschild', iconCss: 'nodeIcon'
        };
        
        this.creatDataTree();
        console.log("-------------------------");
        console.log(this.showTree);
        
        if (this.showTree.length > 0) {
          if (this.currentSelect == null) {
            this.clickOrganization(this.showTree[0].data)
          } else {
            this.clickOrganization(this.currentSelect);
          }
        }
      } else {
        this.orgList = [];
      }
    });
  }

  resetTree() {
    this.processTreeData = [];
    this.dataTree = {};
    this.orgChildren = [];
    this.orgList1 = [];
  }

  checkParent(id, list) {
    for (let i = 0; i < list.length; i++) {
      if (list[i].parentId == id) {
        return true;
      }
    }
    return false;
  }

  creatDataTree() {
    for (let i = 0; i < this.orgList1.length; i++) {
    // get parent
      if (this.orgList1[i].parentId == null) {
        this.dataTree.data = this.orgList1[i];
        this.processTreeData.push(this.dataTree);
        this.dataTree = {};
      } else {
        this.orgChildren.push(this.orgList1[i]);
      }
    }
    this.checkParentTree(this.processTreeData, this.orgChildren);
    this.mainTree = <TreeNode[]>this.processTreeData;
    if (this.mainTree && this.mainTree.length > 0) {
      this.showTree = <TreeNode[]>this.mainTree;
    }
  }

  checkParentTree(listParent, listChildren) {
    for (let i = 0; i < listParent.length; i++) {
      for (let j = 0; j < listChildren.length; j++) {
        if (listParent[i].data.id == listChildren[j].parentId) {
          if (!listParent[i].children) {
            listParent[i].children = [];
          }
          this.dataTree.data = listChildren[j];
          listChildren[j] = [];
          listParent[i].children.push(this.dataTree);
          this.dataTree = {};
          this.checkParentTree(listParent[i].children, listChildren);
        }
      }
    }
  }

  getOrganizationType() {
    this.categoryService.getCategoryWithCode(Constant.CATEGORYTYPE_CODE.ORG_TYPE).subscribe(
      res => {
        this.organizationType = res as Category[];
      },
      err => {
        console.log(err);
      }
    );
  }

  setExpanded(organization, id) {
    for (let item of this.orgList) {
      if (item.id == organization.parentId)
      {
        if (organization.id != id)
          item.expanded = true;
        if (item.parentId && item.parentId > 0)
          this.setExpanded(item, id);
        break;
      }
    }
  }

  clickOrganization(item) {
    this.currentSelect = item;
    this.listChildOrgs = [];
    this.listChildOrgs.push(item);
    for (let org of this.orgList) {
      if (org.parentId == item.id) {
        this.listChildOrgs.push(org);
      }
    }
    this.isSearch = true;
    this.searchList = this.listChildOrgs;
  }

  showOrganizationModal(content, organization, isAddRoot) {
    if (organization && organization.parentId) {
      this.orgModel = ['' + organization.parentId];
      this.setExpanded(organization, organization.id);
    }
    
    this.isAddRootOrg = isAddRoot;
    this.initDataModal(organization);
    this.currentModal = this.modalService.open(content, {centered: true, size: 'lg', windowClass: 'modal-xl'});
  }

  createorUpdateOrganization(organization) {
    if (this.organization.id > 0) {
      this.organization.parentId = this.orgModel[0]
      this.doSaveOrganization(this.organization, this.organization.id);
    } else {
      this.doSaveNewOrganization(this.organization);
    }
  }

  initDataModal(organization) {
    this.currentMaxChildOrder = this.getMaxOrder();
    if (organization == null) {
      this.isUpdate = false;
      this.client = JSON.parse(this.tokenService.getUserInfo()).client;
      console.log(this.client);
      if (!this.isAddRootOrg) {
        this.organization = {
          id: 0,
          name: '',
          phone: '',
          address: '',
          email: '',
          level: 0,
          parentId: this.currentSelect ? this.currentSelect.id : null,
          orgType: '',
          orgs: [],
          expiryDate: '',
          order: this.currentMaxChildOrder,
          active: true,
          selected: false,
          client: null
        };
        this.titleModal = 'Thêm mới đơn vị cấp dưới';
      } else {
        this.organization = {
          id: 0,
          name: '',
          phone: '',
          address: '',
          email: '',
          level: 0,
          parentId: null,
          orgType: '',
          orgs: [],
          expiryDate: '',
          order: null,
          active: true,
          selected: false,
          client: null
        };
        this.titleModal = 'Thêm mới đơn vị';
      }
    } else {
      this.isUpdate = true;
      this.titleModal = 'Cập nhật đơn vị';
      this.organization = Object.assign({}, organization);
      this.client = this.organization.client;
    }
  }

  doSaveOrganization(organization, organizationId) {
    if (this.organization.parentId) {
      let newLevel = this.organizations.find(org => org.id == this.organization.parentId).level + 1;
      console.log('newLevel', newLevel);
      this.organization.level = newLevel;
    } else if (this.organization.parentId == null) {
      this.organization.level = 0;
    }
    this.organizationService.doSaveOrganization(organization, organizationId).subscribe(
      res => {
        this.toastr.success('Cập nhật đơn vị thành công!', 'Thành công');
        this.currentModal.close();
        this.getOrganizationList();
      },
      err => {
        if (err.status == Constant.ERROR_STATUS.INPUT_ERROR) {
          this.convertErrorResponse(JSON.parse(err.error.message));
        } else {
          // this.toastr.error(err, 'Lỗi');
        }
      }
    );
  }

  doSaveNewOrganization(organization) {
    if (organization.parentId == 0 || this.isAddRootOrg == true) {
      organization.parentId = null;
      organization.level = 0;
    } else {
      organization.level = this.currentSelect.level + 1;
    }

    this.organizationService.doSaveNewOrganization(organization).subscribe(
      res => {
        this.toastr.success('Thêm mới đơn vị thành công!', 'Thành công');
        this.currentModal.close();
        this.getOrganizationList();
      },
      err => {
        console.log(err);
        if (err.status == Constant.ERROR_STATUS.INPUT_ERROR) {
          this.convertErrorResponse(JSON.parse(err.error.message));
        } else {
          // this.toastr.error(err, 'Lỗi');
        }
      }
    );
  }

  getMaxOrder() {
    if (this.currentSelect) {
      if (this.currentSelect.orgs && this.currentSelect.orgs.length > 0) {
        return Math.max(...this.currentSelect.orgs.map(o => o.order)) + 1;
      } else if (this.currentSelect.orgs && this.currentSelect.orgs.length == 0) {
        return 1;
      }
    }
  }

  showLockOrUnLockOrganizationModal(organization) {
    const message = `Bạn có chắc chắn muốn ${organization.active ? 'khóa' : 'mở khóa'}?`;
    this.commonUtils.showPopupConfirm(message, () => {
      this.activeOrDeactiveOrganization(organization);
    });
  }

  activeOrDeactiveOrganization(organization) {
    if (organization.active) {
      this.deactiveOrganization(organization.id);
    } else {
      this.activeOrganization(organization.id);
    }
  }

  activeOrganization(organizationId) {
    this.organizationService.activeOrganization(organizationId).subscribe(
      res => {
        this.toastr.success('Mở khóa đơn vị thành công!', 'Thành công');
        this.getOrganizationList();
      },
      err => {
        // this.toastr.error(err, 'Lỗi');
      }
    );
  }

  deactiveOrganization(organizationId) {
    this.organizationService.deactiveOrganization(organizationId).subscribe(
      res => {
        this.toastr.success('Khóa đơn vị thành công!', 'Thành công');
        this.getOrganizationList();
      },
      err => {
        // this.toastr.error(err, 'Lỗi');
      }
    );
  }

  getParentName(parentId) {
    return this.orgList.filter(org => org.id == parentId).map(org => org.name);
  }

  checkForm(validatedForm) {
    // console.log('validatedForm', validatedForm)
  }

  convertErrorResponse(errorResponse: InputError) {
      this.errorViewer[errorResponse.field] = errorResponse.message;
      console.log('this.errorViewer[errorResponse.field]', this.errorViewer[errorResponse.field]);
  }

  isValid(form, input) {
    this.validationService.isValid(form, input);
  }

  resetErrorViewer(inputName: string) {
    this.errorViewer[inputName] = '';
  }

  ngDoCheck() {
    const change = this.differ.diff(this.currentModal);
    if (change) {
      change.forEachChangedItem(item => {
        this.errorViewer = {};
      });
    }
  }

  searchSubmit() {
    console.log('searchSubmit :', this.searchForm);
    this.isSearch = true;
    // this.searchList = this.childMenus;
    this.paging.currentPage = 1;
    this.organizationService.searchOrganization(this.paging.currentPage, this.searchForm).subscribe(
      data => {
        this.searchList = data.content;
        this.paging.totalRecord = data.totalElements;
      }
    );
  }

  pageChanged($event) {
    this.paging.currentPage = $event;
    this.organizationService.searchOrganization(this.paging.currentPage, this.searchForm).subscribe(
      data => {
        console.log(data);
        this.searchList = data.content;
        this.paging.totalRecord = data.totalElements;
      }
    );
  }

}
