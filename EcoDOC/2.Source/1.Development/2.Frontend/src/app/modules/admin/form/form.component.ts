import {Component, OnInit} from '@angular/core';
import {FieldService} from '../../../services/field.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Field} from '../../../core/model/domain/form';
import {ToastrService} from 'ngx-toastr';
import { Router} from '@angular/router';
import {TokenService} from 'src/app/core/authen/token.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  fieldId: number;
  name: string;
  listField: any;
  checkCreateUpdate: boolean = true;
  listFieldType: any;
  fields: Field = new Field();
  isAddUserApprove: boolean = true;
  ticKet = '';
  nameUpdate: string;

  constructor(private fieldService: FieldService,
              private modalService: NgbModal,
              private router: Router,
              private toastr: ToastrService,
              private tokenService: TokenService) {
  }

  ngOnInit() {
    this.ticKet = this.tokenService.getTickets();
    this.getAllField();
  }

  getAllField() {
    this.fieldService.getAllModelAlfresco(this.ticKet).subscribe(data => {
      this.listField = data.data.list.entries;
    });
  }

  removeModel(name: string, status: string) {
    if (status == 'ACTIVE') {
      this.toastr.warning('Không thể xóa form đang active', 'Thất bại');
    } else {
      this.fieldService.deleteModelAlfresco(name, this.ticKet).subscribe(res => {
        this.fieldService.deleteFieldDb(name).subscribe();
        this.toastr.success('Xóa thành công', 'Thành công');
        this.getAllField();
      });
    }

  }

  getDetail(name: string) {
    this.fieldService.getModelDetail(name, this.ticKet).subscribe((res: any) => {
      this.nameUpdate = res.data.entry.name;
      this.fields.name = res.data.entry.name;
      this.fields.description = res.data.entry.description;
      this.fields.namespaceUri = res.data.entry.namespaceUri;
      this.fields.namespacePrefix = res.data.entry.namespacePrefix;
    });
  }

  showModal(content, isAddUserApprove, size, create: string) {
    this.isAddUserApprove = isAddUserApprove;
    if (create === 'update') {
      this.checkCreateUpdate = false;
      this.disableName = true;
    } else {
      this.disableName = false;
      this.checkCreateUpdate = true;
      this.fields = new Field();
    }
    this.modalService.open(content, {centered: true, size: size})
      .result.then(
      result => {
        console.log(result, ' close popup');
      }
    ).catch(error => {
      console.log(error, ' error popup');
    });
  }

  disableName = false;

  updateModel() {
    if (name !== undefined) {
      if (this.fields.namespaceUri == null) {
        this.toastr.error('Name space không được trống', 'Thất bại');
      } else if (this.fields.name == null) {
        this.toastr.error('Tên không được trống', 'Thất bại');
      } else if (this.fields.namespacePrefix == null) {
        this.toastr.error('Prefix không được trống', 'Thất bại');
      } else if (this.fields.namespaceUri != null && this.fields.name != null && this.fields.namespacePrefix != null) {
        this.fieldService.updateModelAlfresco(this.fields, this.ticKet).subscribe((res: any) => {
          if (res.resultCode == 200) {
            this.fieldService.updateFielDb(this.fields).subscribe((data: any) => {
              if (data.resultCode == 200) {
                this.toastr.success('Sửa thành công', 'Thành công');
                this.getAllField();
                this.modalService.dismissAll();
              } else {
                this.toastr.error('Sửa không thành công', 'Thất bại');
              }
            });
          } else if (res.message == 'NamespaceUri đã tồn tại') {
            this.toastr.error('NamespaceUri đã tồn tại', 'Thất bại');
          } else if (res.message == 'NamespacePrefix đã tồn tại') {
            this.toastr.error('NamespacePrefix đã tồn tại', 'Thất bại');
          } else {
            this.toastr.error('Sửa không thành công', 'Thất bại');
          }
        });
      }
    }
  }

  createUpdateModel() {
    if(this.checkCreateUpdate) {
      this.createField()
    } else {
      this.updateModel()
    }
  }

  createField() {
    if (this.fields.namespaceUri == null) {
      this.toastr.error('Name space không được trống', 'Thất bại');
    }else if (this.fields.name == null) {
      this.toastr.error('Tên không được trống', 'Thất bại');
    }else if (this.fields.namespacePrefix == null) {
      this.toastr.error('Prefix không được trống', 'Thất bại');
    } else if (this.fields.namespaceUri != null && this.fields.name != null && this.fields.namespacePrefix != null ) {
      this.fieldService.createModelAlfresco(this.fields, this.ticKet).subscribe((res: any) => {
        if (res.resultCode == 200) {
          this.fieldService.createFielDb(this.fields).subscribe((data: any) => {
            if (data.resultCode == 200) {
              this.toastr.success('Thêm mới thành công', 'Thành công');
              this.getAllField();
              this.modalService.dismissAll();
            } else {
              this.toastr.error('Thêm mới không thành công', 'Thất bại');
            }
          });
        } else if (res.message == 'Name đã tồn tại') {
          this.toastr.error('Name đã tồn tại', 'Thất bại');
        } else if (res.message == 'NamespaceUri đã tồn tại') {
          this.toastr.error('NamespaceUri đã tồn tại', 'Thất bại');
        } else if (res.message == 'NamespacePrefix đã tồn tại') {
          this.toastr.error('NamespacePrefix đã tồn tại', 'Thất bại');
        } else {
          this.toastr.error('Thêm mới không thành công', 'Thất bại');
        }
      });
    }
  }

  activeModel(name: string, status: string) {
    let type = 1;
    if (status == 'ACTIVE') {
      type = 1;
    } else {
      type = 2;
    }
    this.fieldService.activeModelAlfresco(this.ticKet, name, type).subscribe((res: any) => {
      if (res.resultCode == 200) {
        this.fieldService.activeModelDb(name).subscribe((result: any) => {
          if (result.resultCode == 200) {
            this.toastr.success('Cập nhật thành công', 'Thành công');
            this.getAllField();
          } else {
            this.toastr.error('Cập nhật không thành công', 'Thất bại');
          }
        });

      } else {
        this.toastr.error('Cập nhật không thành công', 'Thất bại');
      }
    });
  }

}
