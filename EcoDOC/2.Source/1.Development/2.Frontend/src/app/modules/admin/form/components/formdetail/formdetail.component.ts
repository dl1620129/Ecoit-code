import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {FieldService} from '../../../../../services/field.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FieldType} from '../../../../../core/model/domain/FieldType';
import {ToastrService} from 'ngx-toastr';
import {Field} from '../../../../../core/model/domain/form';
import {TokenService} from '../../../../../core/authen/token.service';
import {remove} from '@syncfusion/ej2-base';
import {Subject} from 'rxjs';
import {aspectField} from '../../../../../core/model/domain/aspectField';

@Component({
  selector: 'app-formdetail',
  templateUrl: './formdetail.component.html',
  styleUrls: ['./formdetail.component.css']
})
export class FormdetailComponent implements OnInit {

  name = this.route.snapshot.paramMap.get('name');
  listFieldType: any;
  isAddFieldType: boolean = true;
  fieldType: FieldType = new FieldType();
  customType: any[] = new Array();
  aspects: any[] = new Array();
  private checkCreateUpdate: boolean = true;
  aspectsField: aspectField = new aspectField();

  constructor(
    private route: ActivatedRoute,
    private fieldService: FieldService,
    private modalService: NgbModal,
    private toastr: ToastrService,
    private tokenService: TokenService
  ) {
  }

  ticKet: any;
  parenName = [
    'gd2:editingInGoogle(google docs)',
    'gd2:shareInGoogle(google docs shares)',
    'resetPassword: resetPasswordInitialProperties',
    'smf:customConfigSmartFolder(Custom smart folder)',
    'smf: smartFolder(Smart folder)',
    'smf: smartFolderChild(smart folder child)',
    'smf: SystemConfigSmartFolder (system smart folder)',
    'smf: virtualizition(container smart folder)'
  ];
  typeCustom = [
    {
      'name': 'cm:content'
    },
    {
      'name': 'cm:dictionaryModel'
    },
    {
      'name': 'cm:folder'
    },
    {
      'name': 'cm:savedquery'
    },
    {
      'name': 'cm:thumbnail'
    },
    {
      'name': 'cmiscustom:document'
    }

  ];

  ngOnInit() {
    this.ticKet = this.tokenService.getTickets();
    this.getAllCustomType();
    this.getAllAspects();
  }

  getAllCustomType() {
    this.fieldService.getAllCustomType(this.ticKet, this.name).subscribe((res: any) => {
      this.customType = res.data.list.entries;
    });
  }

  getAllAspects() {
    this.fieldService.getAllAspects(this.ticKet, this.name).subscribe((res: any) => {
      this.aspects = res.data.list.entries;
    });
  }

  showModal(content, isAddFieldType, size) {
    this.isAddFieldType = isAddFieldType;
    this.modalService.open(content, {centered: true, size: size})
      .result.then(
      result => {
        console.log(result, ' close popup');
      }
    ).catch(error => {
      console.log(error, ' error popup');
    });
  }

  createFieldType() {
    console.log('create')
    this.fieldService.createCustypeAlfresco(this.fieldType, this.ticKet, this.name).subscribe((data: any) => {
      if (data.resultCode == 200) {
        this.fieldService.createFielTypeDb(this.fieldType, this.name).subscribe((res: any) => {
          if (res.resultCode == 200) {
            this.toastr.success('Thêm thành công', 'Thành công');
            this.getAllCustomType();
            this.modalService.dismissAll();
          } else {
            this.toastr.error('Thêm không thành công', 'Thất bại');
          }
        });
      } else {
        this.toastr.error('Thêm không thành công', 'Thất bại');
      }
    });
  }

  createUpdate() {
    if (this.checkCreateUpdate) {
      this.createFieldType();
    }else {
      this.updateFieldType();
    }
  }


  updateFieldType() {
    console.log('update')
    if (this.fieldType.parentName == undefined) this.fieldType.parentName = '';
    this.fieldService.updateCustypeAlfresco(this.fieldType, this.ticKet, this.name).subscribe((data: any) => {
      if (data.resultCode == 200) {
        this.fieldService.updateFielTypeDb(this.fieldType, this.name).subscribe(data => {
          this.toastr.success('Sửa thành công', 'Thành công');
          this.getAllCustomType();
          this.modalService.dismissAll();
        })
      } else {
        this.toastr.error('Sửa không thành công', 'Thất bại');
      }
    });
  }

  removeCustomType(name: any) {
    this.fieldService.deleteCustomType(this.ticKet, name, this.name).subscribe(res => {
      this.fieldService.deleteFieldTypeDb(name , this.name).subscribe();
      this.toastr.success('Xóa thành công', 'Thành công');
      this.getAllCustomType();
    });
  }

  removeAspects(name: any) {
    this.fieldService.deleteAspects(this.ticKet, name, this.name).subscribe(res => {
        this.fieldService.deleteFieldAspectDB(name, this.name).subscribe(res => {
          this.toastr.success('Xóa thành công', 'Thành công');
          this.getAllAspects();
        })
    }, error => {
      this.toastr.error('Model này đang hoạt động, không thể xóa', 'THất bại');
    });
  }

  updateActiveFieldType(id: number) {
    this.fieldService.updateActiveFieldType(id).subscribe(data => {
      this.toastr.success('Cập nhật thành công', 'Thành công');
    });
  }

  checkCreate() {
    this.checkCreateUpdate = true;
    this.fieldType = new FieldType();
    this.aspectsField = new aspectField();
  }

  getIdFieldType(name: string) {
    this.fieldService.getDetailCustomType(this.ticKet, name, this.name).subscribe(data => {
      this.fieldType = data.data.entry;
    });
  }

  createAspects() {
    this.aspectsField.ticKet = this.ticKet;
    this.aspectsField.modelName = this.name;
    this.aspectsField.prefixedName = 'UpdateOhK:' + this.aspectsField.prefixedName;
    this.fieldService.createAspects(this.aspectsField).subscribe(res => {
      if (res.resultCode == 200) {
        this.fieldService.createFieldAspectDB(this.aspectsField, this.name).subscribe(data => {
          this.toastr.success('Thêm mới khía cạnh thành công', 'Thành công');
          this.modalService.dismissAll();
          this.getAllAspects();
        })
        this.aspectsField = new aspectField();
      } else {
        this.toastr.error('Thêm mới khía cạnh thất bại', 'Thất bại');
      }
    });
  }

  getOneAspects(aspectsName: string) {
    this.fieldService.getOneAspect(this.ticKet, this.name, aspectsName).subscribe(res => {
      this.aspectsField = res.data.entry;
    });
  }

  updateAspects() {
    this.aspectsField.ticKet = this.ticKet;
    this.aspectsField.modelName = this.name;
    this.aspectsField.prefixedName = 'UpdateOhK:' + this.aspectsField.prefixedName;
    this.fieldService.updateAspects(this.aspectsField).subscribe(res => {
      if (res.resultCode == 200) {
        this.fieldService.updateFieldAspectDB(this.aspectsField, this.name).subscribe(data => {
          this.toastr.success('Chỉnh sủa khía cạnh thành công', 'Thành công');
          this.modalService.dismissAll();
          this.getAllAspects();
        })
        this.aspectsField = new aspectField();
      } else {
        this.toastr.error('Chỉnh sủa khía cạnh thất bại', 'Thất bại');
      }
    });
  }

  createUpdateAspsect() {
    if (this.checkCreateUpdate) {
      this.createAspects();
    } else {
      this.updateAspects();
    }
  }

}
