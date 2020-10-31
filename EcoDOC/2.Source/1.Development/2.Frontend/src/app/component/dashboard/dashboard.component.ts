import {Component, OnInit} from '@angular/core';
import {SharedPreferences} from '../../core/config/shared-preferences';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent implements OnInit {

  constructor() {
    SharedPreferences.IS_LOADING_CONTEN = false;
  }

  ngOnInit() {
  }
}
