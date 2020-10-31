import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TokenService } from '../../../../core/authen/token.service';
import { FieldService } from '../../../../services/field.service';
import { FieldProperties } from '../../../../core/model/domain/FieldProperties';
import { ToastrService } from 'ngx-toastr';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-formproperties',
  templateUrl: './formproperties.component.html',
  styleUrls: ['./formproperties.component.css']
})
export class FormpropertiesComponent implements OnInit {
  properties = this.route.snapshot.paramMap.get('properties');
  name = this.route.snapshot.paramMap.get('name');
  constructor(private route: ActivatedRoute, private modalService: NgbModal, private toastr: ToastrService, private tokenService: TokenService, private service: FieldService) { }
  ticKet = '';
  listProperties: any[] = new Array();
  propertiesModel: FieldProperties = new FieldProperties();
  disableName = false;
  ngOnInit() {
    this.ticKet = this.tokenService.getTickets();
    console.log(this.properties);
    console.log(this.name);
    this.getAllProperties();

  }
  getAllProperties() {
    this.service.getDetailCustomType(this.ticKet, this.properties, this.name).subscribe((result: any) => {
      console.log(result);
      this.listProperties = result.data.entry.properties;
    })
  }
  addProperties() {
    if (this.disableName == false) {
      this.service.createProperties(this.propertiesModel, this.ticKet, this.properties, this.name).subscribe((res: any) => {
        if (res.resultCode == 200) {
          this.toastr.success('Thêm mới thành công', 'Thành công');
          this.modalService.dismissAll();
          this.getAllProperties();
        } else {
          this.toastr.error('Thêm mới thất bại', 'Thất bại');
        }
      })
    } else {
      this.service.updateProperties(this.propertiesModel, this.ticKet, this.properties, this.name).subscribe((res: any) => {
        if (res.resultCode == 200) {
          this.toastr.success('Cập nhật thành công', 'Thành công');
          this.modalService.dismissAll();
          this.getAllProperties();
        } else {
          this.toastr.error('cập nhật thất bại', 'Thất bại');
        }
      })
    }

  }
  removeProperties(name:string){
    this.service.deleteProperties(this.ticKet,this.properties,this.name,name).subscribe(res=>{
      this.toastr.success('Xóa thành công', 'Thành công');
      this.getAllProperties();
    });
  }
  showModal(content, size, i) {
    if (i != -1) {
      this.disableName = true;
      for (let index = 0; index < this.listProperties.length; index++) {
        if (i == index) {
          this.propertiesModel = this.listProperties[i];
          console.log(this.propertiesModel);
        }
      }
    } else {
      this.disableName = false;
      this.propertiesModel = new FieldProperties();
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


}
