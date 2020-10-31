import {Component, OnInit} from '@angular/core';
import {CalendarService} from '../../../services/calendar.service';
import {FormControl, FormGroup} from '@angular/forms';

enum TabNames {
  DAPHEDUYET = 'dapheduyet',
  CHUAPHEDUYET = 'chuapheduyet'
}

@Component({
  selector: 'app-calendar-approved',
  templateUrl: './calendar-approved.component.html',
  styleUrls: ['./calendar-approved.component.css']
})
export class CalendarApprovedComponent implements OnInit {
  fromGroup = new FormGroup({
    title: new FormControl()
  });
  listCalendar: any;
  status: number = 2;
  tabTaskAprrove = [
    {name: TabNames.DAPHEDUYET, disabled: false, title: 'Đã phê duyệt', data: []},
    {name: TabNames.CHUAPHEDUYET, disabled: false, title: 'Chưa phê duyệt', data: []}
  ];

  constructor(private calendarService: CalendarService) {
  }

  ngOnInit() {
    this.findByBookBy();
  }


  unSelected(data) {
    if (data != null) {
      data.forEach(x => {
        if (x.isChecked) {
          x.isChecked = false;
        }
      });
    }
  }

  onTabSelect(event) {
    if (event.activeId == TabNames.DAPHEDUYET) {
      this.unSelected(this.tabTaskAprrove[0].data);
      this.status = 1;
      this.findByBookBy();
    } else if (event.activeId == TabNames.CHUAPHEDUYET) {
      this.unSelected(this.tabTaskAprrove[1].data);
      this.status = 2;
      this.findByBookBy();
    }
  }

  findByBookBy() {
    this.calendarService.finByBookBy(this.status).subscribe(result => {
      this.listCalendar = result;
    });
  }

  findByName() {
    const title = this.fromGroup.get('title').value;
    this.calendarService.finByName(this.status, title).subscribe(result => {
      console.log(result);
      this.listCalendar = result;
    });

  }

}
