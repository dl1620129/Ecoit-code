import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject, LOCALE_ID } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { Constants } from '../common/constants';
import { formatDate } from '@angular/common';
import { OrganizationModel } from '../model/organization.model';

declare const Liferay: any;

@Injectable({
  providedIn: 'root'
})export class ReportService {
    constructor(private http: HttpClient,
        @Inject(LOCALE_ID) private locale: string) {}

    public getFilteredReport(searchForm: any, start: number, pageSize: number) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let modifiedDate = '';
        if (searchForm.get('modifiedDate').value != null && searchForm.get('modifiedDate').value != '') {
            let formattedDateFrom = formatDate(searchForm.get('modifiedDate').value, 'dd/MM/yyyy', this.locale);
            modifiedDate = formattedDateFrom;
        }
        let body = {
            'modifiedDate': modifiedDate,
            'unitId': searchForm.get('unitId').value,
        }

        let getUrl = Constants.baseUrl + '/o/memberreport/app/report/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.companyId + '?start=' + start + '&limit=' + pageSize;
        return this.http.post(getUrl, body, {headers: headers}).pipe(catchError(CommonService.handleError));
    }
    public getOrganization() {
        let url= Constants.baseUrl + '/o/ldap/app/get-userId-inOrg/' + Constants.userId;
        return this.http.get(url).pipe(catchError(CommonService.handleError));
    }
    getPermission(){
        let getUrl = Constants.baseUrl + '/o/memberreport/app/report/get/permission/' + Constants.userId; 
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }
    public getReportDetail(id: any){
        let getUrl = Constants.baseUrl + '/o/memberreport/app/report/get/item/' + id;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    //delete report
    public deleteReport(id: number) {
        let url = Constants.baseUrl + '/o/memberreport/app/report/delete/' + Constants.userId + '/' + id;
        return this.http.delete(url).pipe(catchError(CommonService.handleError));
    }

    public submitReportForm(form: any, id: number) {

        let body = {
            'memberReportId': id,
            'tong': form.get('tong').value,
            'congTac': form.get('congTac').value,
            'hocTap': form.get('hocTap').value,
            'nghiPhep': form.get('nghiPhep').value,
            'nghiOm': form.get('nghiOm').value,
            'nghiBu': form.get('nghiBu').value,
            'liDoKhac': form.get('liDoKhac').value,
            'note': form.get('note').value,
            'unitId': form.get('unitId').value
        };
        if (id && id > 0) {
            let updateUrl = Constants.baseUrl + '/o/memberreport/app/report/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' +   Constants.userId + '/' + Constants.companyId;
            return this.http.put(updateUrl, body).pipe(catchError(CommonService.handleError));
        }

        let createUrl = Constants.baseUrl + '/o/memberreport/app/report/create/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + Constants.companyId;
        return this.http.post(createUrl, body).pipe(catchError(CommonService.handleError));
    }

    /*public convertDataToLichCongTac(lichCongTacData: any) {
        let lichCongTac = new LichCongTac();
        if (lichCongTacData.startDate) {
            lichCongTac.startDate = new Date(lichCongTacData.startDate);
        }

        if (lichCongTacData.endDate) {
            lichCongTac.endDate = new Date(lichCongTacData.endDate);
        }

        lichCongTac.name = lichCongTacData.name;
        lichCongTac.lichCongTacId = lichCongTacData.lichCongTacId;
        lichCongTac.organizations = lichCongTacData.organizations;
        lichCongTac.users = lichCongTacData.users;
        let lichChiTietList = new Array();
        if (lichCongTacData.lichChiTietList) {
            lichCongTacData.lichChiTietList.forEach((element: any) => {
                let lichChiTiet = new LichChiTiet();
                lichChiTiet.selectedDate = new Date(element.selectedDate);
                lichChiTiet.startTime = new Date(element.startTime);
                lichChiTiet.description = element.description;
                lichChiTiet.nguoiThamDu = element.nguoiThamDu;
                lichChiTiet.nguoiMoi = element.nguoiMoi;
                lichChiTietList.push(lichChiTiet);
            });
        }
        lichCongTac.lichChiTietList = lichChiTietList;
        return lichCongTac;
    }*/
    convertTreeList(treeList: OrganizationModel[], level: number, listOfOrganizations: OrganizationModel[]) {
        treeList.forEach((element: OrganizationModel) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element['name'];
            let newElement = new OrganizationModel(element.organizationId, element.organizationCode, newTitle, element.description, element.leader,element.parentId,element.child);
            listOfOrganizations.push(newElement);
       
            this.convertTreeList(element['child'], level+1, listOfOrganizations);
        });
      
    }
    public getAllUnits() {
        let getUrl = Constants.baseUrl + '/o/memberreport/app/unit/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.companyId + '?limit=0&start=0';
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }
    public getAllOrgan(){
        let url= Constants.baseUrl+'/o/organizational/app/getall/'+Constants.scopeGroupId+'/0';
        return this.http.get(url).pipe(catchError(CommonService.handleError));
    }
}