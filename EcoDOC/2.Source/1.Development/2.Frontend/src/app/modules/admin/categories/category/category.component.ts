import { Component, OnInit, Input, OnChanges, KeyValueDiffer, KeyValueDiffers } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import { Category } from 'src/app/core/model/domain/category';
import { ToastrService } from 'ngx-toastr';
import { NgbModal, NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ConfirmPopupComponent } from 'src/app/shared/popup/confirm-popup/confirm-popup.component';
import { CommonUtils } from 'src/app/core/common/common-utils';
import { NgForm } from '@angular/forms';
import { Constant } from '../../../../core/config/constant';
import { InputError } from 'src/app/core/model/domain/error/input-error';
import { ValidationService } from 'src/app/services/validation.service';


enum SearchTitles {
  UPDATE_DATE = 'UPDATE_DATE',
  ORDER = 'ORDER',
  NAME = 'NAME',
  ID = 'ID'
}

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit, OnChanges {
  urlQuery = {
    page: 1,
    name: '',
    id: '',
    active: '',
    sortBy: '',
    direction: Constant.SORT_TYPE.DECREASE,
    size: Constant.PAGING.SIZE,
  }

  inSearch = false
  
  currentModal: NgbModalRef
  maxNextOrder: number
  category;
  titleModal;
  isCollapsed = false;
  // searchForm = {
  //   name: '',
  //   id: '',
  //   active: '',
  //   page: 1
  // };

  searchTitles = SearchTitles
  pageSizeOptions = Constant.PAGE_SIZE_OPTION

  searchData;
  errorViewer = {}

  differ: KeyValueDiffer<string, any>;
  
  pagingAttribute = {
    itemsPerPage: Constant.PAGING.SIZE,
    currentPage: 1,
    totalRecord: '',
    previous: Constant.PAGING.PRIVIOUS,
    next: Constant.PAGING.NEXT,
    orgId: 1
  }

  @Input() categoryTypeId: number

  constructor(
    public categoryService: CategoryService,
    private modalService: NgbModal,
    private toastr: ToastrService,
    private commonUtils: CommonUtils,
    public activeModal: NgbActiveModal,
    private differs: KeyValueDiffers,
    public validationService: ValidationService
  ) {
    this.differ = this.differs.find({}).create();
  }

  ngOnInit() {
  }

  ngOnChanges() {
    if(this.categoryTypeId) {
      this.getAllCategory(this.categoryTypeId);
    }
  }

  checkC() {
    console.log("category", this.categoryTypeId)
  }

  getAllCategory(categoryTypeId, pageNumber=1) {
    // this.urlQuery.page = pageNumber;
    this.urlQuery.page = pageNumber
    this.categoryTypeId = categoryTypeId
    this.categoryService.getAllCategoryQueryParams(this.categoryTypeId, this.urlQuery).subscribe({
      next: data => {
        this.pagingAttribute.totalRecord = data.totalRecord,
        console.log('this.pagingAttribute.totalRecord', this.pagingAttribute.totalRecord)
        this.pagingAttribute.currentPage = pageNumber
        this.maxNextOrder = data.nextOrder + 1
        this.categoryService.categories =  data.objList ? data.objList : [] as Category[];
      },
      error: err => console.log("error")
    });
  }

  doSaveCategory(category, categoryId) {
    category.categoryTypeId = this.categoryTypeId
    this.categoryService.doSaveCategory(category, categoryId).subscribe(
      res => {
        this.toastr.success('Cập nhật danh mục thành công!', 'Thành công');
        this.currentModal.close();
        this.getAllCategory(this.categoryService.categoryTypeSelectedId);
      },
      err => {
        if (err.status == Constant.ERROR_STATUS.INPUT_ERROR) {
          this.convertErrorResponse(JSON.parse(err.error.message))
        }
        else {
          // this.toastr.error(err, 'Lỗi');
        }
      }
    );
  }

  doSaveNewCategory(category) {
    let url = "/categories/add/";
    category.categoryTypeId = this.categoryTypeId
    this.categoryService.doSaveNewCategory(category).subscribe(
      res => {
        this.toastr.success('Thêm mới danh mục thành công!', 'Thành công');
        // this.modalService.
        this.currentModal.close();
        
        this.getAllCategory(this.categoryService.categoryTypeSelectedId);
      },
      err => {
        if (err.status == Constant.ERROR_STATUS.INPUT_ERROR) {
          this.convertErrorResponse(JSON.parse(err.error.message))
        }
        else {
          // this.toastr.error(err, 'Lỗi');
        }
      }
    );
  }

  showLockOrUnLockCategoryTypeModal(category) {
    const message = `Bạn có chắc chắn muốn ${category.active ? 'khóa' : 'mở khóa'}?`;
    this.commonUtils.showPopupConfirm(message, () => {
      this.activeOrDeactiveCategory(category);
    });
  }

  activeOrDeactiveCategory(category) {
    if (category.active) {
      this.deactiveCategory(category.id);
    } else {
      this.activeCategory(category.id);
    }
  }

  activeCategory(categoryId) {
    this.categoryService.activeCategory(categoryId).subscribe(
      res => {
        this.toastr.success('Mở khóa danh mục thành công!', 'Thành công');
        this.getAllCategory(this.categoryService.categoryTypeSelectedId);
      },
      err => {
        // this.toastr.error(err, 'Lỗi');
        console.log(err);
      }
    );
  }

  deactiveCategory(categoryId) {
    this.categoryService.deactiveCategory(categoryId).subscribe(
      res => {
        this.toastr.success('Khóa danh mục thành công!', 'Thành công');
        this.getAllCategory(this.categoryService.categoryTypeSelectedId);
      },
      err => {
        // this.toastr.error(err, 'Lỗi');
        console.log(err);
      }
    );
  }

  doDeleteCategory(categoryId) {
    this.categoryService.doDeleteCategory(categoryId).subscribe(
      res => {
        this.toastr.success('Xóa danh mục thành công!', 'Thành công');
        this.getAllCategory(this.categoryService.categoryTypeSelectedId);
      },
      err => {
        // this.toastr.error(err, 'Thành công');
      }
    );
  }

  showDeleteCategoryModal(categoryId) {
    const message = "Bạn có chắc muốn xóa?";
    this.commonUtils.showPopupConfirm(message, () => {
      this.doDeleteCategory(categoryId);
    });
  }

  showCategoryModal(content, categoryIndex) {
    this.initDataModal(categoryIndex);
    this.currentModal = this.modalService.open(content, {centered: true, size: 'lg', windowClass: 'modal-xl'})
  }

  initDataModal(categoryIndex) {
    if (categoryIndex == null) {
      let order = 1;
      if (this.categoryService.categories && this.categoryService.categories.length > 0) {
        order = this.categoryService.categories[this.categoryService.categories.length - 1].order + 1;
      }
      this.category = {
        id: 0,
        name: "",
        order: this.maxNextOrder,
        resolveDate: 0,
        active: true,
        categoryTypeId: this.categoryService.categoryTypeSelectedId
      };
      this.titleModal = "Thêm mới danh mục";
    } else {
      this.titleModal = "Cập nhật danh mục";
      this.category = Object.assign({}, this.categoryService.categories[categoryIndex]);
    }
  }

  searchSubmit() {
    this.getAllCategory(this.categoryTypeId, 1)
    // this.searchData = Object.assign({}, this.searchForm);
    // if (this.searchForm.active == "0")
    //   this.searchData.active = null;
    // else
    //   this.searchData.active = (this.searchForm.active == "true")
  }

  // doFilter(category, input) {
  //   let result: boolean = true;
  //   if (category.name && input.name && input.name.length > 0) {
  //     result = result && category.name.toLowerCase().indexOf(input.name.toLowerCase().trim()) != -1;
  //   }
  //   if (input.active != null) {
  //     result = result && category.active == input.active;
  //   }
  //   if (input.id && input.id.length > 0)
  //   {
  //     result = result && category.id == Number(input.id);
  //   }
  //   return result;
  // }

  createorUpdateCategory(category) {
    console.log("create or update")
    if (this.category.id > 0) {
      this.doSaveCategory(this.category, this.category.id);
    } else {
      this.doSaveNewCategory(this.category);
    }
  }

  // validation part
  convertErrorResponse(errorResponse: InputError) {
    this.errorViewer[errorResponse.field] = errorResponse.message
    console.log('this.errorViewer[errorResponse.field]', this.errorViewer[errorResponse.field])
  }

  isValid(form, input) {
    this.validationService.isValid(form, input)
  }

  resetErrorViewer(inputName: string) {
    this.errorViewer[inputName] = ''
  }

  ngDoCheck() {
    const change = this.differ.diff(this.currentModal);
    if (change) {
      change.forEachChangedItem(item => {
        this.errorViewer = {}
      });
    }
  }

  sortByField(fieldName: string) {
    this.toggleSortType()
    this.urlQuery.sortBy = fieldName;
    // this.getAllProcesses();
    this.getAllCategory(this.categoryTypeId, this.urlQuery.page)
    if (fieldName) {
      this.urlQuery.sortBy = fieldName
    }
  }

  toggleSortType() {
    if (Constant.SORT_TYPE.DECREASE == this.urlQuery.direction) {
      this.urlQuery.direction = Constant.SORT_TYPE.INCREASE
    }
    else {
      this.urlQuery.direction = Constant.SORT_TYPE.DECREASE
    }
  }

  changePageSize() {
    // this.urlQuery.size = $event
    this.urlQuery.page = 1
    console.log("change page size here")
    this.getAllCategory(this.categoryTypeId, 1)
  }
}
