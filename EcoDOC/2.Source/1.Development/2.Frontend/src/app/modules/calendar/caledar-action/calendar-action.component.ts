import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {
  NgbModal,
  NgbTimeStruct,
  NgbTimepickerConfig,
} from "@ng-bootstrap/ng-bootstrap";
import {Constant} from "../../../core/config/constant";
import {ApiHelper} from "../../../core/rest/api-helper";
import {CategoryService} from "../../../services/category.service";
import {TranslateService} from "@ngx-translate/core";
import {UserService} from "../../../services/user.service";
import {ToastrService} from "ngx-toastr";
import {CalendarService} from "../../../services/calendar.service";
import {Calendar} from 'src/app/core/model/domain/calendar';
import {CalendarJoin} from 'src/app/core/model/domain/calendar-join';
import {DatePipe} from "@angular/common";
import {RoomService} from "../../../services/room.service";
import {CommonUtils} from 'src/app/core/common/common-utils';

@Component({
  selector: 'app-calendar-action',
  templateUrl: './calendar-action.component.html',
  providers: [NgbTimepickerConfig]
})
export class CalendarActionComponent implements OnInit {
  startTime: NgbTimeStruct;

  constructor(private router: Router,
              private modal: NgbModal,
              private modalService: NgbModal,
              private apiHelper: ApiHelper,
              private userService: UserService,
              private categoryService: CategoryService,
              private toastr: ToastrService,
              private calendarService: CalendarService,
              private translateService: TranslateService,
              private roomService: RoomService,
              private datePipe: DatePipe,
              private  commonUtil: CommonUtils) {
  }

  categoryCalendar = [];

  ngOnInit() {
    this.doInitiateNewCalendar();
    this.getCalendarCategory();
    this.getRoomByOrg();
    this.getTimes();
  }

  calendarJoin: CalendarJoin[] = [];
  calendar: Calendar = new Calendar();
  userJoin: any = [];
  users;
  usersSearch: any[];
  usersId;
  userJoinId: any = [];
  textSearch: string;
  rooms: any = [];
  times: any = [];

  doBackView() {
    this.router.navigate(['/calendar/person']);
  }

  doInitiateNewCalendar() {
    this.calendar.id = undefined;
    this.calendar.title = "";
    this.calendar.type = "0";
    this.calendar.schedureType = "0";
    this.calendar.roomId = "0";
    this.calendar.description = "";
    this.calendar.timeStart = "0";
    this.calendar.timeEnd = "0";
    this.calendar.dateStart = {
      year: new Date().getFullYear(),
      month: new Date().getMonth() + 1,
      day: new Date().getDate()
    };
    this.calendar.dateEnd = {
      year: new Date().getFullYear(),
      month: new Date().getMonth() + 1,
      day: new Date().getDate()
    }
  }

  getRoomByOrg() {
    this.categoryService.getCategoryWithCode(Constant.CATEGORYTYPE_CODE.ROOM_CATEGORY).subscribe(data => {
      if (data) {
        this.rooms = data;
      }
    })
  }

  getTimes() {
    this.categoryService.getTimes().subscribe(data => {
      if (data) {
        this.times = data;
      }
    })
  }

  getCalendarCategory() {
    this.categoryService.getCategoryWithCode(Constant.CATEGORYTYPE_CODE.CALENDAR_CATEGORY).subscribe(data => {
      if (data) {
        this.categoryCalendar = data;
      }
    })
  }

  doSearch() {
    this.usersSearch = [];
    this.userService.searchUserActive(this.textSearch).subscribe(data => {
      if (data)
        this.usersSearch = data;
    })
  }

  doAddUser(index) {
    if (!this.checkExistJoin(this.usersSearch[index].id)) {
      this.userJoin.push(this.usersSearch[index]);
      this.userJoinId.push(this.usersSearch[index].id);
    } else
      this.toastr.error(this.translateService.instant('Người dùng đã được mời tham dự'), this.translateService.instant('label.notification'));
  }

  doRemoveUser(id) {
    if (this.userJoin != undefined) {
      let index = -1;
      this.userJoin.forEach((item, i) => {
        if (item.id == id) {
          index = i;
          return;
        }
      })
      console.log(index);

      if (index > -1) {
        this.userJoin.splice(index, 1);
        this.userJoinId.splice(index, 1);
      }
    }
  }

  checkExistJoin(id) {
    if (this.userJoin)
      if (this.userJoin.find(x => x.id === id)) {
        return true;
      } else return false;
  }

  doSaveUserJoin() {
    if (this.userJoin == undefined || this.userJoin.length == 0)
      this.toastr.error(this.translateService.instant('Không có cá nhân được chọn tham dự lịch'), this.translateService.instant('label.notification'));
    else {
      this.users = JSON.parse(JSON.stringify(this.userJoin));
      this.usersId = JSON.parse(JSON.stringify(this.userJoinId));
      this.usersSearch = [];
      this.userJoin = [];
      this.userJoinId = [];
      this.doParseUserJoinCalendar();
      this.textSearch = "";
      this.modalService.dismissAll();
    }
  }

  doParseUserJoinCalendar() {
    if (this.users != undefined && this.users.length > 0) {
      this.users.forEach(item => {
        this.calendarJoin.push({
          user: item,
          userId: item.id,
          isKnow: true, isOwner: false, isPrepare: false,
          active: true, prepareNote: ""
        })
      })
    }
  }

  doSaveCalendar() {
    if (this.doValidateCalendar()) {
      if (this.calendar.type == "0") {
        this.calendar.type = undefined;
      }
      if (this.calendar.roomId == "0") {
        this.calendar.roomId = undefined;
      }
      this.calendar.startTime = this.getTimeCalendar(this.calendar.dateStart, this.calendar.timeStart);
      this.calendar.endTime = this.getTimeCalendar(this.calendar.dateEnd, this.calendar.timeEnd);
      this.calendarService.addCalendar(this.calendar).subscribe(data => {
        this.calendar = data;
        this.doSaveCalendarJoin(data.id);
      })
    }
  }

  getTimeCalendar(date: any, time: string) {
    console.log(date)
    let dateStr = this.commonUtil.format(date);
    let result = dateStr + " " + this.times[time];
    return result;
  }

  doSaveCalendarJoin(calendarId: string) {
    this.calendarService.addCalendarJoin(this.calendarJoin, calendarId).subscribe(data => {
      this.toastr.success(this.translateService.instant('Tạo lịch thành công'), this.translateService.instant('label.notification'));
      this.router.navigate(['/calendar/person']);
    })
  }

  doValidateCalendar() {
    if (this.calendar.title == undefined || this.calendar.title == "") {
      this.toastr.error(this.translateService.instant('Đề nghị nhập tiêu đề lịch làm việc'), this.translateService.instant('label.notification'));
      return false;
    }
    // if (this.calendar.startTime == undefined || this.calendar.endTime == undefined) {
    //   this.toastr.error(this.translateService.instant('Đề nghị lựa chọn thời gian bắt đầu và kết thúc'), this.translateService.instant('label.notification'));
    //   return false;
    // }
    // if (this.calendar.endTime < this.calendar.startTime) {
    //   this.toastr.error(this.translateService.instant('Thời gian bắt đầu và kết thúc không hợp lệ'), this.translateService.instant('label.notification'));
    //   return false;
    // }
    if (this.calendarJoin == undefined || this.calendarJoin.length == 0) {
      this.toastr.error(this.translateService.instant('Đề nghị nhập thông tin cá nhân tham gia lịch làm việc'), this.translateService.instant('label.notification'));
      return false;
    }
    return true;
  }

  showModal(content) {
    this.modalService.open(content, {centered: true})
      .result.then(
      result => {
      }
    );
  }
}
