import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categoryTypeId: number

  constructor(public categorySerice: CategoryService) { }

  ngOnInit() {
  }
  

  onReceiveCategoryTypeId(categoryTypeId: number) {
    this.categoryTypeId = categoryTypeId
    console.log("all", categoryTypeId)
  }
}
