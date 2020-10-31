import {Component, OnInit, EventEmitter, Output} from '@angular/core';
import {CategoryService} from 'src/app/services/category.service';
import {NgbModal, NgbModalRef} from '@ng-bootstrap/ng-bootstrap';
import {CategoryType} from 'src/app/core/model/domain/category-type';
import {Category} from 'src/app/core/model/domain/category';
import {ToastrService} from 'ngx-toastr';
import {ConfirmPopupComponent} from 'src/app/shared/popup/confirm-popup/confirm-popup.component';
import {CommonUtils} from 'src/app/core/common/common-utils';
import {NgForm} from '@angular/forms';
import {Constant} from '../../../../core/config/constant';

@Component({
  selector: 'app-category-type',
  templateUrl: './category-type.component.html',
  styleUrls: ['./category-type.component.css']
})
export class CategoryTypeComponent implements OnInit {
  urlQuery = {
    page: 1
  }
  isValid: boolean;
  categoryType: CategoryType;
  categoriesType: CategoryType[];
  categoryTypeSelectedId: number;
  categoryTypeSelectedIndex: number = 0;
  titleModal;
  categoryTypeId
  currentModal: NgbModalRef

  @Output() sendCategoryTypeId = new EventEmitter<number>();

  categoryTypePaging = {
    itemsPerPage: Constant.PAGING.SIZE,
    currentPage: 1,
    totalRecord: '',
    previous: Constant.PAGING.PRIVIOUS,
    next: Constant.PAGING.NEXT,
    orgId: 1
  }

  constructor(
    private categoryService: CategoryService,
    private modalService: NgbModal,
    private toastr: ToastrService,
    private commonUtils: CommonUtils,
  ) {
  }

  ngOnInit() {
    this.getAllCatalogyTypeWithPaging();
  }

  getAllCatalogyTypeWithPaging(pageNumber: number = 1) {
    this.urlQuery.page = pageNumber
    this.categoryService.getAllCatalogyTypeWithPaging(this.urlQuery).subscribe(
      res => {
        this.categoryTypePaging.currentPage = pageNumber
        this.categoryTypePaging.totalRecord = res.totalRecord
        this.categoriesType = res.objList as CategoryType[];
        console.log(this.categoriesType)
        console.log(this.categoriesType[0].id)
        this.sendCategoryTypeId.emit(this.categoriesType[0].id)
        if (this.categoriesType != null && this.categoriesType != undefined && this.categoriesType.length > 0) {
          this.categoryTypeSelectedId = this.categoriesType[this.categoryTypeSelectedIndex].id;
          this.categoryService.categoryTypeSelectedId = this.categoryTypeSelectedId;
          // this.getAllCategory(this.categoryTypeSelectedId);

        }
      },
      err => {
        console.log(err);
      }
    );
  }

  getAllCategory(categoryTypeId) {
    this.categoryService.getAllCategory(categoryTypeId).subscribe(
      res => {
        this.categoryService.categories = res as Category[];
      },
      err => {
        console.log(err);
      }
    );
  }

  doSelectCategoryType(categoryTypeId, categoryTypeIndex) {
    this.categoryTypeSelectedId = categoryTypeId;
    this.categoryTypeSelectedIndex = categoryTypeIndex;
    // this.getAllCategory(this.categoryTypeSelectedId);
    this.categoryService.categoryTypeSelectedId = this.categoryTypeSelectedId;
    this.sendCategoryTypeId.emit(categoryTypeId)
  }

  showLockOrUnLockCategoryTypeModal(categoryType) {
    const message = `Bạn có chắc chắn muốn ${categoryType.active ? 'khóa' : 'mở khóa'}?`;
    this.commonUtils.showPopupConfirm(message, () => {
      this.activeOrDeactiveCategoryType(categoryType);
    });
  }

  activeOrDeactiveCategoryType(categoryType) {
    if (categoryType.active) {
      this.deactiveCategoryType(categoryType.id);
    } else {
      this.activeCategoryType(categoryType.id);
    }
  }

  activeCategoryType(categoryTypeId) {
    this.categoryService.activeCategoryType(categoryTypeId).subscribe(
      res => {
        this.toastr.success('Mở khóa loại danh mục thành công!', 'Thành công');
        this.getAllCatalogyTypeWithPaging(this.urlQuery.page);
      },
      err => {
        // this.toastr.error(err, 'Lỗi');
        console.log(err);
      }
    );
  }

  deactiveCategoryType(categoryTypeId) {
    this.categoryService.deactiveCategoryType(categoryTypeId).subscribe(
      res => {
        this.toastr.success('Khóa loại danh mục thành công!', 'Thành công');
        this.getAllCatalogyTypeWithPaging(this.urlQuery.page);
      },
      err => {
        // this.toastr.error(err, 'Lỗi');
        console.log(err);
      }
    );
  }

  doDeleteCategoryType(categoryTypeId) {
    this.categoryService.doDeleteCategoryType(categoryTypeId).subscribe(
      res => {
        this.toastr.success('Xóa loại danh mục thành công!', 'Thành công');
        this.getAllCatalogyTypeWithPaging(this.urlQuery.page);
      },
      err => {
        // this.toastr.error(err, 'Lỗi');
      }
    );
  }

  showDeleteCategoryTypeModal(categoryTypeId) {
    const message = "Bạn có chắc muốn xóa?";
    this.commonUtils.showPopupConfirm(message, () => {
      this.doDeleteCategoryType(categoryTypeId);
    });
  }

  showCategoryTypeModal(content, categoryTypeIndex) {
    this.initDataModal(categoryTypeIndex);
    this.currentModal = this.modalService.open(content, {centered: true, size: 'lg', windowClass: 'modal-xl'})
    //   .result.then(
    //   result => {
    //     if (result) {
    //       if (this.categoryType.id > 0) {
    //         this.doSaveCategoryType()
    //       } else {
    //         this.doSaveNewCategoryType();
    //       }
    //     }
    //   }
    // );
  }

  saveCategoryType(categoryTypeForm: NgForm) {
    if (this.categoryType.id > 0) {
      this.doSaveCategoryType();
    } else {
      this.doSaveNewCategoryType();
    }
  }

  closeModal() {
    let modelContent = document.getElementsByClassName("modal-content")[0] as HTMLElement
    if (modelContent) {
      modelContent.style.display = "none"
    }

    let modalBackdrop = document.getElementsByTagName("ngb-modal-backdrop")[0] as HTMLElement
    if (modalBackdrop) {
      modalBackdrop.style.display = "none"
    }
  }

  initDataModal(categoryTypeIndex) {
    if (categoryTypeIndex == null) {
      this.categoryType = {
        id: 0,
        active: true,
        name: "",
        code: '',
        superAdmin: false,
      }
      this.titleModal = "Thêm mới loại danh mục";
    } else {
      this.titleModal = "Cập nhật loại danh mục";
      this.categoryType = Object.assign({}, this.categoriesType[categoryTypeIndex]);
    }
  }

  doSaveCategoryType() {
    console.log("do save")
    if (this.validateForm(this.categoryType)) {
      this.categoryService.doSaveCategoryType(this.categoryType, this.categoryType.id).subscribe(
        res => {
          this.toastr.success('Cập nhật loại danh mục thành công!', 'Thành công');
          this.currentModal.close();
          this.getAllCatalogyTypeWithPaging(this.urlQuery.page);
        },
        err => {
          // this.toastr.error(err, 'Lỗi');
          console.log(err);
        }
      );
      ;
    }
  }

  doSaveNewCategoryType() {
    console.log("do save")
    if (this.validateForm(this.categoryType)) {
      this.categoryService.doSaveNewCategoryType(this.categoryType).subscribe(
        res => {
          this.currentModal.close();
          this.toastr.success('Thêm mới loại danh mục thành công!', 'Thành công');
          this.getAllCatalogyTypeWithPaging(this.urlQuery.page);
        },
        err => {
          // this.toastr.error(err, 'lỗi');
          console.log(err);
        }
      );
    }
  }

  clicked(categoryTypeForm: NgForm) {
    console.log(categoryTypeForm)
    console.log("clicked")
  }

  validateForm(formData: CategoryType) {
    this.isValid = true;
    return this.isValid;
  }
}
