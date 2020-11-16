import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {TokenService} from '../../../../core/authen/token.service';
import {FieldService} from '../../../../services/field.service';
import {FieldProperties} from '../../../../core/model/domain/FieldProperties';
import {ToastrService} from 'ngx-toastr';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {error} from '@angular/compiler/src/util';

@Component({
  selector: 'app-formproperties',
  templateUrl: './formproperties.component.html',
  styleUrls: ['./formproperties.component.css']
})
export class FormpropertiesComponent implements OnInit {
  properties = this.route.snapshot.paramMap.get('properties');
  name = this.route.snapshot.paramMap.get('name');
  check = this.route.snapshot.paramMap.get('check');
  types: string = '';

  constructor(private route: ActivatedRoute, private modalService: NgbModal, private toastr: ToastrService, private tokenService: TokenService, private service: FieldService) {
    if (this.check == 'aspects') {
      this.types = 'aspects';
    }else {
      this.types = 'types';
    }
  }

  ticKet = '';
  listProperties: any[] = new Array();
  propertiesModel: FieldProperties = new FieldProperties();
  disableName = false;
  checkCreateUpdate: boolean;

  ngOnInit() {
    this.ticKet = this.tokenService.getTickets();
    this.getDataProperty();

  }

  getPropertiesCustomType() {
    this.service.getDetailCustomType(this.ticKet, this.properties, this.name).subscribe((result: any) => {
      this.listProperties = result.data.entry.properties;
    });
  }

  getDataProperty () {
    if (this.check == 'aspects') {
      this. getPropertyAspects();
    }else {
      this.getPropertiesCustomType()
    }
  }

  getPropertyAspects() {
    this.service.getOneAspect(this.ticKet, this.name, this.properties).subscribe(res => {
      this.listProperties = res.data.entry.properties;
    })
  }


  addProperties() {
    if (this.disableName == false) {
      if (this.propertiesModel.name == null) {
        this.toastr.error('Tên thuộc tính không được để trống!', 'Thất bại');
      } else if (this.propertiesModel.name != null) {
        this.service.createProperties(this.propertiesModel, this.ticKet, this.properties, this.name, this.types).subscribe(res => {
          if (res.resultCode == 200) {
            this.service.createPropertiesDB(this.propertiesModel,this.name ,this.properties, this.types).subscribe(res => {
              this.toastr.success('Thêm mới thành công', 'Thành công');
              this.modalService.dismissAll();
              this.getDataProperty();
            });

          } else {
            this.toastr.error('Thêm mới thất bại', 'Thất bại');
          }
        }, error1 => {
          this.toastr.error('Thêm mới thất bại, tên thuộc tính đã tồn tại', 'Thất bại');
        });
      }
    } else {
      if (this.propertiesModel.name == null) {
        this.toastr.error('Tên thuộc tính không được để trống!', 'Thất bại');
      } else if (this.propertiesModel.name != null) {
        console.log('properties: ')
        console.log(this.properties)
        this.service.updateProperties(this.propertiesModel, this.ticKet, this.properties, this.name, this.types).subscribe(res => {
          if (res.resultCode == 200) {
            this.service.updatePropertiesDB(this.propertiesModel,this.name ,this.properties, this.types).subscribe(res => {
              this.toastr.success('Cập nhật thành công', 'Thành công');
              this.modalService.dismissAll();
              this.getDataProperty();
            });
          } else {
            this.toastr.error('cập nhật thất bại', 'Thất bại');
          }
        });
      }
    }
  }

  removeProperties(name: string) {
    this.service.deleteProperties(this.ticKet, this.properties, this.name, name).subscribe(res => {
      this.toastr.success('Xóa thành công', 'Thành công');
      this.getDataProperty();
    });
  }

  showModal(content, size, i) {
    if (i != -1) {
      this.disableName = true;
      for (let index = 0; index < this.listProperties.length; index++) {
        if (i == index) {
          this.propertiesModel = this.listProperties[i];
        }
      }
    } else {
      this.disableName = false;
      this.propertiesModel = new FieldProperties();
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


}
