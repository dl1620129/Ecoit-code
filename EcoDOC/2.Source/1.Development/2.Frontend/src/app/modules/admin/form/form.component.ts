import { Component, OnInit } from '@angular/core';
import { FieldService } from '../../../services/field.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Field } from '../../../core/model/domain/form';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { TokenService } from 'src/app/core/authen/token.service';

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
  removeModel(name: string) {
    this.fieldService.deleteModelAlfresco(name, this.ticKet).subscribe(res => {
        this.fieldService.deleteFieldDb(name).subscribe();
        this.toastr.success('Xóa thành công', 'Thành công');
        this.getAllField();
    
    });
  }
  getDetail(name: string) {
    this.fieldService.getModelDetail(name, this.ticKet).subscribe((res: any) => {
      console.log(res);
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
    }
    this.modalService.open(content, { centered: true, size: size })
      .result.then(
        result => {
          console.log(result, ' close popup');
        }
      ).catch(error => {
        console.log(error, ' error popup');
      });
  }
  disableName = false;
  createField(name: any) {
    console.log(name);
    if (name !== undefined) {
      console.log('update');

      this.fieldService.updateFielDb(this.fields).subscribe((res: any) => {
        if (res.resultCode == 200) {
          this.fieldService.updateModelAlfresco(this.fields, this.ticKet).subscribe((data: any) => {
            if (data.resultCode == 200) {
              this.toastr.success('Sửa thành công', 'Thành công');
              this.getAllField();
              this.modalService.dismissAll();
            }
            else {
              this.toastr.error('Sửa không thành công', 'Thất bại');
            }
          })
        } else if (res.message == 'NamespaceUri đã tồn tại') {
          this.toastr.error('NamespaceUri đã tồn tại', 'Thất bại');
        } else if (res.message == 'NamespacePrefix đã tồn tại') {
          this.toastr.error('NamespacePrefix đã tồn tại', 'Thất bại');
        } else {
          this.toastr.error('Sửa không thành công', 'Thất bại');
        }
        name='';
      })
    }
    else {
      console.log('create');

      this.fieldService.createFielDb(this.fields).subscribe((res: any) => {
        if (res.resultCode == 200) {
          this.fieldService.createModelAlfresco(this.fields, this.ticKet).subscribe((data: any) => {
            if (data.resultCode == 200) {
              this.toastr.success('Thêm mới thành công', 'Thành công');
              this.getAllField();
              this.modalService.dismissAll();
            }
            else {
              this.toastr.error('Thêm mới không thành công', 'Thất bại');
            }
          })
        } else if (res.message == 'Name đã tồn tại') {
          this.toastr.error('Name đã tồn tại', 'Thất bại');
        } else if (res.message == 'NamespaceUri đã tồn tại') {
          this.toastr.error('NamespaceUri đã tồn tại', 'Thất bại');
        } else if (res.message == 'NamespacePrefix đã tồn tại') {
          this.toastr.error('NamespacePrefix đã tồn tại', 'Thất bại');
        } else {
          this.toastr.error('Thêm mới không thành công', 'Thất bại');
        }
      })

    }

    // this.fieldService.createField(this.fields).subscribe(data => {
    //   if (this.fields.id == null) {
    //     this.toastr.success('Thêm mới thành công', 'Thành công');
    //   } else {
    //     this.toastr.success('Sửa thành công', 'Thành công');
    //   }
    //   this.getAllField();
    //   this.modalService.dismissAll();
    // });
  }

  updateActiveField(id: number) {
    this.fieldService.updateActiveField(id).subscribe(data => {
      this.toastr.success('Cập nhật thành công', 'Thành công');
      this.getAllField();
    });
  }

  getIdField(id: number) {
    this.fieldService.getIdField(String(id)).subscribe(data => {
      this.fields = data;
    });
  }

  checkCreate() {
    this.checkCreateUpdate = true;
    this.fields = new Field();
  }

}
