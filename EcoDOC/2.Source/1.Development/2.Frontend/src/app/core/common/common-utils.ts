import {NgbDateStruct, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ConfirmPopupComponent} from "src/app/shared/popup/confirm-popup/confirm-popup.component";
import {Injectable} from "@angular/core";
import {isNumber, padNumber} from "../../pipes/custom-date-format";
import {CategoryService} from "../../services/category.service";
import {Observable, of} from "rxjs";
import {SharedPreferences} from "../config/shared-preferences";
import {OrganizationService} from "../../services/organization.service";
import * as dayjs from 'dayjs';
import * as relativeTime from 'dayjs/plugin/relativeTime';
import 'dayjs/locale/vi';

dayjs.extend(relativeTime);
dayjs.locale('vi');

@Injectable({
  providedIn: 'root'
})
export class CommonUtils {

  static timeFrom(pastDate: Date) {
    return dayjs(pastDate).fromNow();
  }
  public isShowOKPopup = false;
  constructor(private modalService: NgbModal,
              private sharedPreferences: SharedPreferences,
              private organizationService: OrganizationService,
              private categoryService: CategoryService) {
  }

  showPopupConfirm(message, callback) {
    const modalRef = this.modalService.open(ConfirmPopupComponent, {centered: true, size: 'sm'});
    modalRef.componentInstance.message = message;
    modalRef.result.then(
      result => {
        if (result == true) {
          callback();
        }
      }
    );
  }

  showPopupOK(message) {
    if (!this.isShowOKPopup) {
      const modalRef = this.modalService.open(ConfirmPopupComponent, {centered: true, size: 'sm', backdrop: 'static', keyboard: false});
      modalRef.componentInstance.message = message;
      modalRef.componentInstance.oKOnly = true;
      modalRef.componentInstance.funcCloseCallback = () => {
        this.isShowOKPopup = false;
      }
      this.isShowOKPopup = true;
    }
  }

  format(date: NgbDateStruct): string {
    console.log("format:", date)
    return date
      ? `${isNumber(date.day) ? padNumber(date.day) : ""}/${isNumber(date.month) ? padNumber(date.month) : ""}/${
        date.year
      }`
      : "";
  }

  getCategoryByCode(code: string): Observable<any> {
    let data = this.sharedPreferences.getDataLocal(code)
    if (data != undefined)
      return of(data);
    else {
      this.categoryService.getCategoryWithCode(code).subscribe(data => {
        console.log("Call service get Category");
        this.sharedPreferences.setDataLocal(code, data);
        return of(data);
      })
    }
  }

  getOrganizationAll(): Observable<any> {
    let data = this.sharedPreferences.getDataLocal("ORG_DATA")
    if (data != undefined)
      return of(data);
    else {
      this.organizationService.getOrganizations().subscribe(data => {
        console.log("Call service get Organizations");
        this.sharedPreferences.setDataLocal("ORG_DATA", data);
        return of(data);
      })
    }
  }

  subString(input: string, length: number) {
    if (input.length < length)
      return input;
    else {
      input = input.substr(0, length) + "...";
    }
    return input;
  }

  getCategoryName(categoryId: number) {
  }
}
