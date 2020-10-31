import {Category} from "./category";
import {CalendarJoin} from "./calendar-join";
import {NgbDate} from "@ng-bootstrap/ng-bootstrap";

export class Calendar {
  id: number;
  title: string;
  type: string;
  description: string;
  address: string;
  roomId: string;
  dateStart: any;
  dateEnd: any;
  timeStart: string;
  timeEnd: string;
  startTime: string;
  endTime: string;
  schedureType: string;
  room: Category;
  catType: Category;
  calendarJoin: CalendarJoin
}
