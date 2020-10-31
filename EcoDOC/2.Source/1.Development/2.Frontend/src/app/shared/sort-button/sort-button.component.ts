import { Component, OnInit, Input } from '@angular/core';
import { Constant } from 'src/app/core/config/constant';

@Component({
  selector: 'app-sort-button',
  templateUrl: './sort-button.component.html',
  styleUrls: ['./sort-button.component.css']
})
export class SortButtonComponent implements OnInit {
  @Input() sortType
  
  listSortType = Constant.SORT_TYPE

  constructor() { }

  ngOnInit() {
  }

}
