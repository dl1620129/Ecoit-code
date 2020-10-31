import {Component, AfterViewInit, OnInit, Input} from '@angular/core';
import * as c3 from 'c3';

@Component({
  selector: 'app-device-visits',
  templateUrl: './device-visits.component.html'
})
export class DeviceVisitsComponent implements OnInit {
  constructor() {
  }

  @Input() typeDocument: number = 0;

  documentWait = 0;
  documentProcess = 0;
  documentComplete = 0;
  title = "";
  classBinding = "#documentIn";
  colorPattern = ['#4798e8', '#ff7676', '#f6f6f6'];
  typeChart = "pie";

  ngOnInit() {
    this.doLoadData();
  }

  doInitChart() {
    const chart = c3.generate({
      bindto: this.classBinding,
      data: {
        columns: [['Hoàn thành', this.documentComplete], ['Đang xử lý', this.documentProcess], ['Chờ xử lý', this.documentWait]],
        type: this.typeChart
      },
      donut: {
        label: {
          show: false
        },
        title: this.title,
        width: 25
      },
      legend: {
        hide: true
      },
      color: {
        pattern: this.colorPattern
      }
    });
  }

  doLoadData() {
   
  }
}
