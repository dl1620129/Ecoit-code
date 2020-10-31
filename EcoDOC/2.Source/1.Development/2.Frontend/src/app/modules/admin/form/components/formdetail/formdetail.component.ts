import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FieldService } from '../../../../../services/field.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FieldType } from '../../../../../core/model/domain/FieldType';
import { ToastrService } from 'ngx-toastr';
import { Field } from '../../../../../core/model/domain/form';
import { TokenService } from '../../../../../core/authen/token.service';
import { remove } from '@syncfusion/ej2-base';
import { Subject } from 'rxjs';

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

  constructor(
    private route: ActivatedRoute,
    private fieldService: FieldService,
    private modalService: NgbModal,
    private toastr: ToastrService,
    private tokenService: TokenService
  ) {
  }
  ticKet: any
  typeCustom=[
    {
      "name":"cm:content"
    },
    {
      "name":"cm:dictionaryModel"
    },
    {
      "name":"cm:folder"
    },
    {
      "name":"cm:savedquery"
    },
    {
      "name":"cm:thumbnail"
    },
    {
      "name":"cmiscustom:document"
    }
    
  ]
  ngOnInit() {
    this.ticKet = this.tokenService.getTickets();
    this.getIdField();
    this.getAllCustomType();
    this.getAllAspects();
  }
  getAllCustomType() {
    this.fieldService.getAllCustomType(this.ticKet, this.name).subscribe((res: any) => {
      console.log(res);
      this.customType = res.data.list.entries;
    })
  }
  getAllAspects() {
    this.fieldService.getAllAspects(this.ticKet, this.name).subscribe((res: any) => {
      console.log(res);
      this.aspects = res.data.list.entries;
    })
  }
  getIdField() {
    // this.fieldService.getIdField(this.id).subscribe(data => {
    //   this.name = data.name;
    //   this.listFieldType = data.listFieldType;
    //   console.log(data);
    // });
  }

  showModal(content, isAddFieldType, size) {
    this.isAddFieldType = isAddFieldType;
    this.modalService.open(content, { centered: true, size: size })
      .result.then(
        result => {
          console.log(result, ' close popup');
        }
      ).catch(error => {
        console.log(error, ' error popup');
      });
  }

  createFieldType() {
    // this.fieldType.active = true;
    // this.fieldService.createFieldType(this.fieldType).subscribe(data => {
    //   if (this.fieldType.id === null) {
    //     this.toastr.success('Thêm thành công', 'Thành công');
    //   } else {
    //     this.toastr.success('Sửa thành công', 'Thành công');
    //   }
    //   this.getIdField();
    //   this.modalService.dismissAll();
    // });
    this.fieldService.createFielTypeDb(this.fieldType).subscribe((data: any) => {
      if (data.resultCode == 200) {
        this.fieldService.createCustypeAlfresco(this.fieldType, this.ticKet, this.name).subscribe((res: any) => {
          if (res.resultCode == 200) {
            this.toastr.success('Thêm thành công', 'Thành công');
            this.getAllCustomType();
            this.modalService.dismissAll();
          } else {
            this.toastr.error('Thêm không thành công', 'Thất bại');
          }
        })
      }
      else {
        this.toastr.error('Thêm không thành công', 'Thất bại');
      }
    })



  }
  removeCustomType(name: any) {
    this.fieldService.deleteCustomType(this.ticKet, name, this.name).subscribe(res => {
      this.fieldService.deleteFieldTypeDb(name).subscribe();
      this.toastr.success('Xóa thành công', 'Thành công');
      this.getAllCustomType();
    })
  }
  removeAspects(name: any) {
    this.fieldService.deleteAspects(this.ticKet, name, this.name).subscribe(res => {
      this.toastr.success('Xóa thành công', 'Thành công');
      this.getAllAspects();
    })
  }
  updateActiveFieldType(id: number) {
    this.fieldService.updateActiveFieldType(id).subscribe(data => {
      this.getIdField();
      this.toastr.success('Cập nhật thành công', 'Thành công');
    });
  }

  checkCreate() {
    this.checkCreateUpdate = true;
    this.fieldType = new FieldType();
  }

  getIdFieldType(id: number) {
    this.fieldService.getIdFieldType(id).subscribe(data => {
      this.fieldType = data;
    });
  }

}
