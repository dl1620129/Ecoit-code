import { Component, OnInit, Inject } from '@angular/core';
import { User } from 'src/app/core/model/domain/user';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { UserService } from 'src/app/services/user.service';
import { ToastrService } from 'ngx-toastr';
import { ClientService } from 'src/app/services/client.service';
import { CategoryService } from 'src/app/services/category.service';
import { OrganizationService } from 'src/app/services/organization.service';
import { Constant } from 'src/app/core/config/constant';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css',
              '../../../../../../../node_modules/@syncfusion/ej2-inputs/styles/material.css',
              '../../../../../../../node_modules/@syncfusion/ej2-base/styles/material.css',
              '../../../../../../../node_modules/@syncfusion/ej2-angular-dropdowns/styles/material.css'
            ]
})
export class UserComponent implements OnInit {
  // defined the array of data
  orgObject;
    // binding data source through fields property
  userBirthday;
  orgId;
  orgList;
  posList;

  clients;
  client;

  formData;
  isValid: boolean;
  title: string;

  sexSelected;

  currentModal: NgbModalRef

  sexobjs = [
    {value: true, description: 'Nam'},
    {value: false, description: 'Nữ'},
  ];

  constructor(
    @Inject(MAT_DIALOG_DATA) public data,
    private dialogRef: MatDialogRef<UserComponent>,
    private userService: UserService,
    private toastr: ToastrService,
    private clientService: ClientService,
    private categoryService: CategoryService,
    private organizationService: OrganizationService
  ) { }

  onSubmit(form) {
    // tslint:disable-next-line: radix
    this.formData.org = parseInt(this.orgId[0]);
    this.formData.birthday = this.userBirthday;
    console.log('Add user : ', JSON.stringify(this.formData));
    if (this.validateForm(form.value)) {
      if (this.formData.id > 0) {
        console.log('Call update user');
        this.userService.updateUser(this.formData)
          .subscribe( data => {
            this.toastr.success('Cập nhật thông tin người dùng', 'Thành công!');
          },
          error => {
            this.toastr.error('Cập nhật thông tin người dùng!', 'Lỗi!');
          });
      } else {
        this.userService.addUser(this.formData)
          .subscribe( data => {
            this.toastr.success('Thêm mới người dùng', 'Thành công!');
          },
          error => {
            this.toastr.error('Thêm mới người dùng', 'Lỗi!');
          });
      }
      this.dialogRef.close();
    }
  }
  updateUser(id): void {
    this.userService.updateUser(id)
      .subscribe( data => {
        this.toastr.success('Function OK!', 'Success!');
      },
      error => {
        this.toastr.error('Function FAILED!', 'Oops!');
      });
  }
  validateForm(formData: User) {
    this.isValid = true;
    return this.isValid;
  }
  ngOnInit() {
    // this.userService.getUserList();
    this.getPositionList();
    this.getOrganizationList();
    console.log('this.data.id = ', this.data.id);
    if (this.data.id === 0) {
      this.title = 'Thêm mới người dùng';
      this.formData = {
        id: 0,
        photo: '',
        clientId: null,
        userName: '',
        fullName: '',
        birthday: null,
        sex: true,
        active: null,
        indentity: null,
        phone: null,
        email: '',
        org: null,
        position: null,
      };
    } else {
      this.title = 'Cập nhật thông tin người dùng';
      this.formData = Object.assign({}, this.data);
      this.orgId = [''+ this.formData.org];
      if (this.formData.birthday) {
        let bday = new Date(this.formData.birthday);
        this.userBirthday = bday.getFullYear() + '-' + String(bday.getMonth() + 1).padStart(2, '0') + '-' + String(bday.getDate()).padStart(2, '0');
      }

      console.log('this.formData.birthday.toString() : ', this.userBirthday);
      console.log('this.formData.clientId : ', this.formData.clientId);
    }
  }
  // get all position id
  getPositionList() {
    this.categoryService.getCategoryWithCode(Constant.CATEGORYTYPE_CODE.USER_POSITION).subscribe(
      data => {
        this.posList = data;
        this.formData.position = data[0].id
        console.log('getPositionList : ', this.posList);
      },
      err => {
        console.log(err);
      }
    );
  }
  // get all organization id
  checkParent (id, list) {
    for (let i = 0; i < list.length; i++) {
      if(list[i].parentId == id) {
        return true;
      }
    }
    return false;
  }
  getOrganizationList() {
    this.organizationService.getOrganizations().subscribe(
      data => {
        console.log(data);
        if (data) {
          this.orgList = data;
          for (let i = 0; i < this.orgList.length; i++) {
            if (this.orgList[i].parentId != null) {
              if(this.checkParent(this.orgList[i].id, this.orgList)) {
                this.orgList[i].haschild = true;
                // this.orgList[i].expanded = true;
                // this.orgList[i].nodeIcon = 'fa fa-home';
                this.orgList[i].nodeIcon = 'fas fa-check';
              } else {
                this.orgList[i].haschild = false;
                this.orgList[i].nodeIcon = 'fas fa-check';
              }
            } else {
              this.orgList[i].haschild = true;
              // this.orgList[i].expanded = true;
              this.orgList[i].nodeIcon = 'fa fa-university';
            }
          }
          console.log('this.orgList : ', this.orgList);
          this.orgObject = { dataSource: this.orgList, value: 'id',
            text: 'name', parentValue: 'parentId', hasChildren: 'haschild', iconCss: 'nodeIcon'};
        }
      }
    );
  }
}
