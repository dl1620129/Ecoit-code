import { Injectable } from '@angular/core';
import { ApiHelper } from '../core/rest/api-helper';
import { Constant } from '../core/config/constant';
import { map } from 'rxjs/operators';
import { Category } from '../core/model/domain/category';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categories: Category[];
  categoryTypeSelectedId: number;

  constructor(
    private apiHelper: ApiHelper,
  ) { }

  // Start service for category type
  getAllCategoryType(): Observable<any[]> {
    return this.apiHelper.get(Constant.CATEGORYTYPE.GET_ALL + Constant.DIRECTION.ASC + "/id").pipe(map(res => res.data));
  }

  getAllCatalogyTypeWithPaging(params={}): Observable<any> {
    return this.apiHelper.get(Constant.CATEGORYTYPE.GET_ALL_WITH_PAGING + Constant.DIRECTION.ASC + "/id", {params}).pipe(map(res => res.data));
  }

  doSaveCategoryType(categoryType, categoryTypeId): Observable<any> {
    categoryType.name = categoryType.name.trim();
    return this.apiHelper.post(Constant.CATEGORYTYPE.UPDATE + categoryTypeId, categoryType).pipe(map(res => res.data));
  }

  doSaveNewCategoryType(categoryType): Observable<any> {
    categoryType.name = categoryType.name.trim();
    return this.apiHelper.post(Constant.CATEGORYTYPE.ADD, categoryType).pipe(map(res => res.data));
  }

  activeCategoryType(categoryTypeId): Observable<any> {
    return this.apiHelper.get(Constant.CATEGORYTYPE.ACTIVE + categoryTypeId).pipe(map(res => res.data));
  }

  deactiveCategoryType(categoryTypeId): Observable<any> {
    return this.apiHelper.get(Constant.CATEGORYTYPE.DEACTIVE + categoryTypeId).pipe(map(res => res.data));
  }

  doDeleteCategoryType(categoryTypeId): Observable<any> {
    return this.apiHelper.post(Constant.CATEGORYTYPE.DELETE + categoryTypeId, null);
  }
  // End service for category type

  // Start service for category
  getAllCategory(categoryTypeId): Observable<any[]> {
    return this.apiHelper.get(Constant.CATEGORY.GET_BY_CATEGORY_TYPE_ID + categoryTypeId).pipe(map(res => res.data));
  }

  getAllCategoryQueryParams(categoryTypeId, query): Observable<any> {
    return this.apiHelper.get(Constant.CATEGORY.GET_BY_CATEGORY_TYPE_ID_PAGING + categoryTypeId, {params: query})
                          .pipe(map(res => res.data));
  }

  getCategoryWithCode(categoryTypeCode) {
    return this.apiHelper.get(Constant.CATEGORY.GET_BY_CATEGORY_TYPE_CODE + categoryTypeCode).pipe(map(res => res.data));
  }

  getAllMapCategory() {
    return this.apiHelper.get(Constant.MAP_CATEGORY.GET_ALL).pipe(map(res => res.data));

  }

  doSaveCategory(category, categoryId): Observable<any> {
    category.name = category.name.trim();
    return this.apiHelper.post(Constant.CATEGORY.UPDATE + categoryId, category).pipe(map(res => res.data));
  }

  doSaveNewCategory(category): Observable<any> {
    category.name = category.name.trim();
    return this.apiHelper.post(Constant.CATEGORY.ADD, category).pipe(map(res => res.data));
  }

  activeCategory(categoryId): Observable<any> {
    return this.apiHelper.get(Constant.CATEGORY.ACTIVE + categoryId).pipe(map(res => res.data));
  }

  deactiveCategory(categoryId): Observable<any> {
    return this.apiHelper.get(Constant.CATEGORY.DEACTIVE + categoryId).pipe(map(res => res.data));
  }

  doDeleteCategory(categoryId): Observable<any> {
    return this.apiHelper.post(Constant.CATEGORY.DELETE + categoryId, null);
  }

  getTimes(): Observable<any> {
    return this.apiHelper.get(Constant.CALENDAR.GET_TIME).pipe(map(res => res.data));
  }
  // End service for category
}
