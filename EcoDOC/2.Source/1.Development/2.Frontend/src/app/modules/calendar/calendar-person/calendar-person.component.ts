import {
  Component,
  OnInit,
  ViewChild,
  TemplateRef
} from '@angular/core';
import {DatePipe} from "@angular/common";
import {NgbModal, NgbTimepickerConfig} from '@ng-bootstrap/ng-bootstrap';
import moment from 'moment';
import {
  isSameDay,
  isSameMonth,
} from 'date-fns';

import {Subject} from 'rxjs';
import {
  CalendarEvent,
  CalendarEventAction,
  CalendarEventTimesChangedEvent
} from 'angular-calendar';
import {CategoryService} from "../../../services/category.service";
import {ApiHelper} from "../../../core/rest/api-helper";
import {TranslateService} from "@ngx-translate/core";
import {Router} from "@angular/router";
import {CalendarService} from "../../../services/calendar.service";
import {SharedPreferences} from "../../../core/config/shared-preferences";
import {Calendar} from "../../../core/model/domain/calendar"

const colors: any = {
  red: {
    primary: '#ad2121',
    secondary: '#FAE3E3'
  },
  blue: {
    primary: '#1e90ff',
    secondary: '#D1E8FF'
  },
  grey: {
    primary: '#8d8d8d',
    secondary: '#747474'
  },
  yellow: {
    primary: '#e3bc08',
    secondary: '#FDF1BA'
  }
};

@Component({
  selector: 'app-calendar-person',
  templateUrl: './calendar-person.component.html'
})
export class CalendarPersonComponent implements OnInit {
  constructor(private modal: NgbModal,
              private modalService: NgbModal,
              private apiHelper: ApiHelper,
              private categoryService: CategoryService,
              private translateService: TranslateService,
              private calendarService: CalendarService,
              private router: Router,
              private datePipe: DatePipe,
              private config: NgbTimepickerConfig) {
    config.seconds = false;
    config.spinners = false;
    SharedPreferences.IS_LOADING_CONTEN = true;
  }

  users = [];
  calendars: any[];
  viewDate: Date = new Date();
  event: any = [];

  ngOnInit() {
    this.doChangeCalendar();
  }

  doChangeCalendar() {
    let month = this.viewDate.getUTCMonth() + 1; //months from 1-12
    let day = this.viewDate.getUTCDate();
    let year = this.viewDate.getUTCFullYear();
    this.getCalendar(month, year);
  }

  getCalendar(month: number, year: number) {
    this.calendarService.getCalendar(month, year).subscribe(data => {
      this.calendars = data;
      this.parseCalendarToEvent();
    })
  }

  parseCalendarToEvent() {
    if (this.calendars) {
      this.event = [];
      this.calendars.forEach((item, index) => {
        this.event.push({
          id: index,
          start: moment(item.startTime, "DD/MM/YYYY HH:mm").toDate(),
          end: moment(item.endTime, "DD/MM/YYYY HH:mm").toDate(),
          title: item.title,
          color: colors.blue,
          actions: this.actions
        })
      })
    }
    SharedPreferences.IS_LOADING_CONTEN = false;
  }

  checkisLoading() {
    return SharedPreferences.IS_LOADING_CONTEN;
  }

  @ViewChild('calendarInfo', {static: true})
  modalContent: TemplateRef<any>;

  view_calendar = 'list';

  calendar_type = 'week';

  calendar: Calendar = new Calendar();

  changeViewPage(status) {
    this.router.navigate(['/calendar/add']);
  }

  modalData: {
    action: string;
    event: CalendarEvent;
  };

  actions: CalendarEventAction[] = [
    {
      label: '<i class="fa fa-fw fa-pencil text-white"></i>',
      onClick: ({event}: { event: CalendarEvent }): void => {
        this.handleEvent('Edited', event);
      }
    },
    {
      label: '<i class="fa fa-fw fa-times  text-white"></i>',
      onClick: ({event}: { event: CalendarEvent }): void => {
        this.event = this.event.filter(iEvent => iEvent !== event);
        this.handleEvent('Deleted', event);
      }
    }
  ];

  refresh: Subject<any> = new Subject();
  locale: string = 'vi';
  activeDayIsOpen = true;

  dayClicked({date, events}: { date: Date; events: CalendarEvent[] }): void {
    console.log("Click to create event");
    if (isSameMonth(date, this.viewDate)
    ) {
      if (
        (isSameDay(this.viewDate, date) && this.activeDayIsOpen === true) ||
        events.length === 0
      ) {
        this.activeDayIsOpen = false;
      } else {
        this.activeDayIsOpen = true;
        this.viewDate = date;
      }
    }
  }

  eventTimesChanged({event, newStart, newEnd}: CalendarEventTimesChangedEvent): void {
    event.start = newStart;
    event.end = newEnd;
    this.handleEvent('Dropped or resized', event);
    this.refresh.next();
  }

  handleEvent(action: string, event: CalendarEvent): void {
    this.modalData = {event, action};
    this.calendar = this.calendars[event.id];
    console.log(this.calendar)
    this.calendarService.getCalendarJoin(this.calendar.id).subscribe(data => {
      console.log(data);
      this.calendar.calendarJoin = data;
    })
    //this.calendar.startTime = this.datePipe.transform(event.start, 'dd/MM/yyyy', null, "vi");
    //this.calendar.endTime = this.datePipe.transform(event.end, 'dd/MM/yyyy', null, "vi");
    this.modal.open(this.modalContent, {size: 'lg'});
  }

}
