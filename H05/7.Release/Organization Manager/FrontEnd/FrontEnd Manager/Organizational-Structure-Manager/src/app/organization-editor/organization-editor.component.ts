import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
import { OrganizationModel } from '../model/organization.model';
import { OrganizationService } from '../service/Organization.service';
declare const Liferay: any;
@Component({
    selector: 'app-editor',
    templateUrl:
        Liferay.ThemeDisplay.getPathContext() +
        '/o/Organizational-Structure-Manager/app/organization-editor.component.html'
})
export class OrganizationEditorComponent implements OnInit {
    imgSrc: any;

    constructor(public service: OrganizationService, public router: ActivatedRoute, public rt: Router, public notifierService: NotifierService) { }
    imageModel: OrganizationModel;
    organId: any;
    organizationModel: OrganizationModel = new OrganizationModel(0, 0, '', '', '', '', 0, [],0);

    ngOnInit() {
        this.getOrganData();
        this.router.paramMap.subscribe((params: ParamMap) => {
            this.organId = params.get('id');
        })
        if (this.organId != null) {
            this.service.getOrganizationById(this.organId).subscribe((result: any) => {
                this.organizationModel = result.data;
                // this.updateForm.patchValue({
                //     'name':result.data.name,
                //     'address':result.data.address,
                //     'description':result.data.description,
                //     'phoneNumber':result.data.phoneNumber,
                //     'parentId':result.data.parentId,
                //     'organizationCode':result.data.organizationCode,
                // })
            })
        }
    }
    // updateForm= new FormGroup({
    //     'name': new FormControl('',Validators.required),
    //     'organizationCode': new FormControl('',Validators.required),
    //     'description': new FormControl(''),
    //     'parentId': new FormControl(''),
    //     'address': new FormControl(''),
    //     'phoneNumber': new FormControl('')

    // })
    // get name():any{
    //     return this.updateForm.get('name');
    // }
    // get organizationCode():any{
    //     return this.updateForm.get('organizationCode');
    // }
    listOrgan: any = [];
    listOrgan2: any = [];
    getOrganData() {
        this.service.getAllOrgan().subscribe((res: any) => {
            this.listOrgan2 = res.data.data;
            // this.listOrgan2=res.data.Organizations
            console.log(this.listOrgan2);
            if (this.listOrgan2.length != 0) {
                this.service.convertTreeList(this.listOrgan2, 1, this.listOrgan);
            }

            console.log('abc' + JSON.stringify(this.listOrgan));
        })
    }

    orgId: number;
    onSubmit() {

        this.router.paramMap.subscribe((params: ParamMap) => {
            this.organId = params.get('id');
        });
        if (this.organId != null) {
            this.service.updateCore(this.organizationModel, this.organId).subscribe((res1: any) => {
                if (res1.error_code == Constants.SUCCESSFUL_CODE) {
                    this.service.updateOrganization(this.organizationModel, this.organId).subscribe((res: any) => {
                        if (res.error_code == Constants.SUCCESSFUL_CODE) {
                            this.rt.navigate(['/list']);
                            this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
                        } else if (res.error_code == Constants.NOT_ACCESS_CODE) {
                            this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                        } else {
                            this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                        }
                    })

                } else if (res1.error_code == Constants.IN_PARENT) {
                    this.notifierService.notify('error', Constants.NOT_IN_PARENT);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }
            })


        }
        else {
            this.service.addOrgCore(this.organizationModel).subscribe((res: any) => {
                if (res.error_code == Constants.SUCCESSFUL_CODE) {
                    this.orgId = res.data.orgId;
                    console.log('-------' + this.orgId);
                    if (this.orgId > 0) {
                        this.service.createOrganization(this.organizationModel, this.orgId).subscribe((response: any) => {
                            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                                this.rt.navigate(['/list']);
                                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
                            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                            } else {
                                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                            }
                        })
                    }
                    else {
                        this.rt.navigate(['/list']);
                    }

                } else if (res.error_code == Constants.IN_PARENT) {
                    this.notifierService.notify('error', Constants.NOT_IN_PARENT);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }


            })


        }



    }

}