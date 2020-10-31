import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Constant } from 'src/app/core/config/constant';

@Component({
  selector: 'app-page-size',
  templateUrl: './page-size.component.html',
  styleUrls: ['./page-size.component.css']
})
export class PageSizeComponent implements OnInit {
  @Input() pageSize
  @Output() pageSizeChange = new EventEmitter<number>();
  pageSizeOptions = Constant.PAGE_SIZE_OPTION

  constructor() {}

  ngOnInit() {}

  changePageSize() {
    this.pageSizeChange.emit(this.pageSize);
  }
}
